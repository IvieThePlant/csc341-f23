/** Defines the methods for any type of Queue - FIFO, LIFO, priority */
public interface QueueInterface<T> {

    // TODO: Write push(), Add a new value to the queue
    public void push(T value);

    // TODO: Write pop(), Remove the next value form the queue
    public T pop();

    // TODO: Write peek(), Look at the next value on the queue
    public T peek();

    public boolean isEmpty();
}