package homework1;

import java.awt.*;

public class LocationChangingNumberedOval extends LocationChangingOval{
    private int serialNumber;
    private static int numberOfNumberedOval=0;

    // Abstraction Function
    //hw1_package.LocationChangingNumberedOval is a LocationChangingOval that have a serial number is in center.

    // Rep. invariant
    // like hw1_package.LocationChangingOval. Moreover serialNumber > 0 and  numberOfNumberedOval >= 0


    /**
     * @effects Initializes this with a serial number.
     */
    LocationChangingNumberedOval(Point location, Color color, Dimension dimension) {
        super(location, color, dimension);
        serialNumber = ++numberOfNumberedOval;
        checkRep();
    }
    /**
     * @effects get the serialNumber of this
     */
    public int getSerialNumber(){
        checkRep();
        return serialNumber;
    }
    /**
     * @effects get the serialNumber of this
     */
    public static void resetNumberOfNumberedOval(){
        numberOfNumberedOval =0;
    }
    /**
     * @modifies g
     * @effects Draws this into g.
     */
    @Override
    public void draw(Graphics g){
        checkRep() ;
        super.draw(g);
        g.setColor(Color.black);
        g.drawString(Integer.toString(this.getSerialNumber()), (int)this.getBounds().getCenterX(), (int)this.getBounds().getCenterY());
        checkRep() ;
    }
    /**
     * @effects Creates and returns a copy of this.
     */
    @Override
    public Object clone()
    {
        checkRep() ;
        LocationChangingNumberedOval clonedNumberedOval = null;
        clonedNumberedOval = (LocationChangingNumberedOval)super.clone();
        clonedNumberedOval.serialNumber = ++numberOfNumberedOval;
        checkRep() ;
        return clonedNumberedOval;
    }
    /**
     * @effects check
     */
    private void checkRep() {
    	assert (numberOfNumberedOval>=0) :"number_of_instances is negative";
        assert ( (serialNumber<=numberOfNumberedOval) && (serialNumber > 0) ) : "private_number out of range";
       
    }
}
