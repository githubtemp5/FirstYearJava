import java.awt.*;
import java.util.ArrayList;

/**
 * A pinball machine, with a sample demo
 * 
 * @author (UP826133) 
 * @version (0.4)
 */
public class Machine
{
    private Canvas machine;
    private int topEdge = 0;
    private int leftEdge = 0;
    private int bottomEdge;
    private int rightEdge;
    private int lengthToGap;        // the distance between the edge of the machine and the start of the gap
    private int gapWidth = 50;
    private ArrayList<PinBall> pinballs;
    private boolean gameOver;

    /**
     * Create a machine with default name and size
    */
    public Machine()
    {
        machine = new Canvas("Pinball Demo", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        lengthToGap = (rightEdge / 2) - gapWidth;
        this.pinballs = new ArrayList<PinBall>();
        gameOver = false;
        drawMachine();

    }
    
    /**
     *  Create a machine with given name and size
     *  @param name The name to give the machine
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
     public Machine(String name, int rightEdge, int bottomEdge)
    {
        machine = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        lengthToGap = (rightEdge / 2) - gapWidth;
        this.pinballs = new ArrayList<PinBall>();
        gameOver=false;
        drawMachine();
    }

    /**
     * Erase a PinBall from the view of the pinball machine
     * 
     * @param pinballObj The object to be erased
     */
    public void erase(PinBall pinball)
    {
        machine.eraseCircle(pinball.getXPosition() - pinball.getRadius(), pinball.getYPosition()- pinball.getRadius(), pinball.getDiameter());
    }
    
    /**
     * Erase a Bumper from the view of the pinball machine
     * 
     * @param bumper The object to be erased
     */
    public void erase(Bumper bumper)
    {
        machine.eraseCircle(bumper.getXPosition() - bumper.getRadius(), bumper.getYPosition()- bumper.getRadius(), bumper.getDiameter());
    }
    
     /**
     * Erase a Hole from the view of the pinball machine
     * 
     * @param hole The object to be erased
     */
    public void erase(Hole hole)
    {
        machine.eraseCircle(hole.getXPosition() - hole.getRadius(), hole.getYPosition()- hole.getRadius(), hole.getDiameter());
    }
    
    /**
    * Draw a PinBall at its current position onto the view of the pinball machine
    * 
    * @param ball The object to be drawn
    */
    public void draw(PinBall ball)
    {       
        machine.setForegroundColor(ball.getColor());
        machine.fillCircle(ball.getXPosition() - ball.getRadius(), ball.getYPosition() - ball.getRadius(), ball.getDiameter());   
        machine.setForegroundColor(Color.BLACK);
        machine.drawString(ball.getScore()+"", ball.getXPosition(), ball.getYPosition());
    }

    /**
    * Draw a Hole at its current position onto the view of the pinball machine
    * 
    * @param hole The object to be drawn
    */
    public void draw(Hole hole)
    {   
        
        machine.setForegroundColor(hole.getColor());
        machine.fillCircle(hole.getXPosition() - hole.getRadius(), hole.getYPosition() - hole.getRadius(), hole.getDiameter());
    }
    
    /**
    * Draw a Hole at its current position onto the view of the pinball machine
    * 
    * @param ball The object to be drawn
    */
    public void draw(Bumper bumper)
    {   
        machine.setForegroundColor(bumper.getColor());
        machine.fillCircle(bumper.getXPosition() - bumper.getRadius(), bumper.getYPosition() - bumper.getRadius(), bumper.getDiameter());
    }
    
    /**
    * Draw the edge of the pinball machine 
    */
    public void drawMachine()
    {
        machine.setForegroundColor(Color.DARK_GRAY);
        
        machine.fillRectangle(0, 0, rightEdge, 10);  // top edge
        machine.fillRectangle(0, 0, 10, bottomEdge); // left edge
        machine.fillRectangle(rightEdge - 10, 0, 10, bottomEdge); // right edge
        
        machine.fillRectangle(0, bottomEdge - 10, lengthToGap, 10); // left-hand side of bottom edge
        machine.fillRectangle(rightEdge - lengthToGap, bottomEdge - 10, rightEdge, 10);     // right-hand side of bottom edge
    }
    
    /**
     * Ends the simulation, making the game over
     */
    public void gameOver()
    {
        gameOver = true;
    }
    /**
     * Returns a booolean value to check if the game is over
     */
    public boolean ifGameNotOver()
    {
        return !gameOver;
    }
    /**
     * Adds pinballs to the machine and makes it accessible for other classes
     */
    public void addPinBall(PinBall ball)
    {
        this.pinballs.add(ball);
    }
    
    /**
     * Returns the arrayList of pinballs currently in the machine
     */
    public ArrayList<PinBall> getPinballs()
    {
        return this.pinballs;
    }
    
    /**
     * Removes the pinball from the active pinballs.
     */
    public void removeBall(PinBall ball)
    {
        pinballs.remove(ball);
    }
    
    public void updatePinballs(ArrayList<PinBall> newPinballs)
    {
        pinballs = newPinballs;
    }
    
    /**
     * Return the edge of the left-hand wall
     */
    public int getLeftWall()
    {
        return leftEdge + 10;
    }
   
    /**
     * Return the edge of the right-hand wall
     */
    public int getRightWall()
    {
        return rightEdge - 10;
    }
    
    /**
     * Return the edge of the top wall
     */
    public int getTopWall()
    {
        return topEdge + 10;
    }
    
    /**
     *Return the edge of the bottom wall
     */
    public int getBottomWall()
    {
        return bottomEdge - 10;
    }
    
    /**
     *Return the right edge of the left bottom wall
     */
    public int getLeftBottomWallLength()
    {
        return lengthToGap;
    }
    
    /**
     * Return the gapwidth in the bottom wall
     */
    public int getGapWidth()
    {
        return gapWidth;
    }
    /**
     * Introduces a small delay in ball movement, for smooth running
     */
    
    public void pauseMachine()
    {
        machine.wait(50);
    }
    
    /**
     * Resets the machine back to initial view, with no pinballs
     */
    public void resetMachine()
    {
        machine.erase();
        drawMachine();
    }
    
}
