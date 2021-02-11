import java.lang.*;

/** Finds sum of all Elements in an Array
@param Array Name
@return Array Sum
*/
  public static int SumOfAllElements(int[] x) {

    int Sum = 0;

    for (int i = 0; i < x.length; i++) {
      Sum = Sum + x[i];
    }
    return Sum;
  }
