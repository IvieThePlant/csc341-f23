import java.util.*;

class List {

    /** Primary entry point into the tree */
    Node root = null;

    /** Count of elements in the List */
    int count = 0;

    /** Comparator for ordering tree. Uses compareTo of Track by default */
    Comparator<Simple> ordering = new Comparator<Simple>() {
        @Override
        public int compare(Simple simple1, Simple simple2) {
            return simple1.compareTo(simple2);
        }
    };

    /**
     * Sentinal for leaf nodes. This node should be both the left and right child of
     * all leaf nodes
     */
    Node dummy = new Node(null);

    public List() {
        // TODO: write default constructor
    }

    public List(Comparator<Simple> order) {
        ordering = order;
    }

    @Override
    /**
     * Returns space separated values of the whole tree, in order
     */
    public String toString() {
        return toString(root);
    } // end toString()

    /**
     * Private recursive function for toString()
     * 
     * @param n Node at recursive step
     * @return String of all values to the left, own value, and all values to the
     *         right
     */
    private String toString(Node n) {
        if (n == dummy) {
            return " ";
        }
        return toString(n.left) + n.value + toString(n.right);
    } // end toString(n)

    /**
     * Adds new Node with value to the tree, according to Comparator
     * 
     * @param simple Value to add to tree
     */
    public void add(Simple simple) {
        // Create new node
        Node newNode = new Node(simple);

        // If list empty, set as new head
        if (isEmpty()) {
            root = newNode;
            count++;
            return;
        }

        // Otherwise, look through list until you are at dummy, then add to one before
        Node pointer = root;
        Node setter = null;
        int comparison = 0;
        while (pointer != dummy) {
            setter = root;
            comparison = ordering.compare(newNode.value, pointer.value);
            if (comparison < 0) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }

        if (comparison < 0) {
            setter.left = newNode;
        } else {
            setter.right = newNode;
        }
        count++;
    } // end add(simple)

    /**
     * Finds node with first simple with any matching value
     * 
     * @param simple Simple to compare with
     * @return Simple that has at least 1 matching parameter, else null
     */
    public Simple get(Simple simple) {
        // Search through tree, returning matching value, or null if reach dummy
        Node pointer = root;
        while (pointer != dummy) {
            int comparison = ordering.compare(simple, root.value);
            if (comparison == 0) {
                return pointer.value;
            }
            if (comparison < 0) {
                pointer = pointer.left;
            }
            if (comparison > 0) {
                pointer = pointer.right;
            }
        }
        return null;
    } // end get(simple)

    /**
     * Finds node with first simple with matching string value
     * 
     * @param value String to search for
     * @return Simple that has matching string value, else null
     */
    public Simple find(String value) {
        // Search through tree, returning matching value, or null if reach dummy
        Node pointer = root;
        while (pointer != dummy) {
            int comparison = value.compareTo(root.value.alpha);
            if (comparison == 0) {
                return pointer.value;
            }
            if (comparison < 0) {
                pointer = pointer.left;
            }
            if (comparison > 0) {
                pointer = pointer.right;
            }
        }
        return null;
    } // end find(value)

    /**
     * Finds node with first simple with matching Integer value
     * 
     * @param value Integer to search for
     * @return Simple that has matching Integer value, else null
     */
    public Simple find(Integer value) {
        // Search through tree, returning matching value, or null if reach dummy
        Node pointer = root;
        while (pointer != dummy) {
            int comparison = value - root.value.number;
            if (comparison == 0) {
                return pointer.value;
            }
            if (comparison < 0) {
                pointer = pointer.left;
            }
            if (comparison > 0) {
                pointer = pointer.right;
            }
        }
        return null;
    } // end find(value)

    /**
     * Finds the minnimum value in list
     * 
     * @return Smallest Simple stored in list
     */
    public Simple min() {
        // Go as far left as possible, and return
        Node pointer = root;
        while (root.left != dummy) {
            pointer = pointer.left;
        }
        return pointer.value;
    } // end min()

    /**
     * Finds the maxximum value in list
     * 
     * @return Biggest Simple stored in list
     */
    public Simple max() {
        // Go as far right as possible, and return
        Node pointer = root;
        while (root.right != dummy) {
            pointer = pointer.right;
        }
        return pointer.value;
    } // end max()

    /**
     * Checks if list is empty
     * 
     * @return True if empty, else false
     */
    public boolean isEmpty() {
        return count == 0;
    } // end isEmpty()

    /**
     * Converts the tree into an array, sorted by Comparator
     * 
     * @return Simple array of all values in list, sorted
     */
    public Simple[] toArray() {
        // TODO: write toArray()
        Simple[] newArray = new Simple[count];
        toArray(newArray, 0, root);
        return toArray();
    } // end toArray()

    private int toArray(Simple[] newArray, int added, Node n) {
        // Base case
        if (n == dummy) {
            return added;
        }

        // Add all Nodes to the left of Node to array
        added = toArray(newArray, added, n.left);

        // Add Node to array

        // Add all Nodes to the right of Node to array

        return added;
    }

    class Node {
        // Node's stored value
        Simple value;
        // Node's left child node(lesser)
        Node left;
        // Node's right child node(greater)
        Node right;

        /**
         * Node default constructor
         */
        Node() {
            value = null;
            left = dummy;
            right = dummy;
        }

        /**
         * Node constructor with given value
         * 
         * @param t Value to be stored in node
         */
        Node(Simple t) {
            value = t;
            left = dummy;
            right = dummy;
        }

        /**
         * Prints out node value, left child's value, and right child's value
         */
        void print() {
            System.out.print(value);
            System.out.print(" (L: " + left.value + ") ");
            System.out.println(" (R: " + right.value + ")");
        }
    } // end class Node
} // end class List
