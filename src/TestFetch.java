import static org.junit.Assert.*;

import org.junit.Test;


public class TestFetch {
	
	Server tester = new Server();
	
	
	@Test
	// Message exists for the recipent
	public void ReceiverIdNotMatch() {
		tester.add("Message1", "0761111234", "0769990000");
		assertEquals("Message doesn't exist", tester.fetch("0768880000"));  
	}
	
	
	@Test
	// Message exists for the recipent and message is fetched
	public void ReceiverIdMatch1(){
		tester.add("Message2", "0761512345", "0769940000");
		tester.fetch("0769940000");
		
		assertEquals("Message doesn't exist", tester.fetch("0769940000"));
	}
	
	
	@Test
	// Message exists for the recipent and message is not fetched
	public void ReceiverIdMatch2(){
		tester.add("Message3", "0761113256", "0769910000");
		String message = "";
		for(int i=0; i<Server.server.size(); i++) {
			if (Server.server.get(i).getReceiver().equals("0769910000")) {
				message = message + "\nMessage id: " + Server.server.get(i).getID() + "\nMessage: '"+
						Server.server.get(i).getMessage()+"'\n"
					+ "Sender: "+Server.server.get(i).getSender();
			}
		}
		assertEquals(message, tester.fetch("0769910000"));
	}
	
	
}
