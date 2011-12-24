package lab1.util;

public class RandomGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print((int) (Math.random() * 100));
			if (i % 5 == 4) {
				System.out.println(",");
			} else {
				System.out.print(", ");
			}
		}
	}

}
