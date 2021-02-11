import java.lang.*;

/** Finds Largest of all Elements in an Array
@param Array Name
@return Largest Number
*/
  public static int getLargestElement(int[] x) {

    int max = x[0];
    for (int i = 1; i < x.length; i++) { // For loop that compares each element of the Array
      if (x[i] > max) {
        max = x[i];
      }
    }
    return max;
  }
