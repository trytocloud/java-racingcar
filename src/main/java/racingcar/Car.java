package racingcar;


public class Car {
	public int position;
	Engine engine;
	
	public Car() {
		engine = new RandomEngine();
	}
	
	public void moveForward(int trialCount) {
		for(int i = 0; i < trialCount; i ++) {
			engine.run(this);
		}
	}
}