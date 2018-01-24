package racingcar;

public class OutputHandler {
	private static void printPosition(int position) {
		for(int i = 0; i < position; i ++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	public static void printCars(int[] carPositions) {
		for(int carPosition : carPositions) {
			printPosition(carPosition);
		}
	}
}
