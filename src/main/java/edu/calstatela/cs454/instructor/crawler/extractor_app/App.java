package edu.calstatela.cs454.instructor.crawler.extractor_app;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
		    //String startDir = "C:\\Users\\Akshay\\cs454seo\\WebCrawler\\target\\CrawlerStorage\\map.json";//args[0];//".";
    		String startDir = args[1];
    		new Extractor().walk(startDir);
	    } catch (Exception ex) {
	        // handle an exception accordingly
	    }
    }
}
