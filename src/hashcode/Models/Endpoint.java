package hashcode.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Endpoint
{
    //cacheServerIndex, latencyToDataCenter
    private Map<Integer, Integer> map;
    private int latencyToDataCenter;
    private int endpointId;

    public Endpoint(int id, int latencyToDataCenter)
    {
        endpointId = id;
        map = new HashMap<>();
        this.latencyToDataCenter = latencyToDataCenter;
    }

    public int getLatencyToDataCenter()
    {
        return latencyToDataCenter;
    }

    public void addCacheServer(int id, int latency)
    {
        map.put(id, latency);
    }

    @Override
    public String toString()
    {
        return "id: " + endpointId + " latencyToDataCenter: " + latencyToDataCenter + " latencyToDataCacheServers: " + map;
    }

    public ArrayList<Integer> getSortedCacheServers()
    {
        map.entrySet();
        return sortedCacheServers;
    }
}
