package hashcode;

import hashcode.Models.Endpoint;
import hashcode.Models.RequestDescription;
import hashcode.Models.Video;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author jacob
 */
public class HashCode
{
    private static Model model;

    public static void main(String[] args) throws FileNotFoundException
    {
        runForFile("in");
        runForFile("kittens");
        runForFile("me_at_the_zoo");
        runForFile("trending_today");
        runForFile("videos_worth_spreading");
    }

    public static void runForFile(String filename) throws FileNotFoundException
    {
        int numberOfVideos, numberOfEndpoints, numberOfRequestDescriptions, numberOfCacheServers, cacheServerSize;

        File file = new File(filename + ".in");
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
        int[] videosDescription = getIntegerArray(inputFile.nextLine());

        for (int i = 0; i < numberOfVideos; i++)
        {
            videos[i] = new Video(videosDescription[i]);
        }

        // endpoints
        for (int i = 0; i < numberOfEndpoints; i++)
        {
            int[] endpointDescription = getIntegerArray(inputFile.nextLine());
            int latency = endpointDescription[0];
            int cachesAttached = endpointDescription[1];
            Endpoint endpoint = new Endpoint(i, latency);

            for (int j = 0; j < cachesAttached; j++)
            {
                String[] thisEndpointDescription = inputFile.nextLine().split(" ");

                endpoint.addCacheServer(
                        Integer.parseInt(thisEndpointDescription[0]),
                        Integer.parseInt(thisEndpointDescription[1]));
            }
            endpoints[i] = endpoint;
        }

        // request descriptions
        for (int i = 0; i < numberOfRequestDescriptions; i++)
        {
            int[] requestDescription = getIntegerArray(inputFile.nextLine());
            int videoId = requestDescription[0];
            int endpointId = requestDescription[1];
            int numOfRequests = requestDescription[2];
            requests[i] = new RequestDescription(numOfRequests, videoId, endpointId);
        }

        model = new Model(numberOfCacheServers, cacheServerSize, videos, endpoints, requests);
//        model.display();

        model.sortRequests();
//        model.displayRequests();

        model.cacheVideos();
        model.displayCache();

        model.writeOutput(filename);
    }

    private static int[] getIntegerArray(String line)
    {
        int[] v = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        return v;
    }
}
