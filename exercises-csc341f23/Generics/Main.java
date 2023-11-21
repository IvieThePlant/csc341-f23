public class Main {

    public static void main(String[] args) {
		// Test your code by creating an instance of Trio that stores integers
		Trio<Integer> trioI = new Trio<>(3,1,2);
		
		// Test your code by creating an instance of Trio that stores Simple objects.
		Simple s1 = new Simple("A",10);
		Simple s2 = new Simple("B",5);
		Simple s3 = new Simple("C",1);
		Trio<Simple> simples = new Trio<>(s1,s2,s3);

    }
}