package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestFetch {
	
	Server tester = new Server();
	
	
	@Test
	// Sender Id doesn't match
	public void SernderIdNotMatch() {
		tester.add("Message1", "0761111234", "0769990000");
		assertEquals("Message doesn't exist", tester.fetch("0768880000"));  
	}
	
	
	@Test
	// Sender Id matches and message is fetched
	public void SenderIdMatch1(){
		tester.add("Message2", "0761112345", "0769990000");
		for(int i=0; i<tester.server.size(); i++) {
			if (tester.server.get(i).getReceiver().equals("0769990000") && tester.server.get(i).isFetched() == false) {
				tester.server.get(i).setFetched();
			}
		}
		assertEquals("Message doesn't exist", tester.fetch("0769990000"));
	}
	
	
	@Test
	// Sender Id matches and message is not fetched
	public void SenderIdMatch2(){
		tester.add("Message3", "0761113456", "0769990000");
		String message = "";
		for(int i=0; i<tester.server.size(); i++) {
			if (tester.server.get(i).getReceiver().equals("0769990000") && tester.server.get(i).isFetched() == false) {
				message = message + "\nMessage id: " + tester.server.get(i).getID() + "\nMessage: '"+
					tester.server.get(i).getMessage()+"'\n"
					+ "Sender: "+tester.server.get(i).getSender();
			}
		}
		assertEquals(message, tester.fetch("0769990000"));
	}
	
	
}
