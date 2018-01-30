package racingcar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TestCar {
	private final int SAMPLE_SIZE = 1000;
	private final int NUMBER_OF_TRIALS = 10000;
	
	@Test
	public void compareEngineRunCountWithTotalDistance() {
		List<Car> cars = new ArrayList<Car>();
		int totalDistance = 0;
		int DISTANCE_UPPER_LIMIT = SAMPLE_SIZE * NUMBER_OF_TRIALS * RandomEngine.DISTANCE_PER_UNIT_TIME;
		
		for (int i = 0; i < SAMPLE_SIZE; i++) {
			Car newCar = new Car(new CarSpecification(EngineType.RANDOM_ENGINE));
			cars.add(newCar);
			int distanceTravelled = newCar.moveForward(NUMBER_OF_TRIALS);
			assertTrue(0 <= distanceTravelled);
			assertEquals(distanceTravelled, newCar.getPosition());
			totalDistance += distanceTravelled;
		}
		
		int totalDistanceRecorded = 0;
		for (Car car : cars) {
			totalDistanceRecorded += car.getPosition();
		}
		
		assertEquals(totalDistance, totalDistanceRecorded);
		assertTrue(0 <= totalDistance);
		assertTrue(totalDistance <= DISTANCE_UPPER_LIMIT);
	}
}