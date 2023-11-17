import java.util.ArrayList;
import java.util.Comparator;

/** BST Tester - visual inspection */
public class Main {

	public static Comparator<Simple> byNumber = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			if (s1.number().compareTo(s2.number()) == 0) {
				return s1.alpha().compareTo(s2.alpha());
			} else {
				return s1.number().compareTo(s2.number());
			}
		}
	};

	public static void main(String[] args) {
		// Create a BST of Simple using default "alpha" ordering
		ArrayList<Simple> simples = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			Simple s = new Simple(String.valueOf((char) (i + 'a')), 20 - i);
			simples.add(s);
		}

		for (Simple s : simples) {
			System.out.print(s + " ");
		}

		System.out.println();

		System.out.println(byNumber.compare(simples.get(0), simples.get(1)));

		List simpleList = new List();

		for (Simple s : simples) {
			simpleList.add(s, false);
		}

		System.out.println(simpleList.find(14));
	}
}
