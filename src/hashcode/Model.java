package hashcode;

import hashcode.Models.CacheServer;
import hashcode.Models.Endpoint;
import hashcode.Models.RequestDescription;
import hashcode.Models.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Model
{
    private int numberOfCacheServers;
    private int cacheServerSize;
    private Video[] videos;
    private Endpoint[] endpoints;
    private RequestDescription[] requests;

    public Model(int numberOfCacheServers, int cacheServerSize, Video[] videos, Endpoint[] endpoints, RequestDescription[] requests)
    {
        this.numberOfCacheServers = numberOfCacheServers;
        this.cacheServerSize = cacheServerSize;
        this.videos = videos;
        this.endpoints = endpoints;
        this.requests = requests;
    }

    public void display()
    {
        System.out.println("numberOfCacheServers: " + numberOfCacheServers);
        System.out.println("cacheServerSize: " + cacheServerSize + "MB");
        System.out.println("videos.length: " + videos.length);
        System.out.println(Arrays.toString(videos));
        System.out.println("endpoints.length: " + endpoints.length);
        System.out.println(Arrays.toString(endpoints));
        displayRequests();
    }

    public void displayRequests()
    {
        System.out.println("requests.length: " + requests.length);
        System.out.println(Arrays.toString(requests));
    }

    public void sortRequests()
    {
        Arrays.sort(requests, (o1, o2) ->
        {
            float weight1 = (float)(endpoints[o1.getEndpointId()].getLatencyToDataCenter() * o1.getNumberOfRequests()) / videos[o1.getVideoId()].getSize();
            float weight2 = (float)(endpoints[o2.getEndpointId()].getLatencyToDataCenter() * o2.getNumberOfRequests()) / videos[o2.getVideoId()].getSize();

            if(weight1 == weight2)
                return 0;

            if(weight1 > weight2)
                return -1;

            return 1;
        });
    }

    public void cacheVideos()
    {
        for (int i = 0; i < endpoints.length; i++)
        {
            //cache service indices
            ArrayList<Integer> sortedCacheServers = endpoints[i].getSortedCacheServers();
        }

        for(;;)
        {

        }
    }
}
