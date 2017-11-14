import java.awt.*;
import java.util.Random;
/**
 * CircleObject is the superclass for PinBall. PinBall has a score and two different characteristics as additional properties.
 * 
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
 
public class PinBall extends CircleObject
{
    
private int score;
private int property1;
private int property2;
private int speedXTravel;
private int speedYTravel;
private final int leftWallPosition;
private final int rightWallPosition;
private final int topWallPosition;
private final int bottomWallPosition;
private final int leftBottomWallLength;
private final int gapWidth;

/**
 * Constructor for objects of class PinBall
 * 
 * @param xPos                  the horizontal coordinate of the object
 * @param yPos                  the vertical coordinate of the object
 * @param xVel                  the horizontal speed of the object
 * @param yVel                  the vertical speed of the object  
 * @param objectRadius          the radius (in pixels) of the object
 * @param objectColor           the color of the object
 * @param theMachine            the machine this object is in
 * @param property1             the property when it bounces to a bumper
 * @param property2             the property when it bounces to other pinball
 */

    public PinBall(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, int property1, int property2)
    {
        super(xPos, yPos, objectColor, objectRadius, theMachine);
        speedXTravel = xVel;
        speedYTravel = yVel;
        leftBottomWallLength = machine.getLeftBottomWallLength();
        leftWallPosition = machine.getLeftWall();
        rightWallPosition = machine.getRightWall();
        topWallPosition = machine.getTopWall();
        bottomWallPosition = machine.getBottomWall();
        gapWidth = machine.getGapWidth();
        this.score = 0;
        this.property1 = property1;
        this.property2 = property2;
    }

/**
 * Move this object according to its position and speed and redraw.
 **/
    public void move()
    {
         // remove from universe at the current position
        machine.erase(this);
        
        // compute new position
        currentXLocation += speedXTravel;
        currentYLocation += speedYTravel;
        
          // check if it has hit the leftwall
        if(currentXLocation <= (leftWallPosition + radius)) 
        {
            currentXLocation = leftWallPosition + radius;
            speedXTravel = -speedXTravel;
            score++;
        }
        
        // check if it has hit the rightwall
        if(currentXLocation >= (rightWallPosition - radius))
        {
           currentXLocation = rightWallPosition - radius;
           speedXTravel = -speedXTravel;
           score++;
        }
        
        // check if it has hit the topwall
        if(currentYLocation <= (topWallPosition + radius))
        {
           currentYLocation = topWallPosition + radius;
           speedYTravel = -speedYTravel;
           score++;
        }
        
        //check if it has hit the bottom wall and let the ball go through the gap.
        if(currentYLocation >= (bottomWallPosition - radius))
        {
            //check if it has hit the left bottom wall.
            if(currentXLocation <= (leftBottomWallLength + radius))
            {
                currentYLocation = bottomWallPosition - radius;
                speedYTravel = - speedYTravel;  
                score++;
            }
            //check if it has hit the right bottom wall.
            else if(currentXLocation >= (leftBottomWallLength + (gapWidth*2) - radius ))
            {
                currentYLocation = bottomWallPosition - radius;
                speedYTravel = - speedYTravel;
                score++;
            }
            else if (currentYLocation > bottomWallPosition + 10){
                machine.gameOver();    
            }
        
        }
        // draw again at new position
        machine.draw(this); 
    }

    /**
     * return the current score of the pinball
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Changes the current score of the pinball
     */
    public void resetScore()
    {
        score = 0;
    }
    
    /**
     * Increments the score by the given value
     * 
     * @param increment     The score to increment
     */
    public void incrementScoreBy(int increment)
    {
        score += increment;
    }
    
    /**
     * returns the x velocity of the pinball
     */
    public int getSpeedXTravel()
    {
        return speedXTravel;
    }
    
    /**
     * returns the y veloocity of the pinball
     */
    public int getSpeedYTravel()
    {
        return speedYTravel;
    }
    
    /**
     * Changes the x speed of pinball to the passed value
     * 
     * @param newSpeedXTravel   the value to be set to
     */
    public void changeSpeedXTravel (int newSpeedXTravel)
    {
        speedXTravel = newSpeedXTravel;
    }
    
    /**
     * Changes the y speed of pinball to the passed value
     * 
     * @param newSpeedYTravel   the value to be set to
     */
    public void changeSpeedYTravel (int newSpeedYTravel)
    {
        speedYTravel = newSpeedYTravel;
    }
    /**
     * return the index of the first property for the pinball
     */
    public int property1Index()
    {
        return property1;
    }
    
    /**
     * returns the index of the second property for the pinball
     */
    public int property2Index()
    {
        return property2;
    }
}
