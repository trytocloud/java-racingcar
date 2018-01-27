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
	private List<Car> carList;
	private Configuration configuration;
	private CarSpecification defaultCarSpecification;
	
	public RacingGame() throws InstantiationException, IllegalAccessException {
		carList = new ArrayList<Car>();
		defaultCarSpecification = new CarSpecification();
		
		configureGame();
		addCarsInBatch(this.configuration.numberCars);
		runGame();
	}
	
	private void configureGame() {
		this.configuration = new InputHandler().requestGameConditions(this);
	}
	
	public void runGame() {
		moveCars();
	}
	
	public void addCar(CarSpecification carSpecification) {
		Car newCar = new Car(carSpecification);

		carList.add(newCar);
	}
	
	public void addCarsInBatch(int numberCars) {
		for (int i = 0; i < numberCars; i ++) {
			addCar(this.defaultCarSpecification); 
		}
	}
	
	public void moveCars() {
		for (Car car : carList) {
			car.moveForward(configuration.numberTrials);
		}
	}
	
	public int[] getCarPositions() {
		int[] carPositions = new int[configuration.numberCars];
		
		for (int i = 0; i < configuration.numberCars; i ++) {
			carPositions[i] = carList.get(i).position;
		}
		
		return carPositions;
	}
}
