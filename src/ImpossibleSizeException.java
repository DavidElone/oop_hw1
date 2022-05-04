import java.awt.*;
/**
 * @modifies this
 * @effects Resizes this so that its bounding rectangle has the specified
 * 			dimension.
 * 			If this cannot be resized to the specified dimension =>
 * 			this is not modified, throws ImpossibleSizeException
 * 			(the exception suggests an alternative dimension that is
 * 			 supported by this).
 */
public class ImpossibleSizeException extends Exception{

    private Dimension legalDimension;
    public ImpossibleSizeException(String errorMessage){
        super();
        legalDimension.setSize(10,10);
    }
    public Dimension getLegalDimension(){
        return this.legalDimension;
    }
}
