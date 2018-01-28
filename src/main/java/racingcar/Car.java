package racingcar;


public class Car {
	private int position;
	public CarSpecification specification;
	private Engine engine;
	
	public Car(CarSpecification specification) {
		this.specification = specification;
		
		initializeEngine();
	}
	
	private void initializeEngine() {
		switch (specification.engineType) {
			case NORMAL_ENGINE:
				engine = new NormalEngine();
				break;
			case RANDOM_ENGINE:
				engine = new RandomEngine();
				break;
			default:
				engine = new RandomEngine();
				break;
		}
	}
	
	public boolean runEngine() {
		return engine.run(this);
	}

	public void moveForward(int trialCount) {
		for (int i = 0; i < trialCount; i ++) {
			engine.run(this);
		}
	}
	
	public void moveBy(int distance) {
		this.setPosition(this.getPosition() + distance);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}