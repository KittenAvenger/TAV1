import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author giantsusu
 *
 */
public class TestDelete {

	Server tester;
	
	@Before
	public void setUp() {
	tester = new Server();
	
}
	@Test
	public void nonExistingID() {
		assertEquals("non existing id should return -1", -1, tester.delete(674342));
	}
	
	@Test
	public void messageFetched() {
		int IDs = tester.add("Hey what is up", "0777777777", "0766666666");
		tester.fetch("0766666666");
		assertEquals("if message fetched return error", -1, tester.delete(IDs));
	}
	
	@Test
	public void normalFunction() {
		int IDs = tester.add("Hey what is up", "0777777777", "0766666666");
		System.out.println(tester.returnServer().getMessage());
		
		assertEquals("test", "Hey what is up", tester.returnServer().getMessage());
		assertEquals("if message not fetched and ID is correct return ID", IDs, tester.delete(IDs));
		
		}
	
	
	
}

