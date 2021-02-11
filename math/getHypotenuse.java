import java.lang.*;

/* Gets hypotenuse of 2 numbers (change to work with other number datatypes)
@param Hypotenuse Width
@param Hypotenuse Height
@return Hypotenuse
*/

public static double getHypotenuse(double HypoWidth, double HypoHeight) {
    double hypotenuse;
    hypotenuse = Math.sqrt(Math.pow(HypoWidth, 2) + Math.pow(HypoHeight, 2));
    return hypotenuse;
}
