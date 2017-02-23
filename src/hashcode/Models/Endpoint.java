package hashcode.Models;

import java.lang.reflect.Array;
import java.util.*;

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
        //map to arrayList<ServerId, time>
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        arrayList.addAll(entrySet);

        arrayList.sort((o1, o2) ->
        {
            if (o1.getValue() > o2.getValue())
                return 1;
            if (o1.getValue().equals(o2.getValue()))
                return 0;
            return -1;
        });



        return arrayList;
    }
}
