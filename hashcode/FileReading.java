import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class FileReading{
    private String line;
    private FileReader fr;
    private BufferedReader br;
    private int[] read;
    private int noVideos;
    private int endpoints;
    private int requests;
    private int cacheServers;
    private int cacheSize;
    private int[] line1;
    private ArrayList<Video> vid;
 public FileReading(){
     
     line1= new int[5];
     try{
         fr = new FileReader("C://Users/Alvin/Desktop/kittens.in");
         
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
         br = new BufferedReader(fr); 
    }
    public void run(){
       int i = 0;
         
         do{
               try{
       line = null; 
       line = br.readLine();
   
       if(i==0){
           String[] temp = line.split(" ");
           int k =0;
         for ( String j: temp){
            line1[k] = Integer.parseInt(j);
            k++;
        }
      
        noVideos = line1[0];
        endpoints = line1[1];
        requests= line1[2];
        cacheServers = line1[3];
        cacheSize= line1[4];
        
        
   
        }
       
      
       i++;
    }
    catch(Exception e){
        
        System.out.println(e.getMessage());
    }
            
            
           
}
while(line!=(null));
 }
}
    
    