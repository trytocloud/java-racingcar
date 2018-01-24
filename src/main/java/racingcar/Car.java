package racingcar;

//import java.util.Random;

public class Car {
	public int position;
	
	public void moveForward(int trialCount) {
		for(int i = 0; i < trialCount; i ++) {
			if(Car.isToMove()) {
				position = position + 1;
			}
		}
	}
	
	private static boolean isToMove() {
		boolean isToGo = false;
		
		int randomNumber = (int)(Math.random() * 9);
		isToGo = (randomNumber >= 4);
		
		return isToGo;
	}
}