public class MaxHeap<T extends Comparable<T>> {

    /* Array that Heap values are stored in */
    public T[] heap;

    /* Number of values in Heap */
    private int count;

    /**
     * Default Constuctor
     * Sets default capacity to 20
     */
    public MaxHeap() {
        this(20);
    } // end MaxHeap()

    /**
     * Constuctor for given capacity
     * 
     * @param capacity Size of Heap
     */
    public MaxHeap(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[capacity];
        heap = temp;
    } // end MaxHeap()

    @Override
    public String toString() {
        String awn = "[";
        for (T el : heap) {
            if (el != null) {
                awn += el.toString() + ",";
            }
        }
        return awn + "]";
    }

    /**
     * Adds new value to Heap
     * 
     * @param value T to be added
     */
    public void push(T value) {
        if (!isFull()) {
            heap[count] = value;
            count++;
            floatUp(count - 1);
        }
    } // end push(value)

    /**
     * Removes and returns the maximum value of the Heap
     * Then, moves the new maximum to the top
     * 
     * @return Maximum value of Heap
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T temp = heap[0];
        heap[0] = heap[count - 1];
        count--;
        heap[count] = null;
        sink(0);
        return temp;
    } // end pop()

    /**
     * Gives the maximum value of Heap without removing
     * 
     * @return Maximum value of Heap
     */
    public T peek() {
        return heap[0];
    } // end peek()

    /**
     * Checks to see if Heap is empty
     * 
     * @return True if Heap empty
     */
    public boolean isEmpty() {
        return count == 0;
    } // end isEmpty()

    /**
     * Checks to see if Heap is full
     * 
     * @return True if Heap full
     */
    public boolean isFull() {
        return count == heap.length;
    } // end isFull()

    /**
     * Sinks the value at index i "down" into the "tree"
     * 
     * @param i Index to sink
     */
    private void sink(int i) {
        // Finds the indices of the left and right "children"
        int left = leftChildIndex(i);
        int right = rightChildIndex(i);

        boolean sinking = true;
        while (sinking) {
            if (left == -1 && right == -1) {
                // If i has no children, stop sinking
                sinking = false;

            } else if (left != -1 && right == -1) {
                // If i has only a left child, compare to i
                // Sink if it is larger, else stop sinking
                if (heap[left].compareTo(heap[i]) > 0) {
                    sinkLeft(i);
                    i = left;
                } else {
                    sinking = false;
                }

            } else if (left != -1 && right != -1) {
                // If i has two children, compare them.
                // Sink if child is larger, else stop sinking
                if (heap[left].compareTo(heap[right]) > 0) {
                    if (heap[left].compareTo(heap[i]) > 0) {
                        sinkLeft(i);
                        i = left;
                    } else {
                        sinking = false;
                    }

                } else {
                    if (heap[right].compareTo(heap[i]) > 0) {
                        sinkRight(i);
                        i = right;
                    }
                }
            }

            // Find the left and right "children" of the new i
            left = leftChildIndex(i);
            right = rightChildIndex(i);
        }
    } // end sink(i)

    private void sinkLeft(int index) {
        T temp = heap[index];
        int left = leftChildIndex(index);
        heap[index] = heap[left];
        heap[left] = temp;
    }

    private void sinkRight(int index) {
        T temp = heap[index];
        int right = rightChildIndex(index);
        heap[index] = heap[right];
        heap[right] = temp;
    }

    /**
     * Float the value at index i "up" into the "tree"
     * 
     * @param i Index to float
     */
    private void floatUp(int i) {
        // While not at root and i is larger than i's parent
        while (i != 0 && (heap[i].compareTo(heap[parentIndex(i)])) > 0) {
            // Swap the values of i and i's parent
            T temp = heap[i];
            heap[i] = heap[parentIndex(i)];
            i = parentIndex(i);
            heap[i] = temp;
        }
    } // end floatUp(i)

    /**
     * Finds the index of given index's "left child"
     * 
     * @param index Index to find "left child" of
     * @return Index of "left child"
     */
    private int leftChildIndex(int index) {
        int x = (2 * index + 1);
        if (x >= count) {
            x = -1;
        }
        return x;
    } // end leftChildIndex(index)

    /**
     * Finds the index of given index's "right child"
     * 
     * @param index Index to find "right child" of
     * @return Index of "right child"
     */
    private int rightChildIndex(int index) {
        int x = (2 * index + 2);
        if (x >= count) {
            x = -1;
        }
        return x;
    } // end rightChildIndex(index)

    /**
     * Finds the index of given index's "parent node"
     * 
     * @param index Index to find "parent" of
     * @return Index of "parent node"
     */
    private int parentIndex(int index) {
        return ((index - 1) / 2);
    } // end parentIndex(index)
}