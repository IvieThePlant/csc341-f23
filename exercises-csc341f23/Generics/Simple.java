public class Simple implements Comparable<Simple> {
    String alpha;
    int number;

    public Simple(String a, int n) {
        alpha = a;
        number = n;
    }

    public int compareTo(Simple s) {
        int comparison = alpha.compareTo(s.alpha);
        if (comparison != 0) {
            return comparison;
        }
        comparison = number - s.number;
        return comparison;
    }
}