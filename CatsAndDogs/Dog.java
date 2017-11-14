
public class Dog {

    private String name;
    private double weight;
    private String prefFood;
    
    public Dog(String dogName, double dogWeight, String dogFood) {
        name = dogName;
        weight = dogWeight;
        prefFood = dogFood;
    }
    
    public Dog(String dogName) {
        name = dogName;
        weight = 15;
        prefFood = "Pedigree Chum";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double newWeight){
        weight = newWeight;
    }
        
    public String getPrefFood() {
        return prefFood;
    }
    
    public void setPrefFood(String newFood) {
        prefFood = newFood;
    }
    
    public void bark() {
        System.out.println("woof woof woof");
    }
    
    public void feeding() {
        if(prefFood.equals("Pedigree Chum")){
            System.out.println("Pedigree Chum: "+ (weight*1000) / 40 + "gm(s)");
        }
        if(prefFood.equals("Barkers Chicken")) {
            System.out.println("Barkers Chicken: "+ (weight*1000) / 25 + "gm(s)");
        }
        if(prefFood.equals("Woofers Beef")) {
            System.out.println("Woofers Beef: "+ (weight*1000)/ 20 + "gm(s)");
        }
        
    }
}
