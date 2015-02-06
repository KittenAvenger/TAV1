import static org.junit.Assert.*;

import org.junit.Test;


public class TestReplace {

	Server tester = new Server();
	@Test
	public void testNotExistingID() {
		assertEquals("non existing id should return -1", -1, tester.replace(6523223, "howdy"));
	}

}
