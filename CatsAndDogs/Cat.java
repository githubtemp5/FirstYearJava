
public class Cat {
    
private String name;
private int age;
private String colour;
private boolean isHappy;

    public Cat(String catName, int catAge, String furColour, boolean happy) {
        name = catName;
        age = catAge;
        colour = furColour;
        isHappy = happy;
    }
    
    public Cat (String catName) {
        name = catName;
        age = 1;
        colour = "ginger";
        isHappy = true;
    
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int newAge) {
        age = newAge;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String newColour){
        colour = newColour;
    }
    
    public boolean getHappy() {
        return isHappy;
    }
    
    public void setHappy(String stage) {
        if(stage.equals("happy")){
            isHappy = true;
        }
        else if(stage.equals("sad")){
            isHappy = false;
        }
    }
    
    public void purr() {
        System.out.println("purr purr purr");
    }
    
    public void miaow() {
        System.out.println("miaow miaow miaow");
    }
    
    public void makeNoise() {
        if(isHappy) {
            purr();
        }
        else {
            miaow();
        }
    
    }

}
