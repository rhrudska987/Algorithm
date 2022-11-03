package algorithm;

public class Euclid {
	
	static int Euclid_calc(int a, int b) {
		if (b == 0) return a;
		return Euclid_calc(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(Euclid_calc(31, 7));
	}

}
