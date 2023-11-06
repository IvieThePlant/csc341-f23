/** A set of 3 integers */
public class Trio<T extends Comparable<T>> {
    T first;
    T second;
    T third;

    /** Default constructor */
    public Trio() {
    }

    /**
     * Constructor assigning all 3 elements
     * 
     * @param f first in the tuple
     * @param s second in the tuple
     * @param t third in the tuple
     */
    public Trio(T f, T s, T t) {
        first = f;
        second = s;
        third = t;
    }

    /**
     * Copy constructor creating new tuple based on input parameter
     * 
     * @param toCopy Trio values to copy doubleo new Trio
     */
    public Trio(Trio<T> toCopy) {
        first = toCopy.first;
        second = toCopy.second;
        third = toCopy.third;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + ", " + third + "]";
    }

    /** Place the 3 elements in increasing order from first to third. */
    public void order() {
        T temp = second;
        if (second.compareTo(first) < 0) {
            second = first;
            first = temp;
        }
        temp = third;
        if (third.compareTo(second) < 0 && third.compareTo(first) < 0) {
            third = second;
            second = first;
            first = temp;
        } else if (third.compareTo(second) < 0) {
            third = second;
            second = temp;
        }
    }

    // _______________________ SETTERS and GETTERS
    public T first() {
        return first;
    }

    public T second() {
        return second;
    }

    public T third() {
        return third;
    }

    public void first(T f) {
        first = f;
    }

    public void second(T s) {
        second = s;
    }

    public void third(T t) {
        third = t;
    }
}