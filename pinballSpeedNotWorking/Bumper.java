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

    }

}
