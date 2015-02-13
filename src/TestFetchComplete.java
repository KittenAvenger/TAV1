import static org.junit.Assert.*;
import org.junit.Test;



public class TestFetchComplete {
	
	Server tester = new Server();
	
	
	@Test
	// Message exist for the recipent and message is not fetched
	public void ReceiverIdMatch1(){
		tester.add("Message1", "0761111234", "0769990000");
		assertEquals(-1, tester.fetch_complete("0769990000"));
	}
	
	@Test
	// Message exist for the recipent and message is fetched
	public void ReceiverIdMatch2(){
		tester.add("Message2", "0761123451", "0769990000");
		tester.fetch("0769990000");
		assertEquals(1, tester.fetch_complete("0769990000"));
	}
	@Test
	// Message does not exist for the recipent
	public void ReceiverIdNotMatch() {
		tester.add("Message3", "076113456", "0769990000");
		assertEquals(-1, tester.fetch_complete("0768880000"));  
	}
	
	
}
