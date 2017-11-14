import java.awt.*;

/**
 * An object that exists in the pinball. The object bounces off
 * the left wall of the machine (N.B - the final object should bounce
 * off all walls).
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 * 
 * N.B This class is incomplete and still under development. It will require updating to
 * complete the INTPROG coursework assignment.
 * 
 * @author (UP826133) 
 * @version (0.4)
 * 
 */

public class CircleObject
{
    protected int currentXLocation;
    protected int currentYLocation;
    protected Color colour;
    protected int radius;
    protected Machine machine;
    private String[] propertyList;          //List of all properties along with properties of blackhole and bumpers

    /**
     * Constructor for objects of class Pinball_Obj
     * 
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public CircleObject(int xPos, int yPos, Color objectColor, int objectRadius, Machine theMachine)
    {
        currentXLocation = xPos;
        currentYLocation = yPos;
        colour = objectColor;
        radius = objectRadius;
        machine = theMachine;
        this.propertyList = new String[6];   
        this.propertyList[0] = "color";         // The pinball will change colour to another valid colour for that pinball type
        this.propertyList[1] = "size";          // The radius of the pinball will increase or decrease by 10%
        this.propertyList[2] = "speed";         // The speed of the pinball change between a given minimum and maximum
        this.propertyList[3] = "direction";     // The pinballs normally bounce of objects and bounce back at the same angle. Or unless it's  a direction changing ball, it will bounce back at a random angle.
        this.propertyList[4] = "flashing";      // The pinballs will flash, until it hits another object of the type which causes this action
        this.propertyList[5] = "erase";         // If the pinball bounce on a blackhole, it will lose all score and it's size is less or the same as the blackhole, it will erase the pinball from the machine
    }
    
    /**
     * return the horizontal position of this object
     */
    public int getXPosition()
    {
        return currentXLocation;
    }

    /**
     * return the vertical position of this object
     */
    public int getYPosition()
    {
        return currentYLocation;
    }
    
    /**
     * return the radius of this object
     */
    public int getRadius()
    {
        return radius;
    }
    
    /**
     * return the diameter of this object
     */
    public int getDiameter()
    {
        return 2*radius;
    }
    
    /**
     * return the colour of this object
     */
    public Color getColor()
    {
        return colour;
    }
    
    /**
     * returns the current machine 
     */
   
    
     /**
     * returns the name of the property given the index of the property
     * @param index     the index of the property to be retrieved
     */
    public String getPropertyName(int index)
    {
        return this.propertyList[index];
    }

}
