package predictive;
import java.util.*;
import java.io.*;

/**This class implements a prototype method 
 * for the predictive text system. Basically, 
 * this class has two methods the wordTosignature which converts the 
 * given words to their corresponding signature and the method
 * signatureToWords which converts a given word to it's signature.
 * This method is inefficient because every time we want to find
 * the set of words that correspond to the given signature
 * the method needs to read the whole dictionary for each signature
 * that it wants to proccess.
 * @author Ioannis Kafantaris
 *@param String word, String signature
 */
public class PredictivePrototype {
	
	public static String wordToSignature(String word) {
		//We use stringbuffer because it's faster than the String
		//and consumes less memory when you cancat strings.
	    StringBuffer inputWord = new StringBuffer();
         //We use a for loop to read it's character of the word separately. 
	    for(int i = 0; i < word.length(); i++){
	    	//we divide the word into characters.
	        char ch = word.toLowerCase().charAt(i);
            //We see to which category the character of the word belongs to
	        if(ch=='a'||ch=='b'||ch=='c') {
	            inputWord.append(2);
	        }
	        else if(ch=='d'||ch=='e'||ch=='f'){
	            inputWord.append(3);
	        }
	        else if(ch=='g'||ch=='h'||ch=='i'){
	            inputWord.append(4);
	        }

	        else if(ch=='j'||ch=='k'||ch=='l'){

	            inputWord.append(5);
	        }

	        else if(ch=='m'||ch=='n'||ch=='o'){
	            inputWord.append(6);
	        }
	        else if(ch=='p'||ch=='q'||ch=='r'|| ch=='s'){
	            inputWord.append(7);
	        }
	        else if(ch=='t'||ch=='u'||ch=='v'){
	            inputWord.append(8);
	        }

	        else if(ch=='w'||ch=='x'||ch=='y'||ch=='z'){
	            inputWord.append(9);

	        }else {
	            inputWord.append(" ");
	        }
	    }
	    //return the signature of the word.
	    return inputWord.toString();
	} 
	//This method takes a signature as an inpu and returns 
	//a set of words that correspond to this singature.
	//It uses a given dictionary without storing it .
	public static Set <String> signatureToWords(String signature){
		 Set<String> suggestions = new HashSet<String>();
		 try {
                //read the file dictionary
	            File file = new File("C:\\dictionary.txt");
	            Scanner input = new Scanner(file);
	            
	            //while the dictionary has next line continue.
	           while (input.hasNextLine()) {
	              String line = input.nextLine();
	              //if the word contains only letters 
	              if(isValidWord(line)){ 
	            	  //go call the method and find the word's signature
	              String tempsignature= wordToSignature(line);
	              //if the word's signature equals with the input signature
	                 if(signature.equals(tempsignature)){
	                	//add the word into the set suggestions. 
	            	  suggestions.add(line.toLowerCase());
	                  }
	               }
	            }
	            input.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return suggestions;
	}
	//The method that checks if the word contains only letters
	static boolean isValidWord(String word) {
		if(word.matches("[a-zA-Z]+")) {
			return true;
		}else {
			return false;
		}
	    
	}
	
	public static void main(String args[]) {
		System.out.println(wordToSignature("baja"));
		 System.out.print(signatureToWords("2"));
         
		        
		    }
	}
