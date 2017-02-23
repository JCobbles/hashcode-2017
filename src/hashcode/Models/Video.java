package hashcode.Models;

public class Video
{
    int size;

    public Video(int size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "size: " + size + "MB";
    }
}
