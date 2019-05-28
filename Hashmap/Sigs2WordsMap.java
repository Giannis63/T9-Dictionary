package predictive;
/**
 * This class take as inputs signatures from the user
 * and prints a set of the words that corresponds to the 
 * given signature.It uses the MapDictionary class. 
 * @author Ioannis Kafantaris
 *
 */
public class Sigs2WordsMap {
	
	public static void main (String args[]) {
		//construct the object
			MapDictionary dictionary = new MapDictionary("C:\\dictionary.txt");
			//check to see if the user has typed an input
			if(args.length==0) {
				System.out.println("Invalid Input");
			}
			 long startTime = System.currentTimeMillis();
			for(int i=0;i<args.length;i++) {
				//check to see if the signature is valid
				if(args[i].matches("^[2-9]+$")) {
					System.out.println(args[i] + " " + ":"+ " " + dictionary.signatureToWords((args[i])));
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Took "+ (endTime - startTime) + " ms");
		
		}
	}

