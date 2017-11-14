import java.awt.*;

/**
 * This class extends the CircleObject class as well. It bounces any pinball to the
 * angle they strike the bumper with.
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
public class Bumper extends CircleObject
{
    
    public Bumper(int xPos, int yPos, int objectRadius, Machine theMachine)
    {
       super(xPos, yPos, Color.GRAY, objectRadius, theMachine);
    }

}
