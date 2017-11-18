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
    private int totalScore;
    private boolean allBallsInactive;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine();
        sampleDemo();
        totalScore = 0;
        allBallsInactive = true;
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        PinBall9 pin9a = new PinBall9(50, 50, 5, -2, Color.MAGENTA, 30, machine);
        PinBall9 pin9b = new PinBall9(100, 50, 6, 4, Color.YELLOW, 20, machine);
        PinBall9 pin9c = new PinBall9(400, 50, -3, -3, Color.CYAN, 25, machine);
        
        PinBall3 pin3a = new PinBall3(200, 50, 7, 1, Color.RED, 20, machine);
        PinBall3 pin3b = new PinBall3(250, 100, 5, -2, Color.BLUE, 22, machine);
        PinBall3 pin3c = new PinBall3(300, 300, 7, 6, Color.GREEN, 23, machine);
        
        machine.addPinBall(pin9a);
        machine.addPinBall(pin9b);
        machine.addPinBall(pin9c);
        machine.addPinBall(pin3a);
        machine.addPinBall(pin3b);
        machine.addPinBall(pin3c);
        
        Hole h1 = new Hole(150, 40, 20, machine);
        Hole h2 = new Hole(500, 150, 30, machine);
        machine.addHole(h1);
        machine.addHole(h2);
        
        Bumper bum1 = new Bumper(500, 250, 30, machine);
        Bumper bum2 = new Bumper(290, 150, 30, machine);
        machine.addBumper(bum1);
        machine.addBumper(bum2);

        while(machine.ifGameNotOver())      //if game not over, keep it running
        {
            // small delay
            machine.pauseMachine();    
            
            allBallsInactive = true;
            bum1.active();
            bum2.active();
            h1.active();
            h2.active();
            
            //moves the pinball only if it is active
            for(PinBall pin: machine.getPinballs()) //loops through all pinballs
            {       
                if(pin.ifActive())
                {
                    pin.move();
                    allBallsInactive = false;
                }
                machine.drawMachine();
            }
            if(allBallsInactive)        //if all pinballs become inactive because of a blackhole then the game ends as well
            {
                machine.gameOver();
            } 
              
        }
        displayFinalScore();
        
    }
    
    /**
     * Adds scores for all the balls and displays it onto the screen
     */
    public void displayFinalScore()
    {
        for(PinBall pin: machine.getPinballs())
        {
            totalScore += pin.getScore();
        }
        //Displaying the score at the end of the game
        machine.drawString("Simulation Over", 300, 225);
        machine.drawString("Total Score: "+ totalScore, 300, 250);
    }
}
