import java.awt.*;
import java.util.*;
/**
 * CircleObject is the superclass for PinBall. PinBall has a score and two different characteristics as additional properties.
 *  
 * @author (UP826133) 
 * @version (0.4)
 */
 
public class PinBall extends CircleObject
{
    protected int score;
    protected int property1;
    protected int property2;
    protected int speedXTravel;
    protected int speedYTravel;
    private final int leftWallPosition;
    private final int rightWallPosition;
    private final int topWallPosition;
    private final int bottomWallPosition;
    private final int leftBottomWallLength;
    private final int gapWidth;
    protected boolean active;   //boolean that stores whether the ball is still active in game
    private String[] propertyList;          //List of all properties along with properties of blackhole and bumpers
    private Color[] colourType;
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
 * @param property1             the property when it bounces to the wall
 * @param property2             the property when it bounces to other pinballs
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
        active = true;     
        
        this.propertyList = new String[4];   
        this.propertyList[0] = "colour";          // The radius of the pinball will increase or decrease by 10%
        this.propertyList[1] = "flashing";          // The pinballs will flash, until it hits another object of the type which causes this action      
        this.propertyList[2] = "direction";     // The pinballs normally bounce of objects and bounce back at the same angle. Or unless it's  a direction changing ball, it will bounce back at a random angle.
        this.propertyList[3] = "speed";         // The speed of the pinball change between a given minimum and maximum
        
