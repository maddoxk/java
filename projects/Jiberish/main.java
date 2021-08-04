import java.lang.*;
import java.util.*;
import java.io.File;

public class main {

	public static void main(String args[]) {

		if (args[0].equals("f")) {
			System.out.println("Using: File");
			File f = new File(args[1]);
			if (f.exists() == false) {
				f = new File(System.getProperty("user.dir") + "/" + args[1]);
			}
			System.out.println(f);
		} else if (args[0].equals("s")) {
			int totalChar = 0;
			for (int j = 1; j < args.length; j++) {
				for (totalChar = totalChar; totalChar < args[j].length(); totalChar++) {
				}
			}
			System.out.print("\nUsing: String(s)" + "| Number of Strings = ");
			System.out.print(args.length - 1 + " | Total Character Number = " + totalChar);
			for (int i = 0; i < args.length; i++) {
				System.out.println(i);
				printArray((mixMethod(args[i])));
			}
		}
	}

	public static String[] mixMethod(String x) {

		String[] arr = new String[x.length()];
		for (int i = 0; i < x.length(); i++) {
  			arr[i].equals(x.charAt(i));
		}
		return arr;
	}

	public static void printArray(String[] x) {
		for (int i = 0; i < x.length; i++) {
     			System.out.print(x[i] + " ");
    		}
	}

}
