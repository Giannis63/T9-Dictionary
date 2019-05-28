package predictive;
import java.util.*;
/**
 * This class constructs the nodes of the Tree.
 * Every node contains a set of words and prefix words
 * that correspond to the given signature.
 * Every node has a map that as keys has a character from the set [2-9]
 * and every one of those keys has as values it's children,
 * which also has as keys characters from the set [2-9].
 * Basically, each node has up to 8 branches and I use a Map
 * to keep track of each children of every node and map all those children to their parents
 * instead of using an array.
 * The variable boolean endofSign shows if we have read the whole signature and
 * reached the end of the path. If that's the case that means that
 * we have traversed the tree and found the path that corresponds 
 * to the given signature.
 * @author Ioannis Kafantaris
 * 
 */
public class MakeNodes {

    	 boolean endofSign = false;
    	  Map<Character, MakeNodes> children = new HashMap <>();
    	 Set <String> store = new HashSet<>();
        
    }
