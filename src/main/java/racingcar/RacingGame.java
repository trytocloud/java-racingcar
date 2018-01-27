package racingcar;

import java.util.List;
import java.util.ArrayList;


public class RacingGame {
	class Configuration {
		private int numberCars, numberTrials;
		
		public Configuration(int numberCars, int numberTrials) {
			this.numberCars = numberCars;
			this.numberTrials = numberTrials;
		}
	}
	private List<Car> carList = new ArrayList<Car>();
	private Configuration configuration;
	
	public RacingGame() {
		configureGame();
		addCars(configuration.numberCars);
		runGame();
	}
	
	private void configureGame() {
		configuration = new InputHandler().requestGameConditions(this);
	}
	public void runGame() {
		moveCars();
	}
	
	public void addCars(int numberCars) {
		for(int i = 0; i < numberCars; i ++) {
			carList.add(new Car());
		}
	}
	
	public void moveCars() {
		for(Car car : carList) {
			car.moveForward(configuration.numberTrials);
		}
	}
	
	public int[] getCarPositions() {
		int[] carPositions = new int[configuration.numberCars];
		
		for(int i = 0; i < configuration.numberCars; i ++) {
			carPositions[i] = carList.get(i).position;
		}
		
		return carPositions;
	}
}
