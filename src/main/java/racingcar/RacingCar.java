package racingcar;


public class RacingCar {
	public static void main(String[] args) {
		int numberCars, numberTrials;
		int[] inputGameConfiguration;
		
		inputGameConfiguration = InputHandler.requestGameConditions();
		numberCars = inputGameConfiguration[0];
		numberTrials = inputGameConfiguration[1];
		
		RacingGame myRacingGame = new RacingGame(numberCars, numberTrials);
		int[] carPositions = myRacingGame.getCarPositions();
		
		OutputHandler.printCars(carPositions);
	}
}