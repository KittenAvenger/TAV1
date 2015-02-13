import static org.junit.Assert.*;
import org.junit.Test;



public class TestFetchComplete {
	
	Server tester = new Server();
	
	
	@Test
	// Receiver Id matches and message is not fetched
	public void ReceiverIdMatch1(){
		tester.add("Message1", "0761111234", "0769990000");
		assertEquals(-1, tester.fetch_complete("0769990000"));
	}
	
	@Test
	// Receiver Id matches and message is fetched
	public void ReceiverIdMatch2(){
		tester.add("Message2", "0761123451", "0769990000");
		for(int i=0; i<Server.server.size(); i++) {
			if (Server.server.get(i).getReceiver().equals("0769990000") && Server.server.get(i).isFetched() == false) {
				Server.server.get(i).setFetched();
			}
		}
		assertEquals(1, tester.fetch_complete("0769990000"));
	}
	@Test
	// Receiver Id doesn't match 
	public void ReceiverIdNotMatch() {
		tester.add("Message3", "076113456", "0769990000");
		assertEquals(-1, tester.fetch_complete("0768880000"));  
	}
	
	
}
