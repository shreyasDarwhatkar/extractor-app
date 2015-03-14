package edu.calstatela.cs454.instructor.crawler.extractor_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.select.Elements;

public class DataWeb {
	
	String url;
	String path;
	//List<String> links;
	List<DataFile> files;
	Elements elements;
	//List<Link> Urllinks;
	HashMap<String,String> Links;
	JSONObject json;
	JSONObject metadata;
	HashMap<String,String> FileMetaData;

	public DataWeb() {
		super();
		//links = new ArrayList<String>();
		json = new JSONObject();
	}

	public DataWeb(String path, List<String> links, List<DataFile> files,
			Elements elements, JSONObject json) {
		super();
		this.url = url;
		this.path = path;
		//this.links = links;
		this.files = files;
		this.elements = elements;
		this.json = json;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/*public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
*/
	public List<DataFile> getFiles() {
		return files;
	}

	public void setFiles(List<DataFile> files) {
		this.files = files;
	}

	public Elements getElements() {
		return elements;
	}

	public void setElements(Elements elements) {
		this.elements = elements;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void createJSON(){
		this.json.put("URL", url);
		this.json.put("path", path);
		this.json.put("MetaData", FileMetaData);
		this.json.put("links", this.Links);
		
	}

	/*public List<Link> getUrllinks() {
		return Urllinks;
	}

	public void setUrllinks(List<Link> urllinks) {
		Urllinks = urllinks;
	}
*/
	/*public Metadata getMetadata2() {
		return metadata2;
	}

	public void setMetadata2(Metadata metadata2) {
		this.metadata2 = metadata2;
	}
*/
	

	public void setLinks(HashMap<String, String> links) {
		Links = links;
	}

	public JSONObject getMetadata() {
		return metadata;
	}

	public void setMetadata(JSONObject metadata) {
		this.metadata = metadata;
	}
	
	public HashMap<String, String> getFileMetaData() {
		return FileMetaData;
	}

	public void setFileMetaData(HashMap<String, String> fileMetaData) {
		FileMetaData = fileMetaData;
	}
	
	

}
