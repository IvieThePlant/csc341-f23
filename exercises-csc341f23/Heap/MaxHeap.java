public class MaxHeap<T extends Comparable<T>> {

    public T[] heap;

    private int count;

    public MaxHeap() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[20];
        heap = temp;
    }

    public MaxHeap(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[capacity];
        heap = temp;
    }

    public boolean add(T obj) {
        if (isFull()) {
            return false;
        }
        heap[count] = obj;
        count++;
        floatUp(count - 1);
        return true;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T temp = heap[0];
        heap[0] = heap[count - 1];
        count--;
        heap[count] = null;
        sinkDown(0);
        return temp;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == heap.length;
    }

    private int leftChildIndex(int index) {
        int x = (2 * index + 1);
        if (x >= count) {
            x = -1;
        }
        return x;
    }

    private int rightChildIndex(int index) {
        int x = (2 * index + 2);
        if (x >= count) {
            x = -1;
        }
        return x;
    }

    private int parentIndex(int index) {
        return ((index - 1) / 2);
    }

    private void floatUp(int index) {
        while (index != 0 && (heap[index].compareTo(heap[parentIndex(index)])) > 0) {
            T temp = heap[index];
            heap[index] = heap[parentIndex(index)];
            index = parentIndex(index);
            heap[index] = temp;
        }
    }

    // TODO: sinkDown()
    private void sinkDown(int index) {
        boolean sinking = true;

        int left = leftChildIndex(index);
        int right = rightChildIndex(index);

        while (sinking) {
            if (left == -1 && right == -1) {
                sinking = false;

            } else if (left != -1 && right == -1) {
                sinkLeft(index);
                index = left;

            } else if (left != -1 && right != -1) {
                if (heap[left].compareTo(heap[right]) > 0) {
                    sinkLeft(index);
                    index = left;
                } else {
                    sinkRight(index);
                    index = right;
                }
            }

            left = leftChildIndex(index);
            right = rightChildIndex(index);
        }
    }

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
}