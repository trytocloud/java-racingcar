package racingcar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	
	public void testAdd() {
		String str = "working fine";
		assertEquals("working fine", str);
	}
}