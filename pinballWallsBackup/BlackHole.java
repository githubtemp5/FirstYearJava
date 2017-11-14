import java.awt.*;
import java.util.ArrayList;
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

public class BlackHole extends CircleObject
{
    private int property;
    private ArrayList<PinBall> pinballs;
    private int xBall;
    private int yBall;
    private int radiusBall;
    private double diffX;
    private double diffY;
    private double centreDistance;
    /**
     * Constructor for objects of class BlackHole
     * 
     * @param xPos      the horizontal coordinate of the object
     * @param yPos      the vertical coordinate of the object
     * @param objectRadius      the radius(in pixels) of the object
     * @param theMachine        the machine this object is in
     */
    
    public BlackHole(int xPos, int yPos, int objectRadius, Machine theMachine)
    {
      super(xPos, yPos, Color.BLACK, objectRadius, theMachine);
      pinballs = machine.getPinballs();
      property = 5;
    }
    
    public void active()
    {
        // remove from universe at the current position
        machine.erase(this);
        
        for(PinBall ball: pinballs){
            xBall = ball.getXPosition();
            yBall = ball.getYPosition();
            radiusBall = ball.getRadius();
            
            diffX = Math.pow(currentXLocation - xBall, 2);
            diffY = Math.pow(currentYLocation - yBall, 2);
            
            centreDistance = Math.sqrt(Math.pow(diffX,  2) - Math.pow(diffY, 2));
            
            
        }
        
        
        
        // draw again at new position
        machine.draw(this);
    }
}
