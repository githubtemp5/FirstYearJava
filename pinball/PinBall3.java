import java.awt.*;
import java.util.*;
/**
 * PinBall3 inherits PinBall class and has minimum and maximum speed as additional variables
 * 
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
 
public class PinBall3 extends PinBall
{
    private int maxSpeed;
    private int minSpeed;
    
    /**
     * Constructor for objects of class PinBall3
     * @param xPos                  the horizontal coordinate of the object
     * @param yPos                  the vertical coordinate of the object
     * @param xVel                  the horizontal speed of the object
     * @param yVel                  the vertical speed of the object  
     * @param objectRadius          the radius (in pixels) of the object
     * @param objectColor           the color of the object
     * @param theMachine            the machine this object is in
     */
    public PinBall3(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, 2, 3);
        maxSpeed = 3;
        minSpeed = 1;
    }
    
    /**
     * Changes the speed of the pinball. Also overrides the dummy changeSpeed method
     */
    @Override
    public void changeSpeed()
    {
        Random ran = new Random();
        boolean heads = flipCoin();
        int randXSpeed = ran.nextInt(maxSpeed) + minSpeed;
        int randYSpeed = ran.nextInt(maxSpeed) + minSpeed;
        if(heads)
        {
            speedXTravel *= (randXSpeed);
            speedYTravel *= (randYSpeed);
        }
        else
        {
            speedXTravel *= -(randXSpeed);
            speedYTravel *= -(randYSpeed);           
        }
        
       
    }
}
