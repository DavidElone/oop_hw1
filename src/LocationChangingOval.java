import java.awt.*;
import java.awt.Graphics2D;

public class LocationChangingOval extends LocationChangingShape{

    private Dimension dimension;
    /**
     * @modifies initialize a LocationChangingOval with a given location, color , dimension
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

    }


}
