import static org.junit.Assert.assertEquals;

import org.junit.Test;




public class TestAdd {
	
	Server tester = new Server();
	
	
	
	@Test
	public void InvalidSender() {
	   assertEquals("any text returns -1", -1, tester.add("message","textjtextj","0724456743"));  // One argument text, one argument number
	}
	
	
	@Test
	public void InvalidSenderMixed(){
	   assertEquals("mixed text and numbers return -1", -1, tester.add("message","t34xtt5461","0769875643")); // one argument with mixed of text and numbers
	}
	
	
	@Test
	public void InvalidReceiver(){
		assertEquals("numbers longer or less than 10 should return -1", -1, tester.add("message","1234567890","sfdgfg")); // arguments less and bigger than 10 numbers
	}
	
	@Test
	public void InvalidReceiverMixed(){
		assertEquals("numbers longer or less than 10 should return -1", -1, tester.add("message","1234567890","90546gfgab")); // one argument 10 numbers, the other more
	}
	
	
	@Test
	public void InvalidLengthReceiver(){
		assertEquals("numbers longer or less than 10 should return -1", -1, tester.add("message","1234567890","1234")); // one argument 10 numbers, the other more
	}
	
	@Test
	public void InvalidLengthSender(){
		assertEquals("numbers longer or less than 10 should return -1", -1, tester.add("message","123456789","1234567890")); // one argument 10 numbers, the other more
	}
	
	
	@Test
	public void empty_message()
	{
		assertEquals("Empty messages Should return -1 ", -1, tester.add("","0768725334","0756843345"));
	}
	
	@Test
	public void null_message()
	{
		String msg= null;
		assertEquals("Empty messages Should return -1 ", -1, tester.add(msg,"0768725334","0756843345"));
	}
	
	
	
	@Test
	public void normal_function()
	{
		int ID = tester.add("howdy","0768725334","0756843345");
		int ID2 = tester.returnServer().getID();
		assertEquals(ID2, ID);
	}
	
/*	@Test(timeout=8000)
	public void testNonUniqueID() {
		for(int i = 0; i < 10500; i++){
			Server caller = new Server();
			caller.add("Bacon is awesome", "0970956651", "0705565671");
		
		}
		boolean flag = duplicates(Server.IDS);
		
			Server.server.clear();
			Server.IDS.clear();
			
		
		assertFalse(flag);
		
	} */
	@Test
	
	public void testFullMsgList() {
		for(int i = 0; i <= 10200; i++){
			Server caller = new Server();
			caller.add("Bacon is awesome", "0970956651", "0705565671");
		
		}
		
		Server caller = new Server();
		int result = caller.add("Bacon is awesome", "0970956651", "0705565671");
		
		assertEquals(-1, result);
		Server.server.clear();
		Server.IDS.clear();
		
		
	}
	

	
	// Helper function to check for duplicate elements in a list
	
/*	boolean duplicates(final ArrayList <Integer> IDList)
	{
	  Set<Integer> lump = new HashSet<Integer>();
	  for (int i : IDList)
	  {
	    if (lump.contains(i)) return true;		//Returns true if list contains duplicates, if it doesn't means testNonUniqueID has passed
	    
	    lump.add(i);
	  }
	  return false;
	}  */
}
