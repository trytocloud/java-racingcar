package racingcar;


public class Car {
	
	public int position;
	public CarSpecification specification;
	public Engine engine;
	
	public Car(CarSpecification specification) throws InstantiationException, IllegalAccessException {
		this.specification = specification;
		engine = specification.engineType.newInstance();
	}

	public void moveForward(int trialCount) {
		for(int i = 0; i < trialCount; i ++) {
			engine.run(this);
		}
	}
}