package hw1_package;

import java.awt.*;

public class ImpossibleSizeException extends Exception{

    private Dimension legalDimension;
    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     * 			If this cannot be resized to the specified dimension =>
     * 			this is not modified, throws hw1_package.ImpossibleSizeException
     * 			(the exception suggests an alternative (64x64) dimension that is
     * 			 supported by this).
     */
    public ImpossibleSizeException(String errorMessage){
        super();
        legalDimension.setSize(64,64);
    }
    public Dimension getLegalDimension(){
        return this.legalDimension;
    }
}


