package racingcar;

public class NormalEngine extends Engine {
	public boolean run(Car theCar) {
		theCar.moveBy(1);
		return true;
	}
	
	public boolean isToMove() {
		return true;
	}
}

