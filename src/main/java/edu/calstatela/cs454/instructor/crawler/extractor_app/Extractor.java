package edu.calstatela.cs454.instructor.crawler.extractor_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

public class Extractor {

	public void walk(String jsonPath) throws FileNotFoundException, IOException, ParseException, SAXException, TikaException {

		File root1 = new File(jsonPath);
		String path = root1.getParentFile().toString();
		path = path+"\\";
		Storage objstorage=new Storage();
        File jsonFile = new File(jsonPath);
        JSONParser jsonParser = new JSONParser();
		JSONArray jsonArr = (JSONArray) jsonParser.parse(new FileReader(jsonFile));
		
		Map<File, String> urlMap = new HashMap<File, String>();
		
		JSONObject jsonObject;
		String key, value;
		key = path;
		for(Object obj : jsonArr){
			jsonObject = (JSONObject) obj;
			key = key + (String) jsonObject.get("filename")+ "\\";
			value = (String) jsonObject.get("url");
			urlMap.put(new File(key),value );
			key = path;
		}
		
		if (urlMap.keySet() == null)
			return;

		for (File f : urlMap.keySet()) {
			File[] list = f.listFiles();
			
			for(File f1 : list)
				objstorage.saveMetadata(f1.getAbsolutePath(), urlMap.get(f));
		}
		
		Storage.saveArray();
		
	}
}
