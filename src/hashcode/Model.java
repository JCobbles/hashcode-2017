package hashcode;

import hashcode.Models.CacheServer;
import hashcode.Models.Endpoint;
import hashcode.Models.Video;

public class Model
{
    private Video[] videosAtDataCenter;
    private CacheServer[] cacheServers;
    private Endpoint[] endpoints;

    public Model(Video[] videosAtDataCenter, CacheServer[] cacheServers, Endpoint[] endpoints)
    {
        this.videosAtDataCenter = videosAtDataCenter;
        this.cacheServers = cacheServers;
        this.endpoints = endpoints;
    }
}
