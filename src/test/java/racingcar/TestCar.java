package racingcar;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCar {
	int COUNT_TRIAL = 10000;
	float REASONABLE_PROBABILITY_OF_SUCCESS = (float) 0.1;
	
	@Test
	public void testRandomEngine() throws Exception {
		RandomEngine randomEngine = new RandomEngine();
	
		testReasonableRandomness(randomEngine);
	}
	
	public int testEngineRun(RandomEngine randomEngine) {
		int countEngineRun = 0;
		
		for(int i = 0; i < COUNT_TRIAL; i ++) {
			if(randomEngine.isToMove()) {
				countEngineRun ++;
			}
		}
		
		return countEngineRun;
	}
	
	public void testReasonableRandomness(RandomEngine randomEngine) {
		int countEngineRun;
		countEngineRun = testEngineRun(randomEngine);
		float probabilityToGo = (float)countEngineRun / COUNT_TRIAL;
		
		assertTrue(probabilityToGo > REASONABLE_PROBABILITY_OF_SUCCESS);
	}
	
	@Test
	public void testTransmission() throws InstantiationException, IllegalAccessException {
		CarSpecification carSpecification = new CarSpecification();
		
		carSpecification.engineType = RandomEngine.class;
		Car car = new Car(carSpecification); 
		int countEngineRun = 0;
		boolean isEngineRunning;
		
		for(int i = 0; i < COUNT_TRIAL; i ++) {
			isEngineRunning = car.engine.run(car);
			if(isEngineRunning) {
				countEngineRun++;
			}
		}
		
		assertEquals(countEngineRun, car.position);
	}
	
	/*
	 * TODO: 
	 * - Separate test classes (testing the game globally)
	 * - Compare the number of trials == the sum of total distances the cars moved
	 * - More to come
	 */
}