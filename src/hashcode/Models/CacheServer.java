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
public class CacheServer
{
    private List<Integer> videoIds = new ArrayList<>();
    private int freeSpace;

    public CacheServer()
    {
        freeSpace = cacheServerSize;
    }


    public void addVideoId(int id)
    {
        videoIds.add(id);
    }
}
