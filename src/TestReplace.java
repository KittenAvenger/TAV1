import static org.junit.Assert.*;

import org.junit.Test;


public class TestReplace {

	Server tester = new Server();
	
	@Test
	public void NotExistingID(){	// one add method used
		tester.add("sdfsfdfds", "0763431334", "0763469234");
		assertEquals("non existing id should return -1", -1, tester.replace(6523223, "howdy"));
	}
	
	
	@Test
	public void NotExistingID2(){	//two add methods used
		tester.add("sdfsfdfds", "0763434234", "0763464234");
		tester.add("sdfsfdfds", "0763434234", "0763464274");
		assertEquals("non existing id should return -1", -1, tester.replace(6523223, "howdy"));
	}
	
	@Test
	public void cantReplaceFetched(){
		int ID = tester.add("howdy mate", "0768897676", "0778637453");
		tester.fetch("0778637453");
		assertEquals("this message is already fetched, should return -1", -1, tester.replace(ID, "this text should not be replaced"));
	}
	
	@Test
	public void checkEmptyMessage(){
		int ID = tester.add("hello matey", "0763243561", "0776784563");
		assertEquals("this message is empty, should return -1", -1, tester.replace(ID, ""));
	}
	
	@Test
	public void normalFunction(){
		int ID = tester.add("whats up", "0763654561", "0776782163");
		assertEquals("Should return the message ID", ID, tester.replace(ID, "changed message"));
	}

}
