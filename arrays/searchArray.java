import java.lang.*;

/** Finds an element in an Array
@param Array Name
@param Element to search for
@return Array Average
*/
  public static boolean searchArray(int[] x, int y) {
    boolean isFound = false;
    for (int i = 0; i < x.length; i++) {
      if (x[i] == y) {
        isFound = true;
      }
    }
    return isFound;
  }
