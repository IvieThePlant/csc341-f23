public class Linked {

    /** Reference to the first element of the list */

    /** Reference to the last element of the list */

    /** Default constructor */
    public Linked() {

    }

    /** Empty? */
    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {

        String list = "";

        return list;
    }

    /** add to the end of the list */
    public void prepend(String item) {

    }

    /** add at that index */
    public void append(String item) {

    }

    private class Node {

        /** Value contained within this */
        String value;

        /** Node next in the chain of nodes */
        Node next;

        /** Default constructor */
        Node(String v) {
            value = v;
            next = null;
        }
    }
}