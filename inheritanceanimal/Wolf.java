import java.util.*;

public class Wolf extends Canine
{
    private Random food;
    
    public Wolf(String animalFood, String animalHome)
    {
        super(animalFood, animalHome, "Growl");
        food = new Random();
    }
    
    public boolean catchFood()
    {
        return food.nextBoolean();
    }
    
    public void huntFood()
    {
        if(getHunger() && catchFood())
        {
            System.out.println("I'm hungry, and I've caught some food!");
            eat();
        }
        else if (getHunger())
        {
            System.out.println("I'm hungry, but I haven't caught any food!");
        }
        else
        {
            System.out.println("I'm not hungry!");
        }
    }
}
