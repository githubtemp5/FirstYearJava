import java.util.*;

public class Dog extends Canine
{
    private Random playtime;
    
    public Dog(String animalFood, String animalHome)
    {
        super(animalFood, animalHome, "Bark");
        playtime = new Random();
    }

    public boolean playtimeWanted()
    {
        return playtime.nextBoolean();
    }
    
    public void play()
    {
        if(playtimeWanted())
        {
            System.out.println("I want my human to play with me");
            wagTail();
        }
        else
        {
            System.out.println("I don't want my human to play with me");
        }
    }
}
