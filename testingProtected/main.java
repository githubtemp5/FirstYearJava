import java.util.*;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    private ArrayList<String> arr;
    private ArrayList<extra> arrString;
    // instance variables - replace the example below with your own
    protected  int x;

    /**
     * Constructor for objects of class main
     */
    public main()
    {
       arr = new ArrayList<String>();
       arr.add("A");
       arr.add("B");
       arr.add("C");
       arrString = new ArrayList<extra>();
    }
    
    public void add(extra e)
    {
        arrString.add(e);
    }
    
    
        public void printX(){
        System.out.println(x+"MAIN CLASS X");
    }
    
    public ArrayList<String> returnStuff()
    {
        return arr;
    }
    
    

}
