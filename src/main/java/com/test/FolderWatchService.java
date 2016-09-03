/**
 * 
 */
package com.test;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @author vinod
 *
 */
public class FolderWatchService {
	
	private static void watchService() {
		
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path watchedPath = Paths.get("/Users/vinod/Desktop/emmett/inbound");
			
			WatchKey key = null;
			try {
			    key = watchedPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
			} catch (UnsupportedOperationException uox){
			    System.err.println("filehing not supported!");
			    // handle this error here
			}catch (IOException iox){
			    System.err.println("I/Ors");
			    // handle this error here
			}
			
			
			for(;;){
			    // take() will block until a file has been created/deleted
			    WatchKey signalledKey;
			    try {
			        signalledKey = watchService.take();
			    } catch (InterruptedException ix){
			        // we'll ignore being interrupted
			        continue;
			    } catch (ClosedWatchServiceException cwse){
			        // other thread closed watch service
			        System.out.println("watchice closed, terminating.");
			        break;
			    }

			    // get list of events from key
			    List<WatchEvent<?>> list = signalledKey.pollEvents();

			    // VERY IMPORTANT! call reset() AFTER pollEvents() to allow the
			    // key to be reported again by the watch service
			    signalledKey.reset();

			    // we'll simply print what has happened; real applications
			    // will do something more sensible here
			    for(WatchEvent e : list){
			        String message = "";
			        String absPath = "";
			        Path context = (Path)e.context();
			        context = watchedPath.resolve(context);
		            context.resolve(watchedPath);
			        if(e.kind() == StandardWatchEventKinds.ENTRY_CREATE){
			            absPath = context.toAbsolutePath().toString();
			            message = context.toString() + " created";
			        } else if(e.kind() == StandardWatchEventKinds.ENTRY_DELETE){
			            absPath = context.toAbsolutePath().toString();
			            message = context.toString() + " deleted";
			        } else if(e.kind() == StandardWatchEventKinds.OVERFLOW){
			            message = "OVERFLOW: more changes happened than we could retreive";
			        }
			        System.out.println(message);
			        System.out.println(absPath);
			    }
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		watchService();

	}

}
