public class Test {
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5, 6 };
        Queue<Integer> aQueue = new Queue<>(5);

        System.out.println("Pushing 1,2,3,4,5,6");
        for (Integer n : intArray) {
            aQueue.push(n);
        }
        System.out.println();

        System.out.println("Popping 6 times");
        for (Integer n : intArray) {
            System.out.print(aQueue.pop() + ", ");
        }
        System.out.println();
        System.out.println();

    }
}
