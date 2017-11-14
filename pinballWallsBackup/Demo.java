import java.awt.*;

/**
 * Class to demonstrate functionality of the Pinball machine
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
public class Demo
{
    private Machine machine;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine("mac", 1000, 500);
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
       
        PinBall p =  new PinBall(200, 40,9, 9, Color.GREEN, 20, machine, 1, 2);
        PinBall p2 = new PinBall(300,300, 7, 8, Color.RED, 15, machine, 1,2);
        machine.addPinBall(p);
        machine.addPinBall(p2);
        BlackHole b = new BlackHole(50, 200, 6, machine);
        
        
       
        //for(int i = 0; i <= 100; i++)
        
        while(machine.ifGameNotOver())      //if game not over, keep it running
        {
            machine.pauseMachine();         // small delay
            p.move();
            p2.move();
            b.active();
        }
         
       
    }
}
