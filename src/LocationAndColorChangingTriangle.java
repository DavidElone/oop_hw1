import java.awt.*;

public class LocationAndColorChangingTriangle extends LocationAndColorChangingShape{

    Dimension dimension;

    /**
     * @modifies initialize a LocationAndColorChangingTriangle with a given location, color , dimension
     */
    LocationAndColorChangingTriangle(Point location, Color color) {
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

        if(dimension.getHeight() < 0 || dimension.getWidth() < 0){
            throw new ImpossibleSizeException("size cannot be negative");
        }
        else{
            this.dimension = dimension;
        }
    }
    /**
     * @effects return dimension of this
     */
    public Dimension getDimensions(){
        return dimension;
    }
    /**
     * @effects returns rectangle that is the bounding box of this.
     */
    @Override
    public Rectangle getBounds() {

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
        int[] xCoordinates = {originX,originX+ (int)this.getDimensions().getHeight(),originX + (int)this.getDimensions().getHeight()};
        int[] yCoordinates = {originY,originY+ (int)this.getDimensions().getHeight(),originY + (int)this.getDimensions().getHeight()};
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
