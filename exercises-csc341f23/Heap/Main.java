public class Main {
    public static void main(String[] args) {

        Integer[] nums = new Integer[5];
        nums[0] = 1;
        nums[1] = 9;
        for (Integer x : nums) {
            System.out.println(x);
        }
        MaxHeap<Integer> heap = new MaxHeap<>();

        Integer[] array = { 10, 15, 2, 12, 8, 70 };
        for (Integer n : array) {
            heap.add(n);
        }
        System.out.println(heap.toString());
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(heap.remove() + " ");
            System.out.println(heap.toString());
        }
    }
}
