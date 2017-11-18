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
    /**
     * Constructor for objects of class Hole
     * 
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param theMachine  the machine this object is in
     */
    
    public Hole(int xPos, int yPos, int objectRadius, Machine theMachine)
    {
      super(xPos, yPos, Color.BLACK, objectRadius, theMachine);
    }
    
}
