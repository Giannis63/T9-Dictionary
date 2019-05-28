package predictive;
import java.util.*;
/**
 * This class take as inputs signatures from the user
 * and prints the a set of the words that corresponds to the 
 * given signature.It use the ListDictionary.
 * @author Ioannis Kafantaris
 *
 */
public class Sigs2WordsList {
	
public static void main (String args[]) {
	//create the object
		ListDictionary n = new ListDictionary("C:\\dictionary.txt");
		//check to see if the user has given an input
		if(args.length==0) {
			System.out.println("Invalid Input");
		}
		//store the time when the program starts
		long startTime = System.currentTimeMillis();
		
		for(int i=0;i<args.length;i++) {
			//Check to see if the signature is valid
			if(args[i].matches("^[2-9]+$")) {
				System.out.println(args[i] + " " + ":"+ " " + n.signatureToWords((args[i])));
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Took "+ (endTime - startTime) + " ms");
	
	}
}
