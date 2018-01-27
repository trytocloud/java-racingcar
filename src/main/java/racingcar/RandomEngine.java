package racingcar;

public class RandomEngine extends Engine {
	public boolean run(Car theCar) {
		if(isToMove()) {
			theCar.position += 1;
			return true;
		}
		return false;
	}
	
	public boolean isToMove() {
		boolean isToGo = false;
		
		int randomNumber = (int)(Math.random() * 9);
		isToGo = (randomNumber >= 4);
		
		return isToGo;
	}
	
}

