import static org.junit.Assert.*;

import org.junit.Test;


public class TestFetch {
	
	Server tester = new Server();
	
	
	@Test
	// Receiver Id doesn't match
	public void ReceiverIdNotMatch() {
		tester.add("Message1", "0761111234", "0769990000");
		assertEquals("Message doesn't exist", tester.fetch("0768880000"));  
	}
	
	
	@Test
	// Receiver Id matches and message is fetched
	public void ReceiverIdMatch1(){
		tester.add("Message2", "0761512345", "0769940000");
		for(int i=0; i<Server.server.size(); i++) {
			if (Server.server.get(i).getReceiver().equals("0769940000") && Server.server.get(i).isFetched() == false) {
				Server.server.get(i).setFetched();
			}
		}
		
		assertEquals("Message doesn't exist", tester.fetch("0769940000"));
	}
	
	
	@Test
	// Receiver Id matches and message is not fetched
	public void ReceiverIdMatch2(){
		tester.add("Message3", "0761113256", "0769910000");
		String message = "";
		for(int i=0; i<Server.server.size(); i++) {
			if (Server.server.get(i).getReceiver().equals("0769910000") && Server.server.get(i).isFetched() == false) {
				message = message + "\nMessage id: " + Server.server.get(i).getID() + "\nMessage: '"+
						Server.server.get(i).getMessage()+"'\n"
					+ "Sender: "+Server.server.get(i).getSender();
			}
		}
		assertEquals(message, tester.fetch("0769910000"));
	}
	
	
}
