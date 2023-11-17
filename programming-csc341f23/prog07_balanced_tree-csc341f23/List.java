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
        root = null;
        count = 0;
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
     * Then traversed back up the tree, updating heights
     * If it ever finds a node out of balance by at least 10, triggers
     * reconstruction
     * 
     * @param simple Value to add to tree
     */
    public void add(Simple simple, boolean rebuilding) {
        // Create new node
        Node newNode = new Node(simple);

        // If list empty, set as new head
        if (isEmpty()) {
            root = newNode;
            count++;
            root.height = 0;
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
        // Add the new node as a leaf (height 0) to either the left or the right
        if (comparison < 0) {
            setter.left = newNode;
        } else {
            setter.right = newNode;
        }
        newNode.parent = setter;
        newNode.height = 0;
        count++;

        // Then, climb back up the list adjusting height using pointer
        // Pointer starts at newNode, and changed height of parent if needed
        pointer = newNode;
        while (pointer != root) {
            if ((pointer.parent.compareHeight()) >= 10 && !rebuilding) {
                balance();
            }
            if (pointer.height == pointer.parent.height) {
                pointer.parent.height++;
            }
            pointer = pointer.parent;
        }
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
            int comparison = ordering.compare(simple, pointer.value);
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
     * Find Node in Tree with matching Simple value, or null if reach dummy
     * 
     * @param value Simple to search for
     * @return Node with matching Simple, or null if not found
     */
    public Node find(Simple value) {
        Node pointer = root;
        while (pointer != dummy) {
            int comparison = ordering.compare(value, pointer.value);
            if (value.equals(pointer.value)) {
                return pointer;
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
     * Finds first node with matching simple's string value
     * 
     * @param value String to search for
     * @return Simple that has matching string value, else null
     */
    public Simple find(String value) {
        return find(value, root);
    } // end find(value)

    /**
     * Private recursive method for find(value)
     * 
     * @param value String being searched for in tree
     * @param n     Current pointer node
     * @return Matching Simple when found, else null
     */
    private Simple find(String value, Node n) {
        // Base Case: If at dummy return null
        if (n == dummy) {
            return null;
        }

        // Check the left subtree for value
        Simple s = find(value, n.left);
        if (s != null) {
            return s;
        }

        // Check current node
        if (value.equals(n.value.alpha)) {
            return n.value;
        }

        // Check thr right subtree for value
        s = find(value, n.right);
        if (s != null) {
            return s;
        }

        // If not found, return null
        return null;
    }

    /**
     * Finds node with first simple with matching Integer value
     * 
     * @param value Integer to search for
     * @return Simple that has matching Integer value, else null
     */
    public Simple find(Integer value) {
        return find(value, root);
    } // end find(value)

    /**
     * Private recursive method for find(value)
     * 
     * @param value Integer being searched for in tree
     * @param n     Current pointer node
     * @return Matching Simple when found, else null
     */
    private Simple find(Integer value, Node n) {
        // Base Case: If at dummy, return null
        if (n == dummy) {
            return null;
        }

        // Check the left subtree for value
        Simple s = find(value, n.left);
        if (s != null) {
            return s;
        }

        // Check current node
        if (value.equals(n.value.number)) {
            return n.value;
        }

        // Check the right subtree for value
        s = find(value, n.right);
        if (s != null) {
            return s;
        }

        // If not found, return null
        return null;
    }

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
        Simple[] newArray = new Simple[count];
        toArray(newArray, 0, root);
        return toArray();
    } // end toArray()

    /**
     * Private recursive method for adding all tree values in order to given array
     * 
     * @param newArray The array to add values to
     * @param added    The amount of values already added to newArray, but also the
     *                 index of the next element to be added
     * @param n        The curent pointer Node
     * @return The new amount of added values to newArray
     */
    private int toArray(Simple[] newArray, int added, Node n) {
        // Base case
        if (n == dummy) {
            return added;
        }

        // Add all Nodes to the left of Node to array
        added = toArray(newArray, added, n.left);

        // Add Node to array
        newArray[added] = n.value;
        added++;

        // Add all Nodes to the right of Node to array
        added = toArray(newArray, added, n.right);

        return added;
    } // end toArray(newArray, added, n)

    /**
     * Turn Tree into an array, then re-sort it with the given Comparator
     * 
     * @param comp Comparator to sort returned array by
     * @return Sorted Simple Array, sorted by given Comparator
     */
    public Simple[] toArray(Comparator<Simple> comp) {
        // Get standard sorted array
        Simple[] toSort = toArray();

        // If given Comparator is same as current current Comparator, return array
        if (ordering == comp) {
            return toSort;
        }

        // Create a new array to sort into
        Simple[] sorted = new Simple[toSort.length];
        int sortCount = 0;

        // For each value in toSort, add it to the new array
        for (Simple element : toSort) {
            // Find the index of the first value larger than it, or first null
            int idx = 0;
            while ((sorted[idx] != null) && (comp.compare(sorted[idx], element) > 0)) {
                idx++;
            }

            // Count the value about to be added
            sortCount++;

            // If index is empty, insert element
            // Otherwise, insert and shift values over
            if (sorted[idx] == null) {
                sorted[idx] = element;
            } else {
                Simple temp1 = element;
                Simple temp2 = null;
                while (idx < sortCount) {
                    temp2 = sorted[idx];
                    sorted[idx] = temp1;
                    temp1 = temp2;
                }
            }
        }

        // Return the sorted array
        return sorted;
    } // end toArray(comp)

    /**
     * Gives the height of the tree
     * 
     * @return int height of root node
     */
    public int height() {
        return root.height;
    } // end height()

    /**
     * Re-creates Tree to restore balance using recursive private method
     */
    private void balance() {
        // Put everything into sorted array
        Simple[] sorted = toArray(ordering);

        // Destroy the Tree
        root = null;

        // Call recursive balance function
        balance(sorted, 0, sorted.length);
    } // end balance()

    /**
     * Private recursive method for adding the middle element of given array, then
     * repeating for the left and right halves of given array
     * 
     * @param array Sorted array of precious Tree
     * @param start Index to start current selection (Inclusive)
     * @param stop  Index to stop current selection (Exclusive)
     */
    private void balance(Simple[] array, int start, int stop) {
        // Add middle value to Tree
        int mid = (stop + start) / 2;
        add(array[mid], true);

        // If there are values to the left of mid, balance left half
        if ((mid - start) > 0) {
            balance(array, start, mid);
        }

        // if there are values to the right of mid, balance right half
        if ((stop - (mid + 1)) > 0) {
            balance(array, mid + 1, stop);
        }
    } // end balance(array,start,stop)

    /**
     * Replaces the Comparator, then re-balances the tree
     * 
     * @param comp New Comparator to structure Tree by
     */
    public void reorder(Comparator<Simple> comp) {
        // Set new Comparator
        ordering = comp;

        // Rebalance Tree
        balance();
    } // end reorder(comp)

    /**
     * Searches Tree and returns all Simples with matching String
     * 
     * @param value String to search tree for
     * @return ArrayList with all Simples with matching String
     */
    public ArrayList<Simple> query(String value) {
        // Create a new ArrayList
        ArrayList<Simple> queryList = new ArrayList<>();

        // Assemble the Tree into an array
        Simple[] treeArray = toArray();

        // Find every Simple in Tree that has a matching String, and add to queryList
        for (Simple element : treeArray) {
            if (element.alpha.equals(value)) {
                queryList.add(element);
            }
        }
        return queryList;
    } // end query(value)

    /**
     * Searches Tree for matching Simple directly before given Node
     * 
     * @param value Simple to find match of
     * @return Predecessor Simple value, or null if none found
     */
    public Simple predecessor(Simple value) {
        Node pointer = find(value);
        if (pointer == null) {
            return null;
        }
        return predecessor(pointer).value;
    } // end predecessor(value)

    /**
     * Searches Tree for Node directly before given Node
     * 
     * @param n Node to search for predecessor of
     * @return Predecessor of given Node, or null if none found
     */
    private Node predecessor(Node n) {
        // Find the previous value in the tree
        Node pointer;

        // If there is a left subtree, it's the max of the left subtree
        if (n.left != dummy) {
            pointer = n.left;
            while (pointer.right != dummy) {
                pointer = pointer.right;
            }
            return pointer;
        }

        // Otherwise, it's the first parent to whom pointer is the right child
        pointer = n;
        while (pointer.parent.right != pointer) {
            pointer = pointer.parent;
            if (pointer == root) {
                return null;
            }
        }
        return pointer.parent;
    } // end predecessor(n)

    /**
     * Searches Tree for matching Simple directly after given Node
     * 
     * @param value Simple to find match of
     * @return Successor Simple value, or null if none found
     */
    public Simple successor(Simple value) {
        Node pointer = find(value);
        if (pointer == null) {
            return null;
        }
        return successor(pointer).value;
    } // end successor(value)

    /**
     * Searches Tree for Node directly after given Node
     * 
     * @param n Node to search for successor of
     * @return Successor of given Node, or null if none found
     */
    public Node successor(Node n) {
        // Find the next value in the tree
        Node pointer;

        // If there is a right subtree, it's the min of the right subtree
        if (n.right != null) {
            pointer = n.right;
            while (pointer.left != null) {
                pointer = pointer.left;
            }
            return pointer;
        }

        // Otherwise, it's the first parent to have a right child
        pointer = n;
        while (pointer.parent.left != pointer) {
            pointer = pointer.parent;
            if (pointer == root) {
                return null;
            }
        }
        return pointer.parent;
    } // end successor(n)

    class Node {
        // Node's parent
        Node parent;
        // Node's left child node(lesser)
        Node left;
        // Node's right child node(greater)
        Node right;
        // Node's height in tree
        int height;
        // Node's stored value
        Simple value;

        /**
         * Node default constructor
         */
        Node() {
            value = null;
            left = dummy;
            right = dummy;
            parent = null;
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
            parent = null;
        }

        /**
         * Prints out node value, left child's value, and right child's value
         */
        void print() {
            System.out.print(value);
            System.out.print(" (L: " + left.value + ") ");
            System.out.println(" (R: " + right.value + ")");
        }

        private int compareHeight() {
            int hLeft = -1;
            if (this.left != null) {
                hLeft = this.left.height;
            }

            int hRight = -1;
            if (this.right != null) {
                hRight = this.right.height;
            }

            return Math.abs(hLeft - hRight);
        }
    } // end class Node
} // end class List
