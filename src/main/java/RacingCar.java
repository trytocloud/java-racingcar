import java.util.Scanner;

public class RacingCar {
	public static void main(String[] args) {
		int numberCars, numberTrials;
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		System.out.println("How many cars are there?");
		inputString = scanner.nextLine();
		numberCars = Integer.parseInt(inputString);
		
		System.out.println("How many trials?");
		inputString = scanner.nextLine();
		numberTrials = Integer.parseInt(inputString);
		
		scanner.close();
		
		System.out.println(numberCars + " " + numberTrials);
		
		RacingGame myRacingGame = new RacingGame(numberCars, numberTrials);
		int[] carPositions = myRacingGame.getCarPositions();
		
		ResultView.printCars(carPositions);
	}
}