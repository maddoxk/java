import java.lang.*;

/** Finds Average of all Elements in an Array
@param Array Name
@return Array Average
*/
  public static int getAverageArray(int[] x) {
    int Sum = 0;
    for (int i = 0; i < x.length; i++) {
      Sum = Sum + x[i];
    }
    int Average = Sum / x.length;
    return Average;
  }
