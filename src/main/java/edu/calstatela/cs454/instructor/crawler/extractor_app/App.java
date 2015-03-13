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
		    String startDir = "C:\\Users\\Gaurav\\CS454_Web_Search_Engine\\WebCrawler\\target\\CrawlerStorage\\";//args[0];//".";
    		new Extractor().walk(startDir);
	    } catch (Exception ex) {
	        // handle an exception accordingly
	    }
    }
}
