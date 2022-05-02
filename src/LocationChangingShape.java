import java.awt.*;
import java.util.Random;


/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationChangingShape extends Shape implements Animatable {

	// Abstraction Function
    //Shape that have a velocity (velocityX,velocityY)

    // Rep. invariant
    // on initialization only, velocityX, velocityY must be a number between -5 and 5 without being 0

    private int velocityX;
    private int velocityY;
	
	/**
	 * @effects Initializes this with a a given location and color. Each
	 *          of the horizontal and vertical velocities of the new
	 *          object is set to a random integral value i such that
	 *          -5 <= i <= 5 and i != 0
	 */
	LocationChangingShape(Point location, Color color) {
    	// TODO: Implement this constructor
        super(location,color);
        this.velocityX = getRandomVelocity();
        this.velocityY = getRandomVelocity();
    }
    public int getRandomVelocity(){
        checkRep();
        Random rand = new Random();
        int intRandom = rand.nextInt(5) +1;//get a number
        boolean isNegative  = rand.nextBoolean();
        if(isNegative == true){
            intRandom = -intRandom;
        }
        return intRandom;
    }

    /**
     * @return the horizontal velocity of this.
     */
    public int getVelocityX() {
        checkRep();
    	return velocityX;
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
        checkRep();
        return velocityY;
    }


    /**
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     * 			vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
        checkRep();
    	this.velocityX = velocityX;
    	this.velocityY = velocityY;
        checkRep();
    }


    /**
     * @modifies this
     * @effects Let p = location
     * 				v = (vx, vy) = velocity
     * 				r = the bounding rectangle of this
     *         	If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     * 				If adding v to p would move r horizontally farther away
     * 				from the center of bound,
     * 					vx = -vx
     * 				If adding v to p would move r vertically farther away
     * 				from the center of bound,
     * 					vy = -vy
     *          }
     * 			p = p + v
     */
    public void step(Rectangle bound) {
        checkRep();
        int actualX = (int)getLocation().getX();
        int actualY = (int)getLocation().getY();
        int nextX = actualX + velocityX;
        int nextY = actualY + velocityY;
        Rectangle ourRectangle = new Rectangle(getBounds());
        ourRectangle.setLocation(nextX,nextY);
        boolean isOutOfBound = !bound.contains(getBounds());
        boolean willBeOutOfBound = bound.contains(getBounds()) && !bound.contains(ourRectangle.getBounds());
    	if(isOutOfBound || willBeOutOfBound ){
            ourRectangle.setLocation(nextX,actualY);
            if(!bound.contains(ourRectangle)){
                velocityX = -velocityX;
            }
            ourRectangle.setLocation(actualX,nextY);
            if(!bound.contains(ourRectangle)){
                velocityY = -velocityY;
            }

        }
        Point destination = new Point(actualX + velocityX,actualY + velocityY);
        setLocation(destination);
        checkRep();
    	
    }

}
