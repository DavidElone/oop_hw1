import java.awt.*;

public class LocationChangingNumberedOval extends LocationChangingOval{
    private int serialNumber;
    private static int numberOfNumberedOval=0;
    /**
     * @effects Initializes this with a serial number.
     */
    LocationChangingNumberedOval(Point location, Color color, Dimension dimension) {
        super(location, color, dimension);
        serialNumber = ++numberOfNumberedOval;
    }
    /**
     * @effects get the serialNumber of this
     */
    public int getSerialNumber(){
        return serialNumber;
    }
    /**
     * @modifies g
     * @effects Draws this into g.
     */
    @Override
    public void draw(Graphics g){

    }
}
