public class Main {

    public static void main(String[] args) {
        // Test your code by creating an instance of Trio that stores integers
        Trio<Integer> trio1 = new Trio<>(3, 1, 2);
        System.out.println(trio1);

        // Test your code by creating an instance of Trio that stores Simple obkects.
        Simple s1 = new Simple("A", 10);
        Simple s2 = new Simple("B", 5);
        Simple s3 = new Simple("C", 1);
        Trio<Simple> simples = new Trio<>(s3, s2, s1);
        System.out.println(simples);
        simples.order();
        System.out.println(simples);

    }
}