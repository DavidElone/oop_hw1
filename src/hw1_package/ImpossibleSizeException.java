package hw1_package;

import java.awt.*;
/**
 * @modifies this
 * @effects Resizes this so that its bounding rectangle has the specified
 * 			dimension.
 * 			If this cannot be resized to the specified dimension =>
 * 			this is not modified, throws hw1_package.ImpossibleSizeException
 * 			(the exception suggests an alternative dimension that is
 * 			 supported by this).
 */
public class ImpossibleSizeException extends Exception{

    private Dimension legalDimension;
    public ImpossibleSizeException(String errorMessage){
        super();
        legalDimension.setSize(64,64);
    }
    public Dimension getLegalDimension(){
        return this.legalDimension;
    }
}

//    The following things are essential for creating an immutable class:
//        o	Final class, which is declared as final so that it can't be extended.
//        o	All fields should be private so that direct access to the fields is blocked.
//        o	No Setters
//        o	All mutable fields should be as final so that they can not be iterated once initialized.

//package homework1;
//
//
//
///**
// * hw1_package.ImpossibleSizeException is an Exception that is thrown when the size is not positive.
// * This can provide new size.
// */
//
//public class hw1_package.ImpossibleSizeException extends Exception
//{
//    //==============================================================================
//    private static final long serialVersionUID = 1L;
//    private Dimension alternativeDim;
//    //==============================================================================
//    /**Abstraction Function
//     * A hw1_package.ImpossibleSizeException e is NaN if e.alternativeDim==null.
//     * A hw1_package.ImpossibleSizeException e is NaN if e.alternativeDim.getHeight()!=50 || e.alternativeDim.getWidth()!=50.
//     * Otherwise, A hw1_package.ImpossibleSizeException e is an exception that throws a new correct dimension.
//     */
//
//    /**Representation Invariant
//     * e.alternativeDim!=null && e.alternativeDim.getHeight()==50 &&  e.dim.getWidth()==50.
//     */
//
//    private void checkRep()
//    {
//        assert this.alternativeDim != null : "dimensions doesn't exist";
//        assert this.alternativeDim.getHeight() == 50 : "dimensions must be [50,50]";
//        assert this.alternativeDim.getWidth() == 50 : "dimensions must be [50,50]";
//    }
//    //==============================================================================
//    /**
//     * @effects Initializes this with constant height and width.
//     */
//    public hw1_package.ImpossibleSizeException()
//    {
//        this.alternativeDim.height = 50;
//        this.alternativeDim.width = 50;
//        checkRep();
//
//    }
//    //==============================================================================
//    /**
//     * @return a new valid size.
//     */
//    public Dimension getNewDim()
//    {
//        checkRep();
//        return this.alternativeDim;
//    }
//    //==============================================================================
//}


