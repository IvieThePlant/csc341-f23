class Queue<T> {
    T[] queue;
    int head;
    int tail;

    public Queue(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        queue = temp;
    }

    private boolean isFull() {
        return (head == tail) && (queue[head] != null);
    }

    private boolean isEmpty() {
        return (head == tail) && (queue[head] == null);
    }

    public boolean push(T thing) {
        if (isFull()) {
            return false;
        } else {
            queue[tail] = thing;
            tail = (tail + 1) % queue.length;
            return true;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = queue[head];
            queue[head] = null;
            head = (head + 1) % queue.length;
            return temp;
        }
    }
}