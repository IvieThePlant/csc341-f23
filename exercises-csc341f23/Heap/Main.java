public class Main {
    public static void main(String[] args) {

        MaxHeap<Integer> heap = new MaxHeap<>();

        Integer[] array = { 10, 15, 2, 12, 8, 70 };
        for (Integer n : array) {
            heap.add(n);
        }
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(heap.remove() + " ");
        }
    }
}
