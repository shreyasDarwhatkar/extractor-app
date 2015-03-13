package edu.calstatela.cs454.instructor.crawler.extractor_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

public class Extractor {

	public void walk(String path) throws FileNotFoundException, IOException, ParseException, SAXException, TikaException {

		System.out.println("Started");
		File root = new File(path);
		//System.out.println(path);
		//File[] list = root.listFiles();
        Storage objstorage=new Storage();
        File jsonFile = new File(path+"map.json");
        System.out.println(jsonFile);
        JSONParser jsonParser = new JSONParser();
		//JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(jsonFile));
		JSONArray jsonArr = (JSONArray) jsonParser.parse(new FileReader(jsonFile));
		System.out.println(jsonArr);
		System.out.println("here");
		
		Map<File, String> urlMap = new HashMap<File, String>();
		
		JSONObject jsonObject;
		String key, value;
		key = path;
		for(Object obj : jsonArr){
			jsonObject = (JSONObject) obj;
			key = key + (String) jsonObject.get("filename")+ "\\";
			value = (String) jsonObject.get("url");
			urlMap.put(new File(key),value );
			//System.out.println(jsonObject.get("filename"));
			//System.out.println(jsonObject.get("url"));
			key = path;
		}
		
		System.out.println("Started 2");
		System.out.println(urlMap);
		
		
		
		if (urlMap.keySet() == null)
			return;

		for (File f : urlMap.keySet()) {
			File[] list = f.listFiles();
			
			for(File f1 : list)
				objstorage.saveMetadata(f1.getAbsolutePath(), urlMap.get(f));
		}
	}
}
