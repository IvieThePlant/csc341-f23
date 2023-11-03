import java.util.*;
import java.util.Random;

public class Simple implements Comparable<Simple> {

	String alpha = null;
	Integer number = null;

	public Simple(String s, Integer n) {
		alpha = s;
		number = n;
	}

	@Override
	public String toString() {
		return alpha + number;
	}

	@Override
	public int compareTo(Simple other) {
		if (alpha.compareTo(other.alpha) == 0) {
			return number.compareTo(other.number);
		} else {
			return alpha.compareTo(other.alpha);
		}
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (!(other instanceof Simple)) {
			return false;
		}
		Simple s = (Simple) other;
		return alpha.equals(s.alpha) && number == s.number;
	}

	// setters and getters
	public Integer number() {
		return number;
	}

	public void number(Integer n) {
		number = n;
	}

	public String alpha() {
		return alpha;
	}

	public void alpha(String a) {
		alpha = a;
	}
}
