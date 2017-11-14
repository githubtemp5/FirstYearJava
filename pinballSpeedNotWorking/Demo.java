import java.awt.*;
import java.util.*;

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
        machine = new Machine("Simulation", 1000, 500);
        sampleDemo();
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        PinBall9 pin9a = new PinBall9(50, 50, 5, 9, Color.MAGENTA, 30, machine);
        PinBall9 pin9b = new PinBall9(100, 50, 6, 9, Color.YELLOW, 20, machine);
        PinBall9 pin9c = new PinBall9(150, 50, -3, -9, Color.CYAN, 25, machine);
        PinBall3 pin3a = new PinBall3(200, 50, 7, 9, Color.RED, 20, machine);
        PinBall3 pin3b = new PinBall3(250, 50, -7, 9, Color.BLUE, 22, machine);
        PinBall3 pin3c = new PinBall3(300, 50, 7, 9, Color.GREEN, 23, machine);
        
        machine.addPinBall(pin9a);
        machine.addPinBall(pin9b);
        machine.addPinBall(pin9c);
        machine.addPinBall(pin3a);
        machine.addPinBall(pin3b);
        machine.addPinBall(pin3c);
        
        Hole h1 = new Hole(150, 40, 20, machine);
        Hole h2 = new Hole(500, 200, 30, machine);
        machine.addHole(h1);
        machine.addHole(h2);
        
        Bumper bum1 = new Bumper(500, 250, 20, machine);
        Bumper bum2 = new Bumper(300, 88, 10, machine);
        machine.addBumper(bum1);
        machine.addBumper(bum2);

        while(machine.ifGameNotOver())      //if game not over, keep it running
        {
            // small delay
            machine.pauseMachine();    
            
            bum1.active();
            bum2.active();
            h1.active();
            h2.active();
            for(PinBall pin: machine.getPinballs())
            {
                if(pin.ifActive())
                {
                    pin.move();
                }
                machine.drawMachine();
            }
            
            
        }
    }
}
