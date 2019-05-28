package predictive;
import java.util.*;
import java.io.*;
/**
 * This class takes as inputs words fron the user
 * and returns the corresponding signatures.
 * @author Ioannis Kafantaris
 *
 */
public class Words2SigProto {	
	public static void main(String[] args) {
		//Check if the user has given an input 
		if(args.length==0) {
			System.out.println("No given Input");
		}
		//keep track of the time
		long startTime = System.currentTimeMillis();
		for(int i=0;i<args.length;i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
			}
		 long endTime = System.currentTimeMillis();
		 System.out.println("Took "+ (endTime - startTime) + " ms");
		}
	}

