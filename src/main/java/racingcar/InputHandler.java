package racingcar;

import java.util.Scanner;

import racingcar.RacingGame.Configuration;

public class InputHandler {
	Scanner scanner;
	
	private void startInput() {
		scanner = new Scanner(System.in);
	}
	
	private void endInput() {
		scanner.close();
	}
	
	private String requestInput(String question) {
		String inputString;
		System.out.println(question);
		inputString = scanner.nextLine();
		return inputString;
	}
	
	public Configuration requestGameConditions(RacingGame targetGame) { 
		int numberCars;
		int numberTrials;
		
		startInput();
		
		numberCars = Integer.parseInt(requestInput("How many cars are there?"));
		numberTrials = Integer.parseInt(requestInput("How many trials?"));
		
		endInput();
		
		return targetGame.new Configuration(numberCars, numberTrials);
	}

}