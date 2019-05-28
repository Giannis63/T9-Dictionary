package predictive;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class creates a dictionary of words using
 * a Map data structure.
 * @author Ioannis Kafantaris
 * 
 */
public class MapDictionary {
String path;
Map <String ,Set <String>>  wordsmap = new HashMap ();
//The constructor of the class
public MapDictionary(String path){
	this.path = path;
	try {
		
	//Reads the file from the given path
	 File file = new File(this.path);
	 file.canRead();
	 Scanner dict = new Scanner(file);
	 //while the file has next line 
	 while (dict.hasNextLine()) {
		 //take this line 
		 String line = dict.nextLine();
		 //check if the word is valid
		 if(PredictivePrototype.isValidWord(line)) {
			 //find the signature of the given word
			String sign = PredictivePrototype.wordToSignature(line);
			//check if the map contains this signature
				if(wordsmap.containsKey(sign)) {
					//add the word to the set
					wordsmap.get(sign).add(line.toLowerCase());
				}else {
					//put the signature in the map and create a new set
					wordsmap.put(sign, new HashSet <String> ());
					//add the word to the specific set
					wordsmap.get(sign).add(line.toLowerCase());
				}
			}
		 }
	//close the scanner
	 dict.close();
	}catch(Exception ex) {
      ex.printStackTrace();
	}

}
/**
 * This Method take as an input a signature and 
 * returns a set of Words that correspond to the
 * given signature.
 * @param signature
 * @return Set <String>
 */
public  Set <String> signatureToWords(String signature){
	//if the signature exists in the map
	if(wordsmap.containsKey(signature)){
		//return the set of words
		return wordsmap.get(signature);
	}else {
	//the signature doesn't exist in the map.
	//wrong signature	
	System.out.println("Invalid Signature");
	//return an empty set.
	return  new HashSet<String> ();
	}
	}
		
public static void main(String args[]) {
	MapDictionary dwse = new MapDictionary("C:\\dictionary.txt");
	
System.out.println(dwse.signatureToWords("2"));
}
}
