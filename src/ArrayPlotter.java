/**
 * ArrayPlotter.java  10/18/14
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 *
 * The ArrayPlotter class provides methods for drawing in
 *    a grid by setting the boolean values of a 2D array.
 *
 *    Each drawing method must
 *    - take zero arguments,
 *    - have a void return type, and
 *    - have a name that conforms to the on...ButtonClick format.
 *      (This restriction allows the GridPlotterGUI to recognize methods,
 *       for which it automatically generates buttons.)
 */

 import javax.swing.JOptionPane;

 public class ArrayPlotter
 {
     /** The Array Plotter Graphical User Interface. */
       private ArrayPlotterGUI gui;
 
     /** The Color Array.  The element values indicate how to color a grid cell:
      *  - true: Color the cell with the Drawing Color.
      *  - false: Color the cell with the Background Color.
      */
       private boolean[][] colorArray;
 
 
     /** Constructs an Array Plotter */
     public ArrayPlotter()
     {
         gui = new ArrayPlotterGUI(this);
         colorArray = null;
     }
 
     /** Initialize this's Color Array to a new 2D array of boolean values
      *  with the given dimensions.
      *  @param rows the number of rows in the new array.
      *  @param cols the number of columns in the new array.
      *  Postcondition: All of the Color Array's elements have the value false.
      */
     public void initializeColorArray(int rows, int cols)
     {
         colorArray = new boolean[rows][cols];
     }
 
 
       // Drawing Methods
 
      /** Removes all objects from the grid. */
     public void onClearGridButtonClick()
     {
         for (int r = 0; r < colorArray.length; r++)
             for (int c = 0; c < colorArray[0].length; c++)
                 colorArray[r][c] = false;
 
         gui.update(colorArray);
     }
 
     /** Fills in all the cells of the grid using a row-major traversal. */
     public void onRowMajorFillButtonClick()
     {
         //This one is a freebie.  This is what you need to do.
         for (int r = 0; r < colorArray.length; r++)
             for (int c = 0; c < colorArray[0].length; c++)
             {
                 //These two lines should never be seperated or changed for your other methods.
                 colorArray[r][c] = true;
                 gui.update(colorArray);
             }
     }
 //make new methods below here and do other fills
     public void onReverseRowMajorFillButtonClick() {
        for (int r = colorArray.length-1; r >= 0; r--) {
            for (int c = colorArray[r].length-1; c >= 0; c--) {
                colorArray[r][c] = true;
                gui.update(colorArray);
            }
        }
     }
 
 
 
 //This is for problem #11
 /** Fills in a grid row from left to right. */
     private void fillRowLeftToRight(boolean[] row)
     {
         for (int r = 0; r < row.length; r++)
         {
             row[r] = true;
             gui.update(colorArray);
         }
     }
 //This is for problem #11
     /** Fills in a grid row from left to right. */
     private void fillRowRightToLeft(boolean[] row)
     {
         for (int r = row.length - 1; r >= 0; r--)
         {
             row[r] = true;
             gui.update(colorArray);
         }
     }
 
       /** main method that creates the grid plotter application. */
     public static void main(String[] args)
    {
        new ArrayPlotter();
     }
 }
 