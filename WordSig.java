package predictive;
import java.math.BigInteger;
import java.util.*;

/**
 * This class constructs an object that contains two values
 * A word and it's corresponding signature
 * @author Ioannis Kafantaris
 *
 */
public class WordSig implements Comparable<WordSig> {
	private String words;
	private String signature;
	
	
	public WordSig (String words, String signature) {
		this.words=words;
		this.signature=signature;
	}
	//We override the compareTo inside the comparable interface because 
	//when we call the method sort the method sort must know with which element
	//in mind it should sort the list. Also, the same thing applies when 
	//we use the binary search method.
	@Override
    public int compareTo(WordSig ws) {
        String sign = this.getSignature().replaceAll("\\s","");
        String sign2 = ws.getSignature().replaceAll("\\s","");
        BigInteger word1 = new BigInteger(sign);
        BigInteger word2 = new BigInteger(sign2);


            return (word1.compareTo(word2));


    }
	
	//getters for signature and words
	public String getSignature() {
		return signature;
	}
	public String getWord() {
		return words;
	}

	@Override
	public String toString() {
	    return "Word " + this.words + 
	           ", Signature " + this.signature;
	}
	/**public static void main (String args[]) {
		WordSig x = new WordSig("hello","4756");
		WordSig y = new WordSig("home","4663");
		System.out.println(x.compareTo(y));
	}*/
}
