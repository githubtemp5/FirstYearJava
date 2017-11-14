public class Cake {

    private String name;
    private String type;
    private String writing;
    private int candles;
    

    public Cake(String customerName, String cakeType, String cakeWriting, int noCandles) {
        name = customerName;
        type = cakeType;
        writing = cakeWriting;
        candles = noCandles;
    }
    
    public String getWriting() {
        return writing;
    }
    
    public void changeWriting(String newWriting) {
        writing = newWriting;
    }
    
    public int getCandles() {
        return candles;
    }
    
    public void changeCandles(int newCandles) {
        if(newCandles >= 0){
            candles = newCandles;
        }
        else{
            System.out.println("Cannot have negative number of candles.");
        }
        
    }
    
    public void print() {
        System.out.println("Cake Order Information");
        System.out.println("Cake Ordered By: " + name);
        System.out.println("Cake Type: " + type);
        System.out.println("Cake Writing: " + writing);
        System.out.println("Number of Candles: " + candles);
    }
}
