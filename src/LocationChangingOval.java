import java.awt.*;
import java.awt.Graphics2D;

public class LocationChangingOval extends LocationChangingShape{

    private Dimension dimension;

     LocationChangingOval(Point location,Color color, Dimension dimension) {
        super(location,color);
         try {
             setSize(dimension);
         } catch (ImpossibleSizeException e) {
             e.printStackTrace();
         }
         checkRep();
    }
    public Dimension getDimensions(){
         return dimension;
    }
    @Override
    public void setSize(Dimension dimension) throws ImpossibleSizeException {

         if(dimension.getHeight() < 0 || dimension.getWidth() < 0){
             throw new ImpossibleSizeException("size cannot be negative");
         }
         else{
             this.dimension = dimension;
         }
    }

    @Override
    public Rectangle getBounds() {

         Rectangle result = new Rectangle(getLocation(),getDimensions());
         return result;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override

}
