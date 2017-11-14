import java.util.*;
public class EndPoint
{
    private int 
    private int dataLatency;
    private Cache[] caches;

    public EndPoint(int _dataLatency, int _noCaches)
    {
     dataLatency = _dataLatency;
     caches = new Cache[_noCaches];
    }

}
