package hashcode;

import hashcode.Models.CacheServer;
import hashcode.Models.Endpoint;
import hashcode.Models.RequestDescription;
import hashcode.Models.Video;

import java.util.Arrays;

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
        System.out.println("requests.length: " + requests.length);
        System.out.println(Arrays.toString(requests));
    }
}
