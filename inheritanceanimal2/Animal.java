import java.util.*;

public class Animal
{
    protected String food;
    protected String home;
    private String noise;
    private Random hunger;
    
    public Animal()
    {
        food = "Pistachios";
        home = "Trees";
        noise = "Roar";
        hunger = new Random();
    
    }
    
    public Animal(String animalFood, String animalHome, String animalNoise)
    {
        food = animalFood;
        home = animalHome;
        noise = animalNoise;
        hunger = new Random();
    }
    
    public boolean getHunger()
    {
        return hunger.nextBoolean();
    }
    
    public void eat()
    {
        if(getHunger())
        {
            System.out.println("I'm really hungry, I'm going to eat now!");
        }
        else
        {
            System.out.println("I'm not hungry");
        }
    
    }
    
    public void makeNoise()
    {
        System.out.println(noise + " " + noise + " " + noise + " " + noise);
    }
    
    public void sleep()
    {
        System.out.println("zzzzZZZZzzzz");
    }
}
