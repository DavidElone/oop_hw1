package hw1_package;

import java.awt.*;
import java.util.Random;

/**
 * A ColorAndLocationChaningShape is a hw1_package.Shape that can change its location and color using its step()
 * method.
 * Thus, a typical ColorAndLocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationAndColorChangingShape extends LocationChangingShape{

    // Abstraction Function
    //hw1_package.LocationChangingShape is a LocationChangingShape that changes its color every time it rebound on the limit window.

    // Rep. invariant
    // like hw1_package.LocationChangingShape.


    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    LocationAndColorChangingShape(Point location, Color color) {
        super(location,color);
        checkRep();

    }

    /**
     * @modifies this
     * @effects Changes the location of this as described in the specification
     *          of hw1_package.LocationChangingShape.step(Rectangle bound) &&
	 *			if the velocity of this needs to be changed (as described in hw1_package.LocationChangingShape.step(Rectangle bound)),
	 *			changes the color of this to a new random color;
	 *			else, does not change the color of this.
     */
    public void step(Rectangle bound) {
        checkRep();
        int oldVelocityX = getVelocityX();
        int oldVelocityY = getVelocityY();
        super.step(bound);
        if(getVelocityX()!=oldVelocityX || getVelocityY()!=oldVelocityY){
            Color randomColor = getRandomColor();
            super.setColor(randomColor);
        }
        checkRep();


    }
    /**
     * @effects return a random color.
     */
    public static Color getRandomColor() {
        Random rand = new Random();
        int R = rand.nextInt(256);//get a random number from 0 to 255
        int G = rand.nextInt(256);
        int B = rand.nextInt(256);
        Color result = new Color(R,G,B);
        return result;
    }
}
