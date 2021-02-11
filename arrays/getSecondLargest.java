import java.util.*;
import java.lang.*;

/** Finds 2nd Largest of all Elements in an Array
@param Array Name
@return SecondLargest Number
*/
  public static int getSecondLargest(int[] x) {
    int temp;
    for (int i = 0; i < x.length; i++) {
      for (int j = i + 1; j < x.length; j++) {
        if (x[i] > x[j]) {
          temp = x[i];
          x[i] = x[j];
          x[j] = temp;
        }
      }
    }
    return x[x.length - 2];
  }
