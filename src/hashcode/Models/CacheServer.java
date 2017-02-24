package hashcode.Models;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public String toString() {
        return "id:" + id + " StoredVideos: " + Arrays.toString(videoIds.toArray()) + " spaceTaken: " + (cacheServerSize - freeSpace) + "/" + cacheServerSize;
    }

    public boolean containsVideoId(int videoId)
    {
        return videoIds.contains(videoId);
    }

    public boolean isEmpty()
    {
        return videoIds.isEmpty();
    }

    public List<Integer> getVideoIds()
    {
        return videoIds;
    }
}
