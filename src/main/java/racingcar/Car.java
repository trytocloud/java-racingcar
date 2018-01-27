package racingcar;


public class Car {
	public int position;
	public CarSpecification specification;
	private Engine engine;
	
	public Car(CarSpecification specification) {
		this.specification = specification;
		try {
			engine = specification.engineType.newInstance();
		} catch (InstantiationException invalidEngineClass) {
			engine = new RandomEngine();
		} catch (IllegalAccessException invalidEngineClass) {
			engine = new RandomEngine();
		}
	}

	public void moveForward(int trialCount) {
		for (int i = 0; i < trialCount; i ++) {
			engine.run(this);
		}
	}
	
	public boolean runEngine() {
		return engine.run(this);
	}
}