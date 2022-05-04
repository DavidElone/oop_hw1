package hw1_package;

import java.awt.*;

public class LocationChangingOval extends LocationChangingShape{

    private Dimension dimension;
    /**
     * @modifies initialize a hw1_package.LocationChangingOval with a given location, color , dimension
     */
     LocationChangingOval(Point location,Color color, Dimension dimension) {
        super(location,color);
         try {
             setSize(dimension);
         } catch (ImpossibleSizeException e) {
             this.dimension = e.getLegalDimension();
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
     * @effects returns rectangle that is the bounding box of this.
     */
    @Override
    public Rectangle getBounds() {

         Rectangle result = new Rectangle(getLocation(),getDimensions());
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
        g.fillOval((int)this.getLocation().getX(), (int)this.getLocation().getY(), (int)this.getDimensions().getWidth(), (int)this.getDimensions().getHeight());
        checkRep() ;
    }

    /**
     * @effects Creates and returns a copy of this.
     */
    @Override
    public Object clone()
    {
        checkRep() ;
        LocationChangingOval clonedOval = null;
        clonedOval = (LocationChangingOval)super.clone();
        try
        {
            clonedOval.setSize(getDimensions());
        }
        catch (ImpossibleSizeException e)
        {
            clonedOval.dimension = e.getLegalDimension();
        }
        checkRep() ;
        return clonedOval;
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
