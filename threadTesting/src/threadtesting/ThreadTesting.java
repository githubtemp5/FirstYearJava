package threadtesting;

/**
 *
 * @author up826133
 */
public class ThreadTesting {
    protected int v1;
    private int v2;
    public ThreadTesting(){
        
    }
    public ThreadTesting(int _v1, int _v2)
    {
        v1 = _v1;
        v2 = _v2;
        
       
    }
     public void setv(int x, int y)
        {
        v1 = x;
        v2 = y;
        }
                        
    public static void main(String[] args) {
        ThreadTesting t1 = new ThreadTesting(1 ,5);
        ThreadTesting t2 = new ThreadTesting();
        ThreadTesting t3 = new ThreadTesting();
        
        t2 = t1;
        t3 = t2;
        
        t2.v1 = 70;
        t2.v2 = 80;
        
        t3.setv(900, 800);
        System.out.println(t1.v1);
        System.out.println(t2.v2);
    }
    
}


//Test