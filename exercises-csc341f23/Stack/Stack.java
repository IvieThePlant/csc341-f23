public class Stack<T> {
    // Points to the top of the Stack
    private Node head;

    // Default constructor
    public Stack() {
    }

    // Constructor for one initial value
    public Stack(T initValue) {
        head = new Node(initValue);
    }

    // Constructor for an array of initial values
    public Stack(T[] initValues) {
        for (T initValue : initValues) {
            push(initValue);
        }
    }

    // Return true if Stack empty, else false
    public boolean empty() {
        return (peek() == null);
    }

    // Add value to top of Stack
    public void push(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Remove and return top value of stack
    public T pop() {
        Node temp = head;
        head = head.next;
        return temp.value;
    }

    // Read top value of Stack without removing
    public T peek() {
        return head.value;
    }

    private class Node {
        // Stores Node's Data
        private T value;

        // Points to next Node in Stack
        private Node next;

        // Constructor for Nodes
        public Node(T initValue) {
            value = initValue;
        }
    }
}