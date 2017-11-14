import java.util.*;

public class Wolf extends Canine
{
    private Random randomFood;
    
    public Wolf(String animalFood, String animalHome)
    {
        super(animalFood, animalHome, "Growl");
        randomFood = new Random();
    }
    
    public boolean catchFood()
    {
        return randomFood.nextBoolean();
    }
    
    public void huntFood()
    {
        if(catchFood())
        {
            System.out.println("I've caught some food!");
        }
        else
        {
            System.out.println("I've not caught any food!");
        }
    }
    
    
    
    
    
    
    
    
    
    // This method will override the eat() method in the superclass
    public void eat()
    {
        if(getHunger())
        {
            System.out.println("I'm really hungry, I'm going to try to hunt some food!");
            huntFood();
        }
        else
        {
            System.out.println("I'm not hungry");
        }
    
    }
    
    public void eat(String caughtFood)
    {
        if(getHunger())
        {
            System.out.println("I'm hungry, and I've caught a " + caughtFood);
            if(caughtFood.equals(food))
            {
                System.out.println("Yum, I like " + caughtFood);
            }
            else
            {
                System.out.println("Yuck, I don't like " + caughtFood + " but I'm really hungry so I'll eat it anyway");
            }
        }
        else
        {
            System.out.println("I'm not hungry");
        }
    
    }
}
