/**
 * 
 */
package com.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author vinod
 *
 */
public class ExternalFolderWatchService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String inboundPath = System.getProperty("user.home") + "/Desktop/emmett/inbound/";
			//String backupPath = System.getProperty("user.home") + "/Desktop/backup/";
			Path folderPath = Paths.get("/Users/vinod/Desktop/inbound/");
			Path backupPath = Paths.get("/Users/vinod/Desktop/backup/");
			
			//File file = folder.toFile();
			
			for (File file : folderPath.toFile().listFiles()) {
				if (!file.isDirectory()) {
					System.out.println("File : "+file.getAbsolutePath());
				}
			}

			WatchService watchService = folderPath.getFileSystem().newWatchService();
			// Register events
			folderPath.register(watchService, 
					StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			
			
			
			// Start the infinite polling loop
			WatchKey key = null;
			while (true) {
				key = watchService.take();

				// Dequeueing events
				Kind<?> kind = null;
				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					// Get the type of the event
					kind = watchEvent.kind();
					if (StandardWatchEventKinds.OVERFLOW == kind) {
						continue; // loop
					} else if (StandardWatchEventKinds.ENTRY_CREATE == kind) {
						// A new Path was created
						Path newPath = ((WatchEvent<Path>) watchEvent).context();
						newPath = folderPath.resolve(newPath);
						// Output
						System.out.println("New path created: " + newPath.toString());
						System.out.println("file path : "+newPath.toFile().getAbsolutePath());
						
						File file = newPath.toFile();
						if (file.exists()) {
							System.out.println("File Absolute Path :"+file.getAbsolutePath());
						}
						
						Path absPath = newPath;//Paths.get(inboundPath+newPath.getFileName());
						Path backupDir = backupPath.resolve(newPath); //Paths.get(backupPath+newPath.getFileName());
						
						Files.move(absPath, backupDir, StandardCopyOption.REPLACE_EXISTING);
					}
				}

				if (!key.reset()) {
					break; // loop
				}
			}

			// Closes a watch service
			watchService.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
