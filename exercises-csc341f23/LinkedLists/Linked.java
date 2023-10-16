public class Linked {

    /** Reference to the first element of the list */
    Node head;
    /** Reference to the last element of the list */
    Node tail;

    /** Default constructor */
    public Linked() {
        head = null;
        tail = null;
    }

    /** Empty? */
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(Node n) {
        if (n == tail) {
            return n.toString();
        } else {
            return n.toString() + toString(n.next);
        }
    }

    /** add to the front of the list */
    public void prepend(String item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /** add to then end of the list */
    public void append(String item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
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

        public String toString() {
            return value;
        }
    }
}
