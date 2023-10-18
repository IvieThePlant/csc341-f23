public class Linked {

    /** Reference to the first element of the list */
    Node head;
    /** Reference to the last element of the list */
    Node tail;

    /** Count of elements in the list */
    int count;

    /** Default constructor */
    public Linked() {
        Node n = new Node(null);
        head = n;
        tail = n;
        count = 0;
    }

    /** Empty? */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        return toString(head.next);
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
        newNode.next = head.next;
        head.next = newNode;
        if (tail == head) {
            tail = newNode;
        }
        count++;
    }

    /** add to then end of the list */
    public void append(String item) {
        Node newNode = new Node(item);
        // empty condition
        if (count == 0) {
            prepend(item);
        }

        // default condition
        if (count >= 1) {
            tail.next = newNode;
            tail = newNode;
            count++;
        }
    }

    /** remove the first element and return */
    public Node pop() {
        Node returnNode;
        // empty condition
        if (count == 0) {
            return null;
        }

        // one value condition
        if (count == 1) {
            returnNode = head.next;
            head.next = null;
            tail = head;
            count--;
            return returnNode;
        }

        // default condition
        returnNode = head.next;
        head.next = head.next.next;
        count--;
        return returnNode;
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
