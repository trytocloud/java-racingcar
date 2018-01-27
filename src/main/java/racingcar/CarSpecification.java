package racingcar;

class CarSpecification {
	Class<? extends Engine> engineType; // this may be both unsafe and user-unfriendly
	
	CarSpecification() {
		engineType = RandomEngine.class;
	}
}