import java.util.Scanner;


public class Main {

	public static void main (String [] args){

		Server caller = new Server ();
		
		System.out.println(caller.add("Hey whats up", "0702556677", "0705565672"));
		Scanner scan = new Scanner (System.in);
		String receiver = scan.next();
		System.out.println(caller.fetch(receiver));
		scan.close();
		
	}
}
