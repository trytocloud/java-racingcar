package racingcar;

public class NormalEngine extends Engine {
	public int run(Car theCar) {
		theCar.moveBy(1);
		return 1;
	}
	
	public boolean isToMove() {
		return true;
	}
}

