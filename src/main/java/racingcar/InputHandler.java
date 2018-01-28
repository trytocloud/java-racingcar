package racingcar;

import java.util.NoSuchElementException;
import java.util.Scanner;

import racingcar.RacingGame.Configuration;

public class InputHandler {
	private Scanner scanner;
	
	private void startInput() {
		scanner = new Scanner(System.in);
	}
	
	private void endInput() {
		scanner.close();
	}
	
	public String requestInput(String question) {
		System.out.println(question);
		try {
			String inputString = scanner.nextLine();
			return inputString;
		} catch(NoSuchElementException invalidInput) {
			return "0";
		}
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