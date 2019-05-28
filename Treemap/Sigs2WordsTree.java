package predictive;
/**
 * This class take as inputs signatures from the user
 * and prints a set of words and prefix words that corresponds to the 
 * given signature.It uses the TreeDictionary class.
 * We also use a timer to check how much time this method needs to run
 * in order to compare it with the other methods that use a 
 * different data structure and see the time differences.
 * The time difference between the Sigs2WordsList, Sigs2WordsMap
 * and Sigs2WordsTree are noticeable especially between the first 
 * two.Also the fastest method among the three seems to be 
 * the Sigs2WordsMap because it needs the least time 
 * for a search.The comparison has been made using more than 
 * 100 inputs and as the number of inputs rises the search
 * time doesn't increase so much on the Sigs2WordsMap 
 * @author Ioannis Kafantaris
 *
 */
public class Sigs2WordsTree {

    public static void main (String args[]) {
       //Create the object TreeDictioanry
        TreeDictionary newDictionary = new TreeDictionary("dictionary.txt"); 
        //check to see if the input is null
        if (args.length == 0) { 
            System.out.println("the input is null");
        }
        long startTime = System.currentTimeMillis(); 
        for (int i=0;i<args.length;i++) {
        	//check to see if the signature is valid
        	if(args[i].matches("^[2-9]+$")) {
            System.out.println(args[i] + " " + ":"+ " " + newDictionary.signatureToWords((args[i]))); // print them
        	}
        }
        long endTime = System.currentTimeMillis(); // check and print the time
        System.out.println("Took "+ (endTime - startTime) + " ms"); // print the time
    }
}



