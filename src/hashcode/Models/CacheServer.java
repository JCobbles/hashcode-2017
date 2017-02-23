/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob
 */
public class CacheServer {
    private int size;
    private List<Integer> videoIds = new ArrayList<>();

    public CacheServer(int size)
    {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public void addVideoId(int id) {
        videoIds.add(id);
    }
}
