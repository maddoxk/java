import java.lang.*;

/* Usage:
isFound = searchArray(numberArray, searchNumber);
    if (isFound == true) {
      System.out.println(searchNumber + " is in the array.");
    } else {
      System.out.println(searchNumber + " is NOT in the array.");
    }
*/

/** Finds an element in an Array (works on all array datatypes)
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







