package racing;

import org.junit.Test;
import racing.model.Car;
import racing.model.GameConfiguration;

import static org.junit.Assert.*;

public class MoverTest {
    private Mover mover;

    @Test
    public void getMoveList() throws Exception {
        mover = new Mover(new SimpleDeciderToGo());

        for (int i=10; i<1000; i++) {
            assertTrue(checkMove("a,b", 2, i));
            assertTrue(checkMove("a,b,c,d", 4, i));
            assertTrue(checkMove("a,b,c,d,e,f,g", 7, i));
        }
    }

    private boolean checkMove(String carNameString, int carCount, int i) {
        String[] carNames = carNameString.split(",");

        GameConfiguration gameConfiguration = new GameConfiguration(carNames, i);
        mover.generatePositions(gameConfiguration);

        assertTrue(gameConfiguration.getCars().size() == carCount);

        for (Car car : gameConfiguration.getCars()) {
            checkMaxMove(i, car.getPosition());
        }

        return true;
    }

    private void checkMaxMove(int i, Integer move) {
        assertFalse(move > i);
    }
}