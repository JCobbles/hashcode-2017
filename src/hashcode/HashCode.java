/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class HashCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        int numberOfVideos, numberOfEndpoints, numberOfRequestDescriptions, numberOfCacheServers, cacheServerSize;

        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // description line
        String s = inputFile.next();
        String[] description = s.split(" ");
        numberOfVideos = Integer.parseInt(description[0]);
        numberOfEndpoints = Integer.parseInt(description[1]);
        numberOfRequestDescriptions = Integer.parseInt(description[2]);
        numberOfCacheServers = Integer.parseInt(description[3]);
        cacheServerSize = Integer.parseInt(description[4]);
        int[] videos = new int[numberOfVideos];
        
        // videos line
        String[] videosDescription = inputFile.next().split(" ");
        
        for (int i = 0; i < numberOfVideos; i++) {
            videos[0] = Integer.parseInt(videosDescription[i]);
        }
        
        for (int i = 0; i < numberOfEndpoints; i++) {
            String[] endpointDescription = inputFile.next().split(" ");
            int latency = Integer.parseInt(endpointDescription[0]);
            int cachesAttached = Integer.parseInt(endpointDescription[1]);
            for (int j = 0; j < endpointDescription.length; j++) {
                String[] cacheDescription = inputFile
            }
        }
        
    }

}
