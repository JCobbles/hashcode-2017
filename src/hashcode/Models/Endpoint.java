package hashcode.Models;

import java.lang.reflect.Array;
import java.util.*;

public class Endpoint {

    //<cacheServerIndex, latencyToCacheServer>
    private Map<Integer, Integer> map;
    private int latencyToDataCenter;
    private int endpointId;
    ArrayList<Integer> sortedServers = null;

    public Endpoint(int id, int latencyToDataCenter) {
        endpointId = id;
        map = new HashMap<>();
        this.latencyToDataCenter = latencyToDataCenter;
    }

    public boolean hasAnyCacheServers() {
        return map.size() > 0;
    }

    public void addCacheServer(int id, int latency) {
        map.put(id, latency);
    }

    public int getLatencyToDataCenter() {
        return latencyToDataCenter;
    }

    @Override
    public String toString() {
        return "id: " + endpointId + " latencyToDataCenter: " + latencyToDataCenter + " latencyToDataCacheServers: " + map;
    }

    public ArrayList<Integer> getSortedCacheServers() {
        if (sortedServers != null) {
            return sortedServers;
        }

        //map to arrayList<ServerId, time>
        ArrayList<Map.Entry<Integer, Integer>> arrayListOfEntries = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        arrayListOfEntries.addAll(entrySet);

        arrayListOfEntries.sort((o1, o2)
                -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            }
            if (o1.getValue().equals(o2.getValue())) {
                return 0;
            }
            return -1;
        });
        
        sortedServers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : arrayListOfEntries) {
            sortedServers.add(entry.getKey());
        }
        return sortedServers;
    }
}
