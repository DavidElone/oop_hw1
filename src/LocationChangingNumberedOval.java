import java.awt.*;

public class LocationChangingNumberedOval extends LocationChangingOval{
    private int serialNumber;
    private static int numberOfNumberedOval=0;
    LocationChangingNumberedOval(Point location, Color color, Dimension dimension) {
        super(location, color, dimension);

        serialNumber = ++numberOfNumberedOval;
    }
    public int getSerialNumber(){
        return serialNumber;
    }
    /**
     * @modifies g
     * @effects Draws this onto g.
     */
    @Override
    public void draw(Graphics g){

    }
}
