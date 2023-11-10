public class Main {
    public static void main(String[] args) {
        // Test Stack with Integers
        System.out.print("Making Integers...");
        Integer first = 22;
        Integer second = 34;
        Integer third = 99;
        System.out.println("Done.");

        System.out.println();

        System.out.print("Making new Stack...");
        Stack<Integer> intStack = new Stack<Integer>();
        System.out.println("Done.");

        System.out.println();

        // Test push
        System.out.println("---Testing Push---");

        System.out.print("Adding First...");
        intStack.push(first);
        System.out.println("Done.");

        System.out.print("Adding Second...");
        intStack.push(second);
        System.out.println("Done.");

        System.out.print("Adding Third...");
        intStack.push(third);
        System.out.println("Done.");

        System.out.println();

        // Test peek
        System.out.println("---Testing Peek---");

        System.out.print("Peeking. Expected 99, got ");
        System.out.println(intStack.peek() + ". Done.");

        System.out.println();

        // Test pop
        System.out.println("---Testing Pop---");

        System.out.println("Popping. Expected 99");

        // Test empty

        // Test Stack with Simples
    }
}
