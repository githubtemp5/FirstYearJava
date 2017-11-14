public class Cache
{
   private int latency;
   
    public Cache(int _latency)
    {
        latency = _latency;
       
    }
    
    public int getLatency(){
        return latency;
    }
}
