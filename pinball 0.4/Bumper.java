import java.awt.*;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * This class extends the CircleObject class as well. It bounces any pinball to the
 * angle they strike the bumper with.
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
public class Bumper extends CircleObject
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
     * Constructor for objects of class Bumper
     * 
     * @param xPos      the horizontal coordinate of the object
     * @param yPos      the vertical coordinate of the object
     * @param objectRadius      the radius(in pixels) of the object
     * @param theMachine        the machine this object is in
     */
    public Bumper(int xPos, int yPos, int objectRadius, Machine theMachine)
    {
       super(xPos, yPos, Color.GRAY, objectRadius, theMachine);  
       activePinballs = machine.getPinballs();
       property = 6;
    }
    
    /**
     * actively checks if any ball has hit the bumper
     */
    public void active()
    {
        machine.erase(this);
        
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
                ball.incrementScoreBy(2);
                ball.changeSpeedXTravel(- ball.getSpeedXTravel());
                ball.changeSpeedYTravel(- ball.getSpeedYTravel());
            }
            
        }
    
                
        // draw again at new position
        machine.draw(this);
        
    }

}
