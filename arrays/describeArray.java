import java.lang.*;

/** Outputs each value in an Array
@param Array Name
@print Array Values
*/
  public static void describeArray(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print(x[i] + " "); //I could only find a way to print and not return this, sorry.
    }
  }
