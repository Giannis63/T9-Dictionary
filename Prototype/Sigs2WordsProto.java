package predictive;
import java.util.*;
import java.io.*;
/**
 * This class take as inputs signatures from the user
 * and returns the corresponding words to the given signatures
 * @author Ioannis Kafantaris
 *
 */
public class Sigs2WordsProto {
	//Check how much time the program needs to run
	static long startTime = System.nanoTime();
	
	public static void main (String args[]) {
		if(args.length==0) {
			System.out.println("Invalid Input");
		}
		for(int i=0;i<args.length;i++) {
			//check first if the given signature is correct and then
			//go search for the corresponding words
			if(args[i].matches("^[0-9]+$")) {
				System.out.println(args[i] + " " + ":"+ " " + PredictivePrototype.signatureToWords(args[i]));
			}
		}
		long endTime = System.nanoTime();
		//print how much time this class took to complete
		//for the civen inputs
		System.out.println("Took "+ (endTime - startTime) + " ns");
	
	}
}