        colourType = new Color[3];
        colourType[0] = Color.CYAN;
        colourType[1] = Color.MAGENTA;
        colourType[2] = Color.YELLOW;
    }

    /**
    * Move this object according to its position and speed and redraw.
    **/
    public void move()
    {       
        // remove from universe at the current position
        machine.erase(this);
        if(active)  //only if the ball is active, it will change position
        {
            // compute new position
        currentXLocation += speedXTravel;
        currentYLocation += speedYTravel;
       
        checkHoles();
        checkWalls();
        checkBumpers();
        checkOtherBalls();
        checkFlashing();
        // draw again at new position
        if(active)
        {
            machine.draw(this);
        }
    } 
    }

     /**
     * Checks if the pinball has collided with the walls
     */
    public void checkWalls()
    {    
        if(active)
        {
        // check if it has hit the leftwall
        if(currentXLocation <= (leftWallPosition + radius)) 
        {
            if(property1 == 0)
            {
                changeColour();
            }
            else
            {
                this.changeDirection();
            }
        currentXLocation = leftWallPosition + radius;
        speedXTravel = -speedXTravel;
        score++;
        }
        
        // check if it has hit the rightwall
        if(currentXLocation >= (rightWallPosition - radius))
        {
            if(property1 == 0)
            {
                changeColour();
            }
             else
            {
                changeDirection();
            }
           currentXLocation = rightWallPosition - radius;
           speedXTravel = -speedXTravel;
           score++;
        }
        
        // check if it has hit the topwall
        if(currentYLocation <= (topWallPosition + radius))
        {
            if(property1 == 0)
            {
                changeColour();
            }
             else
            {
                changeDirection();
            }
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
                if(property1 == 0)
            {
                changeColour();
            }
             else
            {
                changeDirection();
            }
                currentYLocation = bottomWallPosition - radius;
                speedYTravel = - speedYTravel;  
                score++;
            }
            //check if it has hit the right bottom wall.
            else if(currentXLocation >= (leftBottomWallLength + (gapWidth*2) - radius ))
            {
                if(property1 == 0)
            {
                changeColour();
            }
             else
            {
                changeDirection();
            }
                currentYLocation = bottomWallPosition - radius;
                speedYTravel = - speedYTravel;
                score++;

            }
            //check if the ball has gone through the gap
            else //(currentYLocation + radius >= bottomWallPosition - 10)
            {
                machine.gameOver();    
            }
        
        }
    }
    }
    
    /**
     * Dummy changeSpeed method for which the PinBall3 will override on
     */
    public void changeSpeed()
    {
        //Override
    }
    /**
     * Dummy changeFlashState method for which PinBall9 wil override on
     */
    public void changeFlashState()
    {
    //Override
    }
    
    /**
     * Dummy isFlashing method for which PinBall9 will override on
     */
    public boolean isFlashing()
    {
        //Override
        return false;
    }
    /**
     * Dummy changeFlashColour method for which PinBall9 will override on
     */
    public void changeFlashColour()
    {
        //Override
    }
     /**
     * Check if the ball has collided with any bumpers
     */
    public void checkBumpers()
    {
        if(active)
        {
        for (Bumper bumper: machine.getBumpers())
        {
            int xBumper = bumper.getXPosition();
            int yBumper= bumper.getYPosition();
            int radiusBumper = bumper.getRadius();
            
            double diffX = Math.pow(currentXLocation - xBumper, 2);
            double diffY = Math.pow(currentYLocation - yBumper, 2);
            
            double centreDistance = Math.sqrt(diffX + diffY);
            
            if(centreDistance <= radius + radiusBumper)
            {
                score += 2;
                speedXTravel = -speedXTravel;
                speedYTravel = -speedYTravel;
                
               currentXLocation += speedXTravel;
               currentYLocation += speedYTravel;
            } 
        }
    }
    }
    
     /**
     * Check if the ball has collided with other balls
     */
    public void checkOtherBalls()
    {
        if(active)
        {
        for(PinBall other: machine.getPinballs())
        {
            if(other != this && other.active)
            {
                int xOther = other.getXPosition();
                int yOther = other.getYPosition();
                int otherRadius = other.getRadius();
            
                double diffX = Math.pow(currentXLocation - xOther, 2);
                double diffY = Math.pow(currentYLocation - yOther, 2);
            
                double centreDistance = Math.sqrt(diffX + diffY);

                if(centreDistance <= radius + otherRadius)
                { 
                    score += 5;
                    speedXTravel = -speedXTravel;
                    speedYTravel = -speedYTravel;
                                        
                    if(property2 == 1)
                    {
                        changeFlashState();
                    }
                    else
                    {
                        changeSpeed();
                    }
                    currentXLocation += speedXTravel;
                    currentYLocation += speedYTravel;
                }
            }
        }
    }
    }
    
     /**
     * Check if the ball has collided with a hole
     */ 
    public void checkHoles()
    {
        if(active)
        {
        for(Hole h: machine.getHoles())
        {
            int xHole = h.getXPosition();
            int yHole = h.getYPosition();
            int radiusHole = h.getRadius();
            
            double diffX = Math.pow(currentXLocation - xHole, 2);
            double diffY = Math.pow(currentYLocation - yHole, 2);
            
            double centreDistance = Math.sqrt(diffX + diffY);
            
            if(centreDistance <= radius + radiusHole)
            {
                if(radius <= radiusHole)
                {
                    active = false;
                    machine.erase(this);
                    machine.erase(h);
                    machine.draw(h);
                }
                score = 0;
            }
        }
    }
    }
    
    /**
     * changes to the next valid colour for the pinball
     */
    private void changeColour()
    {
        int index = 0;

        index = Arrays.asList(colourType).indexOf(colour);  //temporarily changes array to an arraylist
        index++;
        if(index > 2)
        {
            index = 0;
        }
        colour = colourType[index];
    }    
    
    /**
     * Flips a coin in random and returns either heads or not heads as a boolean
     */
    public boolean flipCoin()
    {
        double r = Math.random();
  
        if(r >= 0.5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * changes the direction of the pinball and override the dummy changeDirection method
     */
    public void changeDirection()
    {
        double xTravel = Math.random()-0.5;
        double yTravel = Math.random()-0.5;
        
        double magnitude = Math.sqrt(Math.pow(xTravel, 2) + Math.pow(yTravel, 2));
        
        xTravel /= magnitude;
        yTravel /= magnitude;
        
        xTravel *= 5;
        yTravel *= 5;
        
        speedXTravel = (int)xTravel;
        speedYTravel = (int)yTravel;
        
    }
    /**
     * Checks if the pinball has to flash and flashes them
     */
    public void checkFlashing()
    {
        if(property2 == 1 && isFlashing())
        {
            changeFlashColour();
        }
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
     * returns if the ball is active or not
     */
    public boolean ifActive()
    {
        return active;
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
     * returns the y velocity of the pinball
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
     * Generates a random number between the minimum and maximum speed
     * 
     * @param minimum speed of the ball
     * @param maximum speed of the ball
     */
    public int generateRandomSpeed(int min, int max)
    {
        Random rand = new Random();
        
        int num = rand.nextInt(max) + min;
        return num;
    }
    
    /**
     * returns the index of the second property for the pinball
     */
    public int property2Index()
    {
        return property2;
    }
    
         /**
     * returns the name of the property given the index of the property
     * @param index     the index of the property to be retrieved
     */
    public String getPropertyName(int index)
    {
        return this.propertyList[index];
    }
    
}
