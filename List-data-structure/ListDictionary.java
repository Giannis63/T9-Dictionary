package predictive;

import java.io.*;
import java.util.*;
/**
 * The class ListDictionary does the same job 
 * as the class PredictivePrototype but it 
 * uses a different method.The main difference with the PredictivePrototype 
 * is that the class ListDictionary stores the given dictionary
 * to an arraylist.
 * @author Ioannis Kafantaris
 *
 */
public class ListDictionary implements Dictionary {

private	String path;
 ArrayList<WordSig> dict = new ArrayList <WordSig>();
public ListDictionary (String path) {
	this.path = path;
		try {
			
		//ride the file from the given path
		 File file = new File(this.path);
		 file.canRead();
		 Scanner malak = new Scanner(file);
		 
		 while (malak.hasNextLine()) {
			 String line = malak.nextLine();
			 //if the word contains only letters
			 if(PredictivePrototype.isValidWord(line)) {
				 //consrtuct a new object lista that contains the word and the corresponding signature.
			 WordSig lista =new WordSig(line.toLowerCase(),PredictivePrototype.wordToSignature(line));
			 //add the object lista to the arraylist dict
			 dict.add(lista);
			 }
			 }
		 
		 malak.close();
		}catch(Exception ex) {
          ex.printStackTrace();
		}
		//Sort the arraylist by signature in ascending order
		Collections.sort(dict);
		
}
//This method takes as an input a given signature 
//and returns a set with all the words that have this signature
public  Set <String> signatureToWords(String signature){
	 Set<String> suggestions = new HashSet<String>();
	 //construct an object with the input signature
	WordSig s = new WordSig(" ",signature);
	//do a binary search and find the middle of the given signature inside the arraylist
	int x = Collections.binarySearch(dict, s);
	int y = x;
	//if the given signature is inside the arraylist
	 if(x>=0){
	        //add the words that are below the middle point
            while(dict.get(x).compareTo(s)==0 && x>0) {
    	    suggestions.add(dict.get(x).getWord());
    	      x--;
             }
            //add the words that are above the middle point
            while(dict.get(y).compareTo(s)==0 && y < dict.size() - 1) {
            	suggestions.add(dict.get(y).getWord());
            	y++;
            }
	 } 
	 //return a set with the words that correspond to this signature
	return suggestions;
	

}

	//public static void main (String args[]) {
	//	ListDictionary malaka = new ListDictionary("C:\\dictionary.txt");
	//reateFile("C:\\Test.txt",dict);
	//System.out.println(malaka.signatureToWords("2252"));
		//.print();
		//String x = "56546546";
		//System.out.println(Integer.parseInt(x));
		//String y = "6546546";
		//WordSig si = new WordSig("hello"," 2");
	//	signatureToWords(si);
		//System.out..psignatureToWords(si));

	}

