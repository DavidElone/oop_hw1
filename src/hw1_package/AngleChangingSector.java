package hw1_package;

import java.awt.*;

public class AngleChangingSector extends Shape implements Animatable {
    private int angle;
    private int sectorAngle;
    private Dimension dimension;

    /**
     * @effects Initializes this with a given location, color, start angle of the sector
     * 			and the sector angle and his boundingbox(dimension)
     */
    AngleChangingSector(Point location, Color color, int angle, int sectorAngle, Dimension dimension) {
        super(location,color);
        this.angle = angle;
        this.sectorAngle = sectorAngle;
        this.dimension = dimension;
        checkRep();
    }

    /**
     * @return the start angle of this.
     */
    public int angle() {
        checkRep();
        return angle;
    }
    /**
     * @return the sector angle of this.
     */
    public int getSectorAngle() {
        checkRep();
        return sectorAngle;
    }
    /**
     * @effects return dimension of this
     */
    public Dimension getDimensions(){
        checkRep();
        return dimension;
    }
    /**
     * @modifies this
     * @effects Updates the state of this to the appropriate value for the
     * 			next animation step (by adding 1 to the sector angle).
     * 			The argument bound indicates the area within which this is allowed to move.
     */
    public void step(Rectangle bound) {
        checkRep();

        angle++;
        if (angle == 360)
            angle = 0;

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
     * @effects returns rectangle that is the bounding box of this.
     */
    @Override
    public Rectangle getBounds() {
        checkRep();
        Rectangle result = new Rectangle(getLocation(),getDimensions());
        return result;
    }

    @Override
    public void draw(Graphics g) {
        checkRep();

//        Graphics2D g2d = (Graphics2D)g;
//        g2d.setColor(getColor());
//        g2d.fillArc((int)getLocation().getX(), (int)getLocation().getY(), (int)dimension.getWidth(), (int)dimension.getHeight(), angle, sectorAngle);

        g.setColor(this.getColor());
        g.fillArc((int)this.getLocation().getX(), (int)this.getLocation().getY(), (int)this.getBounds().getWidth(), (int)this.getBounds().getHeight(), this.angle, this.sectorAngle);

        checkRep();
    }

    /**
     * @effects Creates and returns a copy of this.
     */
    @Override
    public Object clone()
    {
        checkRep() ;
        AngleChangingSector clonedSector = null;
        clonedSector = (AngleChangingSector)super.clone();
        try
        {
            clonedSector.setSize(getDimensions());
        }
        catch (ImpossibleSizeException e)
        {
            clonedSector.dimension = e.getLegalDimension();
        }
        checkRep() ;
        return clonedSector;
    }
}
