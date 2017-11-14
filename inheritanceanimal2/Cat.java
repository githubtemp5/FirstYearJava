import java.util.*;

public class Cat extends Feline
{
    private Random fuss;
    
    public Cat(String animalFood, String animalHome)
    {
        super(animalFood, animalHome, "Miaow");
        fuss = new Random();
    }

    public boolean attentionWanted()
    {
        return fuss.nextBoolean();
    }
    
    public void getFuss()
    {
        if(attentionWanted())
        {
            System.out.println("I want my human to give me attention");
            purr();
        }
        else
        {
            System.out.println("I don't want my human to give me attention");
        }
    }
}
