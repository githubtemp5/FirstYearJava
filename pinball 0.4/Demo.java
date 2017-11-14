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
        machine = new Machine("Window", 1000, 500);
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        PinBall p =  new PinBall(200, 40,5, 9, Color.GREEN, 15, machine, 1, 2);
        PinBall p2 = new PinBall(300,300, 7, 8, Color.RED, 15, machine, 1,2);
        PinBall p3 =  new PinBall(200, 40,10, 2, Color.BLUE, 15, machine, 1, 2);
        machine.addPinBall(p);
        machine.addPinBall(p3);
        machine.addPinBall(p2);
        Hole b = new Hole(200, 250, 20, machine);
        Bumper bum = new Bumper(500, 250, 40, machine);
        
        
       
        //for(int i = 0; i <= 100; i++)
        
        while(machine.ifGameNotOver())      //if game not over, keep it running
        {
            machine.pauseMachine(); 
            for(PinBall ball: machine.getPinballs())
            {
                    // small delay
            ball.move();
            b.active();
            bum.active();
        }
            
            
            //machine.getPinballs().removeAll(null);
            
           // bum.active();
        }
         
       
    }
}
