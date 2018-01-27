package racingcar;

class CarSpecification {
	Class<? extends Engine> engineType;
	
	CarSpecification() {
		engineType = RandomEngine.class;
	}
}