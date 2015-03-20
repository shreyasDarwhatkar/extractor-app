package edu.calstatela.cs454.instructor.crawler.extractor_app;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			String startDir = args[1];
			System.out.println("Extraction Started...");
			new Extractor().walk(startDir);
			System.out.println("Extraction completed and written to Control.json");
		} catch (Exception ex) {
		
		}
	}
}
