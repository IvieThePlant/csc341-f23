public class Queue<T> implements QueueInterface<T> {

    T[] queue;

    /* Index of the first element in the Queue */
    private int head;

    /* Index of the location to place the next added value */
    private int tail;

    /*
     * Default Constuctor
     * If no capacity given, defaults to 10
     */
    public Queue() {
        this(10);
    }

    public Queue(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        queue = temp;
    }

    // TODO: Write toString()
    @Override
    public String toString() {
        String asw = null;
        return asw;
    }

    // TODO: Write next(), return the next index to be added at.
    public int next() {
        return -1;
    }

    // TODO: Write peek(), returns the first element in the Queue
    public T peek() {
        return null;
    }

    // TODO: Write JavaDocs for isFull()
    public boolean isFull() {
        return (head == tail) && (queue[head] != null);
    }

    // TODO: Write isEmpty(), return true if Queue empty
    public boolean isEmpty() {
        return false;
    }

    // TODO: Write push(), adds a element to the Queue
    public void push(T value) {

    }

    // TODO: Write pop(), removes and returns first element in Queue
    public T pop() {
        return null;
    }

    // -----GETTERS-----
    public int head() {
        return head;
    }

    public int tail() {
        return tail;
    }
}
