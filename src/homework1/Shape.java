package homework1;

import java.awt.*;


/**
 * A hw1_package.Shape is an abstraction of a shape object. A typical hw1_package.Shape consists of
 * a set of properties: {location, color, shape, size}.
 * Shapes are mutable and cloneable.
 */
public abstract class Shape implements Cloneable {

	private Point location;
	private Color color;

	
	//Abstraction Function:
    // hw1_package.Shape is represented by his location,color,shape and size.
    // location is defined by the top left corner of the bounding rectangle of hw1_package.Shape.
	
	// Rep. Invariant:
    // location.x >=0 and location.y >=0
	
	
	/**
	 * @effects Initializes this with a a given location and color.
	 */
    public Shape(Point location, Color color) {
    	Point location_ = location == null ? new Point(0,0) : location;
    	Color color_ = color == null ? new Color(0,0,0) : color;
    	this.location = location_;
    	this.color = color_;
        checkRep();
    }


    /**
     * @return the top left corner of the bounding rectangle of this.
     */
    public Point getLocation() {
        checkRep();
    	return location.getLocation();
    	
    }


    /**
     * @modifies this
     * @effects Moves this to the given location, i.e. this.getLocation()
     * 			returns location after call has completed.
     */
    public void setLocation(Point location) {
        checkRep();
        Point location_ = location == null ? new Point(0,0) : location;
    	this.location = (Point)location_.clone();
        checkRep();
    }


    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     * 			If this cannot be resized to the specified dimension =>
     * 			this is not modified, throws hw1_package.ImpossibleSizeException
     * 			(the exception suggests an alternative dimension that is
     * 			 supported by this).
     */
    public abstract void setSize(Dimension dimension)
    	throws ImpossibleSizeException;

    
    /**
     * @return the bounding rectangle of this.
     */
    public abstract Rectangle getBounds();
  

    /**
     * @return true if the given point lies inside the bounding rectangle of
     * 		   this and false otherwise.
     */
    public boolean contains(Point point) {
        checkRep();
        return getBounds().contains(point);
    }
        

    /**
     * @return color of this.
     */
    public Color getColor() {
        checkRep();
        return color;
    }


    /**
     * @modifies this
     * @effects Sets color of this.
     */
    public void setColor(Color color) {
        checkRep();
        Color color_ = color == null ? new Color(0,0,0) : color;
    	this.color = color_;
        checkRep();
    }


    /**
     * @modifies g
     * @effects Draws this onto g.
     */
    public abstract void draw(Graphics g);


    /**
     * @effects Creates and returns a copy of this.
     */
    public Object clone() {
        checkRep();
        Shape cloned = null;
        try{
            cloned = (Shape)super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        cloned.setLocation(this.location);
        cloned.setColor(this.color);
        return cloned;

    }



    /**
     * @effects check
     */
    private void checkRep() {
        assert location.x >=0 : "location.x is negative";
        assert location.y >=0 : "location.y is negative";

    }
}