import java.awt.*;
import java.util.*;
/**
 * CircleObject is the superclass for PinBall. PinBall has a score and two different characteristics as additional properties.
 * 
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
 
public class PinBall3 extends PinBall
{
    private int maxSpeed;
    private int minSpeed;
    
    public PinBall3(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, 2, 3);
        maxSpeed = 3;
        minSpeed = 1;
    }
    
    /**
     * Changes the speed of the pinball. Also overrides the dummy changeSpeed method
     */
    public void changeSpeed()
    {
        Random ran = new Random();
        boolean heads = flipCoin();
        if(heads)
        {
            speedXTravel *= (ran.nextInt(maxSpeed - minSpeed) + minSpeed);
            speedYTravel *= (ran.nextInt(maxSpeed - minSpeed) + minSpeed);
        }
        else
        {
            speedXTravel /= (ran.nextInt(maxSpeed - minSpeed) + minSpeed);
            speedYTravel /= (ran.nextInt(maxSpeed - minSpeed) + minSpeed);
        }
        
       
    }
}
