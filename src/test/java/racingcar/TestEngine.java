package racingcar;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestEngine {
	private final int COUNT_TRIAL = 10000;
	private final float REASONABLE_PROBABILITY_OF_SUCCESS = (float) 0.5;
	
	@Test
	public void testRandomEngine() throws Exception {
		testReasonableRandomness();
	}
	
	public int runRandomEngine(RandomEngine randomEngine) {
		int countEngineRun = 0;
		
		for (int i = 0; i < COUNT_TRIAL; i ++) {
			if (randomEngine.isToMove()) {
				countEngineRun ++;
			}
		}
		
		return countEngineRun;
	}
	
	public void testReasonableRandomness() {
		RandomEngine randomEngine = new RandomEngine();
		int countEngineRun = runRandomEngine(randomEngine);
		float probabilityToGo = (float)countEngineRun / COUNT_TRIAL;
		
		assertTrue(probabilityToGo > REASONABLE_PROBABILITY_OF_SUCCESS);
	}
	
	@Test
	public void testAllEngines() {
		for (EngineType engineType : EngineType.values()) {
			testTransmission(engineType);
		}
	}
	
	public void testTransmission(EngineType engineType) {
		// Use the Factory Pattern?
		CarSpecification carSpecification = new CarSpecification(engineType);
		Car car = new Car(carSpecification); 
		
		int countEngineRun = 0;
		
		for (int i = 0; i < COUNT_TRIAL; i ++) {
			// if runEngine() succeeds, it returns true
			if (car.runEngine()) {
				countEngineRun++;
			}
		}
		
		assertEquals(countEngineRun, car.getPosition());
	}
	
	/*
	 * TODO: 
	 * - Separate test classes (testing the game globally)
	 * - Compare the number of trials == the sum of total distances the cars moved
	 * - More to come
	 */
}