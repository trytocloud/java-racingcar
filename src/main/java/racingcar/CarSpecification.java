package racingcar;

class CarSpecification {
	public EngineType engineType;
	
	CarSpecification() {
		this.engineType = EngineType.RANDOM_ENGINE;
	}
	
	CarSpecification(EngineType engineType) {
		this.engineType = engineType;
	}
	
}