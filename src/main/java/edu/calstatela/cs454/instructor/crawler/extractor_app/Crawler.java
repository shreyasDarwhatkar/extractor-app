package edu.calstatela.cs454.instructor.crawler.extractor_app;

import java.io.File;

public class Crawler {

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();
        Storage objstorage=new Storage();
		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				// System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				// adsfadf
				objstorage.saveMetadata(f.getAbsolutePath());

			}
		}
	}
}
