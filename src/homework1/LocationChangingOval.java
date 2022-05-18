package homework1;

import java.awt.*;

public class LocationChangingOval extends LocationChangingShape{

    private Dimension dimension;

    // Abstraction Function
    //hw1_package.LocationChangingOval is a LocationChangingShape that have an oval form.

    // Rep. invariant
    // like hw1_package.LocationChangingShape. Moreover :
    // dimension.height >= 0
    // dimension.width >= 0


    /**
     * @modifies initialize a hw1_package.LocationChangingOval with a given location, color , dimension
     * @requires dimension =! null
     */
     LocationChangingOval(Point location,Color color, Dimension dimension) {
        super(location,color);
        this.dimension = dimension;
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
     * @effects returns rectangle that is the bounding box of this.
     */
    @Override
    public Rectangle getBounds() {
         checkRep();
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
    private void checkRep() {
        assert ( dimension.height >= 0 ) : "height is negative";
        assert ( dimension.width >= 0) : "width is negative";
    }


}
