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
    public ImpossibleSizeException(String errorMessage){
        super(errorMessage);
    }
    //TODO continue
}
