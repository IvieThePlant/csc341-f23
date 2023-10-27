import java.util.*;

class List {

	/** Primary entry point into the tree */
	Simple head = null;

    /** Count of elements in the List */
    int count = 0;

    /** Comparator for ordering tree. Uses compareTo of Track by default */
    Comparator<Simple> ordering = new Comparator<Simple>() {
        @Override
        public int compare(Simple simple1, Simple simple2) {
            return simple1.compareTo(simple2);
        }
    };

    /** Sentinal for leaf nodes. This node should be both the left and right child of all leaf nodes */
    Node dummy = new Node(null);

    public List() {
    
    }

    public List(Comparator<Simple> order) {
        ordering = order;
    }

    @Override
    public String toString() {
        return null;

    }
  
    public void add(Simple simple) {
    
    }
    
    public Simple get(Simple simple) {
        return null;
    }
    
    public Simple find(String value) {
    	return null;
    }
    
    public Simple find(Integer value) {
    	return null;
    }
    
    public Simple min() {
        return null;
    }

    public Simple max() {
        return null;
    }

    Simple[] toArray() {
        return null;
    }

    class Node {
    	Simple value;
    	Node left;
    	Node right;

    	Node(Simple t) {
    		value = t;
    	}
    	
    	void print() {
    		System.out.print(value);
			System.out.print(" (L: "+left.value+") ");
    		System.out.println(" (R: "+right.value+")");
    	}
    } // end class Node
} // end class List

