public class Feline extends Animal
{
    public Feline()
    {
        super();
    }
    
   
    //public Feline()
    //{
    //    super("Tuna", "Rainforest", "Whine");
    //}
    
    public Feline(String animalFood, String animalHome, String animalNoise)
    {
        super(animalFood, animalHome, animalNoise);
    }
    
    public void purr()
    {
        System.out.println("Purr Purr Purr Purr");
    }
    
    public String getHome()
    {
        return home;
    }
}
