import java.awt.*;
import java.util.*;
/**
 * PinBall9 is a sub-class of the pinball class
 * 
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
public class PinBall9 extends PinBall
{
    private boolean shouldFlash;
    private final Color originalColour;
    public PinBall9(int xPos, int yPos, int xVel, int yVel, Color color, int radius, Machine theMachine)
    {
        super(xPos, yPos, xVel, yVel, color, radius, theMachine, 0, 1);
        shouldFlash = false;
        originalColour = colour;
    }
    
    /**
     * Inverts the shouldFlash boolean, overrides changeFlashState
     */
    public void changeFlashState()
    {
        shouldFlash = !shouldFlash;
        if(!shouldFlash)
        {
            colour = originalColour;
        }
    }
    
    /**
     * Returns the current flashing state as a boolean
     */
    public boolean isFlashing()
    {
        return shouldFlash;
    }
    
    /**
     * Changes the current colour between original white
     */
    public void changeFlashColour()
    {
        if(colour == originalColour)
        {
            colour = Color.WHITE;
        }
        else
        {
            colour = originalColour;
        }
    }
}
