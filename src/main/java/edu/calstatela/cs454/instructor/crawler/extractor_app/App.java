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
		    String startDir = ".\\CrawlerStorage\\";//args[0];//".";
    		new Crawler().walk(startDir);
	    } catch (Exception ex) {
	        // handle an exception accordingly
	    }
    }
}