import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * An Object that exists in the pinball machine. If other balls come in contact
 * with it, the ball loses all points. If the size of the ball is the same or smaller
 * than the hole then the ball is removed from the simulation.
 * 
 * 
 * @author (UP826133) 
 * @version (0.4)
 * 
 * 
 */

public class Hole extends CircleObject
{
    private int property;
    private int xBall;
    private int yBall;
    private int radiusBall;
    private double diffX;
    private double diffY;
    private double centreDistance;
    private ArrayList<PinBall> activePinballs;

    /**
     * Constructor for objects of class Hole
     * 
     * @param xPos      the horizontal coordinate of the object
     * @param yPos      the vertical coordinate of the object
     * @param objectRadius      the radius(in pixels) of the object
     * @param theMachine        the machine this object is in
     */
    
    public Hole(int xPos, int yPos, int objectRadius, Machine theMachine)
    {
      super(xPos, yPos, Color.BLACK, objectRadius, theMachine);
      activePinballs = machine.getPinballs();
      property = 5;
    }
    
    /**
     * actively checks if any ball has hit the hole
     */
    
    public void active()
    {
        // remove from universe at the current position
        Iterator <PinBall>  it = activePinballs.iterator();
        while(it.hasNext()){
            PinBall ball = it.next();
            xBall = ball.getXPosition();
            yBall = ball.getYPosition();
            radiusBall = ball.getRadius();
            
            diffX = Math.pow(currentXLocation - xBall, 2);
            diffY = Math.pow(currentYLocation - yBall, 2);
            
            centreDistance = Math.sqrt(diffX + diffY);
            
            if(centreDistance <= radius + radiusBall)
            {
                if(radiusBall <= radius)
                {
                    it.remove();
                   // System.out.println("TOUCHED");
                }
                ball.resetScore();
            }
        }
        machine.updatePinballs(activePinballs);
        
    

        // draw again at new position
        machine.draw(this);
    }
}
