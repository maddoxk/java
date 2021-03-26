import java.util.*;
import java.lang.*;

public class SieveKrape {
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System. in );
    System.out.print("What number would you like to find all primes up to? ");
    int maxNumber = inputScanner.nextInt();
    boolean[] boolArray = new boolean[maxNumber];
    boolArray[0] = false;
    for (int i = 1; i < maxNumber; i++) {
      boolArray[i] = true;
    }
    for (int j =  2; j <= maxNumber; j++) {
      if (boolArray[j - 1] == true) {
        System.out.println(j);
        for (int l = 2 * j; l <= maxNumber; l += j) { // Crosses out element
          boolArray[l - 1] = false;
        }
      }
    }
  }
}