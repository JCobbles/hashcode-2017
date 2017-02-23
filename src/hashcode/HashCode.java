/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import hashcode.Models.Endpoint;
import hashcode.Models.RequestDescription;
import hashcode.Models.Video;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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
        int[] description = getIntegerArray(inputFile.nextLine());
        numberOfVideos = description[0];
        numberOfEndpoints = description[1];
        numberOfRequestDescriptions = description[2];
        numberOfCacheServers = description[3];
        cacheServerSize = description[4];
        Video[] videos = new Video[numberOfVideos];
        Endpoint[] endpoints = new Endpoint[numberOfEndpoints];
        RequestDescription[] requests = new RequestDescription[numberOfRequestDescriptions];

        // videos line
        String[] videosDescription = inputFile.nextLine().split(" ");

        for (int i = 0; i < numberOfVideos; i++) {
            videos[i] = new Video(Integer.parseInt(videosDescription[i]));
        }

        // endpoints
        for (int i = 0; i < numberOfEndpoints; i++) {
            int[] endpointDescription = getIntegerArray(inputFile.nextLine());
            int latency = endpointDescription[0];
            int cachesAttached = endpointDescription[1];
            Endpoint endpoint = new Endpoint(i, latency);

            for (int j = 0; j < cachesAttached; j++) {
                String[] thisEndpointDescription = inputFile.nextLine().split(" ");

                endpoint.addCacheServer(
                        Integer.parseInt(thisEndpointDescription[0]),
                        Integer.parseInt(thisEndpointDescription[1]));
            }
            endpoints[i] = endpoint;
        }

        // request descriptions
        for (int i = 0; i < numberOfRequestDescriptions; i++) {
            int[] requestDescription = getIntegerArray(inputFile.nextLine());
            int videoId = requestDescription[0];
            int endpointId = requestDescription[1];
            int numOfRequests = requestDescription[2];
            requests[i] = new RequestDescription(numOfRequests, videoId, endpointId);
        }

        System.out.println("numberOfCacheServers: " + numberOfCacheServers);
        System.out.println("cacheServerSize: " + cacheServerSize + "MB");
        System.out.println("videos.length: " + videos.length);
        System.out.println(Arrays.toString(videos));
        System.out.println("endpoints.length: " + endpoints.length);
        System.out.println(Arrays.toString(endpoints));
        System.out.println("requests.length: " + requests.length);
        System.out.println(Arrays.toString(requests));

    }

    private static int[] getIntegerArray(String line) {
        int[] v = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        return v;
    }
}
