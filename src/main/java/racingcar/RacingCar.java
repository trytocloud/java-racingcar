package racingcar;


public class RacingCar {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		RacingGame myRacingGame = new RacingGame();
		
		// It is indeed weird to have only OutputHandler here as a static class
		OutputHandler.printCars(myRacingGame);
	}
}