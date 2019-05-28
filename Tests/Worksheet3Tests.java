package predictive;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class Worksheet3Tests {

    // Testing PredictivePrototype
    // Testing wordToSignature

    @Test // Test a random word
    public void wordToSignature1() {
        String word = "home";
        assertEquals(PredictivePrototype.wordToSignature(word),"4663");
    }

    @Test // Test a word which contains spaces
    public void wordToSignature2() {
        String word = " ";
        assertEquals(PredictivePrototype.wordToSignature(word)," ");
    }

    @Test // Test a word which contains non-alphabetic characters
    public void wordToSignature3() {
        String word = "1234";
        assertEquals(PredictivePrototype.wordToSignature(word),"    ");
    }

    @Test // Test a word that contains spaces,letters,symbols,numbers
    public void wordToSignature4() {
        String word = "home4565 #$";
        assertEquals(PredictivePrototype.wordToSignature(word),"4663       ");
    }
 // Test a word with spaces,letters,UPPERCASE letters
    @Test 
    public void wordToSignature5() {
        String word = "home1234 #$HOME";
        assertEquals(PredictivePrototype.wordToSignature(word),"4663       4663");
    }

    // signatureToWords tests

 // Testing a random signature
    @Test 
    public void signatureToWords() {
        String word = "4663";
        Set<String> matchwords = Set.of("hood", "ione", "ioof", "good", "hond", "inne", "gond", "hone", "hoof", "gone", "goof", "home", "gome");
        assertEquals(PredictivePrototype.signatureToWords(word),matchwords);
    }
 // Test a non valid signature
    @Test 
    public void signatureToWords1() {
        String word = "";
        Set<String> matchwords = Set.of();
        assertEquals(PredictivePrototype.signatureToWords(word),matchwords);
    }
 // Test a non valid signature
    @Test
    public void signatureToWords2() {
        String word = "a1234";
        Set<String> matchwords = Set.of();
        assertEquals(PredictivePrototype.signatureToWords(word),matchwords);
    }
     // Test the given text for duplicates 
    @Test 
    public void signatureToWords3() {
        String word = "2";
        Set<String> matchwords = Set.of("a","b","c");
        assertEquals(PredictivePrototype.signatureToWords(word),matchwords);
    }

    // Tests the isValidWord method

    // Testing a word with non-alphabetic
    @Test 
    public void isValidWord1() {
        String word = "2abGf%^   ";
        assertEquals(PredictivePrototype.isValidWord(word),false);
    }
    // Test for a word with alphabetic characters
    @Test 
    public void isValidWord2() {
        String word = "asdaADERQ";
        assertEquals(PredictivePrototype.isValidWord(word),true);
    }

    // Tests for the ListDictionary

    // Test if the given signature matches the words from the listDictionary
    @Test 
    public void ListDictionary1() {
        ListDictionary dictionaryPath = new ListDictionary("Test.txt");
        Set<String> test = Set.of("m","n","o");
        assertEquals(dictionaryPath.signatureToWords("6"), test);
    }
     // Test if the given signature matches the words from the listDictionary
    @Test
    public void ListDictionary2() {
        ListDictionary dictionaryPath = new ListDictionary("empty.txt");
        Set<String> test = Set.of();
        assertEquals(dictionaryPath.signatureToWords("6"), test);
    }

    @Test 
    public void ListDictionary3() {
        ListDictionary dictionaryPath = new ListDictionary("dictionary.txt");
        Set<String> test = Set.of("gome", "gond", "gone", "good", "goof", "home", "hond", "hone", "hood", "hoof", "inne", "ione", "ioof");
        assertEquals(dictionaryPath.signatureToWords("4663"), test);
    }

    // Tests for the WordSig
    
     // Test 2 values with compareTo (word1 is lower than word2)
    @Test 
    public void WordSig1() {
        WordSig word1 = new WordSig(null, "2");
        WordSig word2 = new WordSig(null, "22222222");
        assertEquals(word1.compareTo(word2),-1);
    }
    
     // Test for 2 values with compareTo (word1 is bigger than word2)
    @Test 
    public void WordSig2() {
        WordSig word1 = new WordSig(null, "22222222");
        WordSig word2 = new WordSig(null, "2");
        assertEquals(word1.compareTo(word2),1);
    }

    @Test // Test for 2 values with compareTo (word1 is equal with word2)
    public void WordSig3() {
        WordSig word1 = new WordSig(null, "2");
        WordSig word2 = new WordSig(null, "2");
        assertEquals(word1.compareTo(word2),0);
    }

    // Tests for the MapDictionary
    
    // Test if the given signature matches the words from the mapDictionary
    @Test 
    public void MapDictionary1() {
        MapDictionary dictionaryPath = new MapDictionary("Test.txt");
        Set<String> test = Set.of("a","b","c");
        assertEquals(dictionaryPath.signatureToWords("2"), test);
    }

    @Test // Test the case of an empty dictionary
    public void MapDictionary2() {
        MapDictionary dictionaryPath = new MapDictionary("empty.txt");
        Set<String> test = Set.of();
        assertEquals(dictionaryPath.signatureToWords("6"), test);
    }

    // Test if the given signature matches the words from the mapDictionary
    @Test 
    public void MapDictionary3() {
        MapDictionary dictionaryPath = new MapDictionary("dictionary.txt");
        Set<String> test = Set.of("gome", "gond", "gone", "good", "goof", "home", "hond", "hone", "hood", "hoof", "inne", "ione", "ioof");
        assertEquals(dictionaryPath.signatureToWords("4663"), test);
    }

    // Testing TreeDictionary

     // Test if the given signature matches the words from the mapDictionary
    @Test 
    public void TreeDictionary1() {
        TreeDictionary dictionaryPath = new TreeDictionary("dictionary.txt");
        Set<String> test = Set.of("gnof", "gome", "gond", "gone", "gonf", "hood", "gooe", "goof", "home", "hond", "hone", "honf", "good", "hooe", "hoof", "imme", "inme", "inne", "inod", "inoe", "inof", "ione", "ioof");
        assertEquals(dictionaryPath.signatureToWords("4663"), test);
    }
    
    // Test for an empty dictionary
    @Test 
    public void TreeDictionary2() {
        TreeDictionary dictionaryPath = new TreeDictionary("empty.txt");
        Set<String> test = Set.of();
        assertEquals(dictionaryPath.signatureToWords("4663"), test);
    }
     // Test if the given signature matches the words from the mapDictionary
    @Test 
    public void TreeDictionary3() {
        TreeDictionary dictionaryPath = new TreeDictionary("Test.txt");
        Set<String> test = Set.of("a","b","c");
        assertEquals(dictionaryPath.signatureToWords("2"), test);
    }
}
