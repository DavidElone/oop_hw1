package hw1_package;

import java.awt.*;

public class LocationAndColorChangingTriangle extends LocationAndColorChangingShape{

    Dimension dimension;
    // Abstraction Function
    //hw1_package.LocationAndColorChangingTriangle is a LocationAndColorChangingShape that have a triangular form.

    // Rep. invariant
    // like hw1_package.LocationAndColorChangingShape.


    /**
     * @modifies initialize a hw1_package.LocationAndColorChangingTriangle with a given location, color , dimension
     */
    LocationAndColorChangingTriangle(Point location, Color color,Dimension dimension) {
        super(location,color);
        try {
            setSize(dimension);
        } catch (ImpossibleSizeException e) {
            this.dimension = e.getLegalDimension();
        }
        checkRep();
    }


    /**
     * @modifies this.dimension
     */
    @Override
    public void setSize(Dimension dimension) throws ImpossibleSizeException {
        checkRep();
        if(dimension.getHeight() < 0 || dimension.getWidth() < 0){
            throw new ImpossibleSizeException("size cannot be negative");
        }
        else{
            this.dimension = dimension;
        }
        checkRep();
    }
    /**
     * @effects return dimension of this
     */
    public Dimension getDimensions(){
        checkRep();
        return dimension;
    }
    /**
     * @effects returns rectangle that is the bounding box of this.
     */
    @Override
    public Rectangle getBounds() {
        checkRep();
        Rectangle result = new Rectangle(this.getLocation(),this.getDimensions());
        return result;
    }
    /**

     * @modifies g
     * @effects Draws this into g.
     */
    @Override
    public void draw(Graphics g) {
        checkRep() ;
        g.setColor(this.getColor());
        int originX = (int)this.getLocation().getX();
        int originY = (int)this.getLocation().getY();
        int[] xCoordinates = {originX,originX,originX + (int)this.getDimensions().getWidth()};
        int[] yCoordinates = {originY,originY+ (int)this.getDimensions().getHeight(),originY};
        g.fillPolygon(xCoordinates,yCoordinates,3);
        checkRep() ;
    }

    /**
     * @effects Creates and returns a copy of this.
     */
    @Override
    public Object clone()
    {
        checkRep() ;
        LocationAndColorChangingTriangle clonedTriangle = null;
        clonedTriangle = (LocationAndColorChangingTriangle)super.clone();
        try
        {
            clonedTriangle.setSize(getDimensions());
        }
        catch (ImpossibleSizeException e)
        {
            clonedTriangle.dimension = e.getLegalDimension();
        }
        checkRep() ;
        return clonedTriangle;
    }
    /**
     * @effects check
     */
    protected void checkRep() {
        super.checkRep();
        assert ( dimension.height >= 0 ) : "height is negative";
        assert ( dimension.width >= 0) : "width is negative";
    }
}
