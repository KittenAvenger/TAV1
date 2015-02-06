import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author giantsusu
 *
 */
public class TestDelete {

	Server tester = new Server();
	
	@Test
	public void nonExistingID() {
		assertEquals("non existing id should return -1", -1, tester.delete(674342));
	}
	
	@Test
	public void messageFetched() {
		tester.add("Hey what is up", "0777777777", "0766666666");
		int IDs = tester.returnServer().getID();
		tester.returnServer().setFetched();
		assertEquals("if message fetched return error", -1, tester.delete(IDs));
	}
	
	@Test
	public void normalFunction() {
		tester.add("Hey what is up", "0777777777", "0766666666");
		int IDs = tester.returnServer().getID();
		assertEquals("if message not fetched and ID is correct return ID", IDs, tester.delete(IDs));
		
	}
	
}

