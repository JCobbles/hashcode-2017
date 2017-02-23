package hashcode;

import hashcode.Models.CacheServer;
import hashcode.Models.Endpoint;
import hashcode.Models.RequestDescription;
import hashcode.Models.Video;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Model {

    private int numberOfCacheServers;
    public static int cacheServerSize;
    private Video[] videos;
    private Endpoint[] endpoints;
    private RequestDescription[] requests;

    private CacheServer[] cacheServers;

    public Model(int numberOfCacheServers, int cacheServerSize, Video[] videos, Endpoint[] endpoints, RequestDescription[] requests) {
        this.numberOfCacheServers = numberOfCacheServers;
        this.cacheServerSize = cacheServerSize;
        this.videos = videos;
        this.endpoints = endpoints;
        this.requests = requests;

        cacheServers = new CacheServer[numberOfCacheServers];
        for (int i = 0; i < numberOfCacheServers; i++) {
            cacheServers[i] = new CacheServer(i);
        }
    }

    public void display() {
        System.out.println("numberOfCacheServers: " + numberOfCacheServers);
        System.out.println("cacheServerSize: " + cacheServerSize + "MB");
        System.out.println("videos.length: " + videos.length);
        System.out.println(Arrays.toString(videos));
        System.out.println("endpoints.length: " + endpoints.length);
        System.out.println(Arrays.toString(endpoints));
        displayRequests();
    }

    public void displayRequests() {
        System.out.println("requests.length: " + requests.length);
        System.out.println(Arrays.toString(requests));
    }

    public void sortRequests() {
        Arrays.sort(requests, (o1, o2)
                -> {
            float weight1 = (float) (endpoints[o1.getEndpointId()].getLatencyToDataCenter() * o1.getNumberOfRequests()) / videos[o1.getVideoId()].getSize();
            float weight2 = (float) (endpoints[o2.getEndpointId()].getLatencyToDataCenter() * o2.getNumberOfRequests()) / videos[o2.getVideoId()].getSize();

            if (weight1 == weight2) {
                return 0;
            }

            if (weight1 > weight2) {
                return -1;
            }

            return 1;
        });
    }

    public void cacheVideos() {

        mark:
        for (RequestDescription request : requests) {
            Endpoint associatedEndpoint = endpoints[request.getEndpointId()];
            Video associatedVideo = videos[request.getVideoId()];
            if (!associatedEndpoint.hasAnyCacheServers()) {
                continue;
            }

            List<Integer> cacheServerIds = associatedEndpoint.getSortedCacheServers();
            for (int i : cacheServerIds) {
                CacheServer server = cacheServers[i];
                if (associatedVideo.getSize() > server.getFreeSpace()) {
                    //
                    continue;
                }
                server.addVideoById(request.getVideoId(), associatedVideo.getSize());
                continue mark;
            }
        }
    }

    public void writeOutput() {
        try {
            PrintWriter writer = new PrintWriter("output.out", "UTF-8");
            long numberOfCachesUsed = Stream.of(cacheServers).filter((c) -> c.getFreeSpace() != cacheServerSize).count();
            writer.println(numberOfCachesUsed);
            for (CacheServer server : cacheServers) {
                writer.print(server.getId() + " ");
                for (int i : server.getVideos()) {
                    writer.print(i + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public void displayCache()
    {
        for(CacheServer cacheServer: cacheServers)
        {
            System.out.println(cacheServer);
        }
    }
}
