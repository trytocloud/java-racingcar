package racingcar;

import java.util.ArrayList;

public class RacingGame {
	private ArrayList<Car> carList = new ArrayList<Car>();
	private int numberCars, numberTrials;
	
	public RacingGame(int numberCars, int numberTrials) {
		this.numberCars = numberCars;
		this.numberTrials = numberTrials;
		
		for(int i = 0; i < numberCars; i ++) {
			carList.add(new Car());
		}
		
		runGame();
	}
	
	public void runGame() {
		for(Car car : carList) {
			car.moveForward(numberTrials);
		}
	}
	
	public int[] getCarPositions() {
		int[] carPositions = new int[numberCars];
		
		for(int i = 0; i < numberCars; i ++) {
			carPositions[i] = carList.get(i).position;
		}
		
		return carPositions;
	}
}
