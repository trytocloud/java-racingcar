package racingcar;

public class RandomEngine extends Engine {
	private final int RANDOM_RANGE = 9;
	private final int RANDOM_THRESHOLD = 4;
	private final int DISTANCE_PER_UNIT_TIME = 1;
	
	public boolean run(Car theCar) {
		if (isToMove()) {
			theCar.moveBy(DISTANCE_PER_UNIT_TIME);
			return true;
		}
		return false;
	}
	
	public boolean isToMove() {
		boolean isToGo = false;
		
		int randomNumber = (int)(Math.random() * RANDOM_RANGE);
		isToGo = (randomNumber >= RANDOM_THRESHOLD);
		
		return isToGo;
	}
}

