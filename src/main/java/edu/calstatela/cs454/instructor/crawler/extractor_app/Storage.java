package edu.calstatela.cs454.instructor.crawler.extractor_app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class Storage {

	private static JSONArray jsonArr = new JSONArray();
	
	public static void saveArray() throws IOException{
		FileWriter file = new FileWriter(".\\Control.json",false);
		file.write(jsonArr.toJSONString());
		file.write("\r\n");
		file.flush();
		file.close();
		
	}

	@SuppressWarnings("unchecked")
	public void saveMetadata(String filePath, String url) throws SAXException, TikaException {
		try {
			Document doc = Jsoup.parse(new File(filePath), "utf-8");
			DataWeb data = new DataWeb();
			data.setUrl(url);
			data.setPath(filePath);
			Elements urlLinks = doc.select("a[href]");
			HashMap<String, String> linkMap = new HashMap<String, String>();
			for (Element ele : urlLinks) {
				if(!ele.attr("abs:href").equals(""))
					linkMap.put(ele.text(), ele.attr("abs:href"));
			}
			data.setLinks(linkMap);
			
			
			File f = new File(filePath);
			Parser parser = new AutoDetectParser();
		      BodyContentHandler handler = new BodyContentHandler(10*1024*1024);
		      Metadata metadata = new Metadata();
		      try{
		      FileInputStream inputstream = new FileInputStream(f);
		      ParseContext context = new ParseContext();
		      
		      parser.parse(inputstream, handler, metadata, context);
		      }catch(Exception e){e.printStackTrace();}
		    
		      HashMap<String, String> metaDataMap = new HashMap<String, String>();
		      for(String key : metadata.names()){
		    	  metaDataMap.put(key, metadata.get(key).toString());
		      }
		      data.setFileMetaData(metaDataMap);
			
			
			data.createJSON();
			
			jsonArr.add(data.getJson());
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void extractMetaData(String fileName, String url) {
		try {
			FileWriter metadataFile = new FileWriter(
					"./CrawlerStorage/metadata.json", true);
			JSONObject json = new JSONObject();

			File dirLoc = new File("./CrawlerStorage");
			for (File file : dirLoc.listFiles()) {
				if (file.isDirectory() && file.getName().equals(fileName)) {
					for (File jsonFile : file.listFiles()) {
						if (jsonFile.getName().equals(fileName + ".json")) {
							JSONParser jsonParser = new JSONParser();
							JSONObject jsonObject = (JSONObject) jsonParser
									.parse(new FileReader(jsonFile));

							json.put("URL", url);
							json.put("File Name", fileName);
							json.put("MetaData", jsonObject.get("Metadata"));

							metadataFile.write(json.toJSONString());
							metadataFile.write("\r\n");

						}
					}
				}
			}

			metadataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
