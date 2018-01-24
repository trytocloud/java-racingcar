package racingcar;

import java.util.Scanner;

public class InputHandler {
	public static int[] requestGameConditions() { 
		Scanner scanner = new Scanner(System.in);
		String inputString;
		int numberCars, numberTrials;
		
		System.out.println("How many cars are there?");
		inputString = scanner.nextLine();
		numberCars = Integer.parseInt(inputString);
		
		System.out.println("How many trials?");
		inputString = scanner.nextLine();
		numberTrials = Integer.parseInt(inputString);
		
		scanner.close();
		
		return new int[]{numberCars, numberTrials};
	}
}