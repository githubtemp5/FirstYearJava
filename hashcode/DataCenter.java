import java.util.*;
public class DataCenter
{
    public ArrayList<Video> videos;
    public DataCenter()
    {
        videos = new ArrayList<Video>();
    }
    
    public void addVideo(Video v){
        videos.add(v);
    }
    
    public int getNoOfVideos(){
        return videos.size();
    }

}
