package racingcar;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestEngine {
	private final int COUNT_TRIAL = 10000;
	private final int SAMPLE_SIZE = 10000;
	private final float REASONABLE_PROBABILITY_OF_SUCCESS = (float) 0.5;
	
	/*
	 * General engine tests
	 */
	
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
			if (car.runEngine() > 0) {
				countEngineRun++;
			}
		}
		
		assertEquals(countEngineRun * RandomEngine.DISTANCE_PER_UNIT_TIME, car.getPosition());
	}
	
	/*
	 * RandomEngine-specific tests
	 */
	
	@Test
	public void testRandomEngine() throws Exception {
		testReasonableRandomness();
		compareNormalEngineWithRandomEngine();
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
	
	public void compareNormalEngineWithRandomEngine() {
		
		for (int i = 0; i < COUNT_TRIAL; i ++) {
			Car normalEngineCar = new Car(new CarSpecification(EngineType.NORMAL_ENGINE));
			Car randomEngineCar = new Car(new CarSpecification(EngineType.RANDOM_ENGINE));
			
			normalEngineCar.moveBy(SAMPLE_SIZE);
			randomEngineCar.moveBy(SAMPLE_SIZE);
			
			assertTrue(normalEngineCar.getPosition() >= randomEngineCar.getPosition());
		}
	}
}