package predictive;

import java.io.*;
import java.util.*;
/**
 * This class creates a dictionary of words
 * using a Tree (Trie) data structure.
 * @author Ioannis Kafantaris
 * @param String path,line,Map root,Set words
 */
public class TreeDictionary implements Dictionary {
     private String path; 
     private HashMap<Character,MakeNodes> root = new HashMap<Character,MakeNodes>();
     private String line;
     private Set <String> words;
public  TreeDictionary(String path) {
	 
	this.path = path;
	try {
		//read the file from the path
		 File file = new File(this.path);
		 file.canRead();
		 Scanner dict = new Scanner(file);
		 //while inside the file there is a next line
		 while (dict.hasNextLine()) {
			 line = dict.nextLine();
			 //check if the given word contains only alphabetic characters
			 if(PredictivePrototype.isValidWord(line)) {
				String sign = PredictivePrototype.wordToSignature(line);
				//remove all the white spaces from the signature
				 String sign1 = sign.strip();
				 //insert the signature into the trie dictionary
				insert(sign1);
			 }
		 }
		 dict.close();
		 
		 }catch(Exception ex) {
	      ex.printStackTrace();
		}
}
//if the length of the signature is greater than 1 this method
//will call the insertSign method which will insert the signature
//recursively to all the children of this node.
//If the length of the signature is 1 then the method will insert 
//the signature to the node and stop because the node doesnt have 
//any children to insert the word to.
public void insert(String signature) {
	//if the root doesn't contain the first charactrer of the signature
	if (root.containsKey(signature.charAt(0))==false) {
		//put the character in the map
		root.put(signature.charAt(0), new MakeNodes());
		//store the signature into the set of this node
		root.get(signature.charAt(0)).store.add(line.toLowerCase());
		
	}
	if(signature.length()>=2){
		//call the method to insert recursively the signature
		//to all of the children of this node
	insertSign(signature.substring(1),root.get(signature.charAt(0)));
	}
	}

//A method that inserts recursively the signature inside all
// of the remaining children of this node
	private void insertSign(String str, MakeNodes node) {
		final MakeNodes nextChild;
		//check to see if this path already exists,
		//so check if the child contains the next character
		//of the signature
		if (node.children.containsKey(str.charAt(0))) {
			//store the word into the set of every child
			node.store.add(line.toLowerCase());
			node.children.get(str.charAt(0)).store.add(line.toLowerCase());
			//take the children of this node
			nextChild = node.children.get(str.charAt(0));
		} else {
			//add the signature into the node
			node.store.add(line.toLowerCase());
			//this node doesn't have any children
			//so all of it's children are leaf nodes
			nextChild = new MakeNodes();
			node.children.put(str.charAt(0), nextChild);
		}	
		if (str.length() == 1) {
			//we have reached to the last character of the signature
			//so the children of this node are the last ones,
			// they are the leaf nodes
			nextChild.endofSign = true;
			return;
		} else {
			//if the length is greater than one take the next
			//character of the signature and continue on inserting the
			// signature to the children
			insertSign(str.substring(1),nextChild);
		}
	}
	/**
	 * This method search if a signature exists
	 * in the Trie dictionary
	 * @param str the signature to search
	 */
	public boolean search(String str) {
		if (root.containsKey(str.charAt(0))) {
			if (str.length()==1) {
				//this is the set of words that we want to return
				//because this is where the path ends
				words =(root.get(str.charAt(0)).store);
				return true;
			}
			//continue on searching the path
			return searchPath(str.substring(1),root.get(str.charAt(0)));
		} else {
			return false;
		}	
	}
	//Method that searches recursively the trie to find if the path of the
	//given signature exists inside the tree.
		private boolean searchPath(String string, MakeNodes node) {
			if (string.length()==0) {
				//if this is the last node then we reached at the
				//end of the path
				if (node.endofSign) {
					//this is the set of words that we want to return
					//because it corrsponds to the given signature
					words = node.store;
					return true;
				} else {
					return false;
				}
			}
			
			if (node.children.containsKey(string.charAt(0))) {
				//keep on searching the path
				//so keep on checking the children and find where the path ends
				return searchPath(string.substring(1),node.children.get(string.charAt(0)));
			} else {
				return false;
			}
		}
	
		/**
		 * This Method take as an input a signature and 
		 * returns a set of words and prefix words that
		 * correspond to given signature.
		 * @param signature
		 * @return Set <String> temp
		 */
public Set <String> signatureToWords(String signature){
	//check to see if the signature exists in the tree
if(search(signature)) {
	Set <String> temp = new HashSet <>();
	//return only the words that have the same length 
	//as the input signature
	words.forEach((s) -> temp.add(s.substring(0, signature.length())));
	return temp;
}else {
	System.out.println("Invalid Signature");
	return new HashSet <String> ();
}
}
		public static void main (String args[]) {
			TreeDictionary ka = new TreeDictionary("dictionary.txt");
			System.out.println(ka.signatureToWords("2"));
		}
	
}