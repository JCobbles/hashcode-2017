/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import hashcode.Models.Endpoint;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
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

        //System.out.print("Enter the filename: ");
        String filename = "in.txt";//keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // description line
        String s = inputFile.nextLine();
        String[] description = s.split(" ");
        numberOfVideos = Integer.parseInt(description[0]);
        numberOfEndpoints = Integer.parseInt(description[1]);
        numberOfRequestDescriptions = Integer.parseInt(description[2]);
        numberOfCacheServers = Integer.parseInt(description[3]);
        cacheServerSize = Integer.parseInt(description[4]);
        int[] videos = new int[numberOfVideos];
        Endpoint[] endpoints = new Endpoint[numberOfEndpoints];
        RequestDescription[] requests = new RequestDescription[numberOfRequestDescriptions];
        
        // videos line
        String[] videosDescription = inputFile.nextLine().split(" ");
        
        for (int i = 0; i < numberOfVideos; i++) {
            videos[i] = Integer.parseInt(videosDescription[i]);
        }
        
        for (int i = 0; i < numberOfEndpoints; i++) {
            String[] endpointDescription = inputFile.nextLine().split(" ");
            int latency = Integer.parseInt(endpointDescription[0]);
            int cachesAttached = Integer.parseInt(endpointDescription[1]);
            Endpoint endpoint = new Endpoint(i, latency);

            for (int j = 0; j < cachesAttached; j++) {
                String[] thisEndpointDescription = inputFile.nextLine().split(" ");

                endpoint.addCacheServer(
                        Integer.parseInt(thisEndpointDescription[0]), 
                        Integer.parseInt(thisEndpointDescription[1]));
            }
            endpoints[i] = endpoint;
        }
        
        for (int i = 0; i < numberOfRequestDescriptions; i++) {
            String[] requestDescription = inputFile.nextLine().split(" ");
            int videoId = Integer.parseInt(requestDescription[0]);
            int endpointId = Integer.parseInt(requestDescription[1]);
            int numOfRequests = Integer.parseInt(requestDescription[2]);
            requests[i] = new RequestDescription(numOfRequests, videoId, endpointId);
        }

        System.out.println("videos.length: " + videos.length);
        System.out.println(Arrays.toString(videos));
        System.out.println("endpoints.length: " + endpoints.length);
        System.out.println(Arrays.toString(endpoints));
        System.out.println(Arrays.toString(requests));

    }

    private static void getIntegerArray(String line) {
        
    }
}
