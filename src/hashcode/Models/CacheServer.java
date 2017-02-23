/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.Models;

import java.util.ArrayList;
import java.util.List;

import static hashcode.Model.cacheServerSize;

/**
 * @author jacob
 */
public class CacheServer {

    private List<Integer> videoIds = new ArrayList<>();
    private int freeSpace;
    private int id;

    public CacheServer(int id) {
        freeSpace = cacheServerSize;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addVideoById(int id, int spaceUsed) {
        videoIds.add(id);
        freeSpace -= spaceUsed;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public List<Integer> getVideos() {
        return videoIds;
    }
}
