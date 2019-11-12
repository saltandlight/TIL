package forwhile;

import java.util.Scanner;

public class WEx2 {

	public static void main(String[] args) {
		while(true) {
			System.out.println("Input Command..");
			Scanner sc = new Scanner(System.in);
			String cmd=sc.next();
			if(cmd.equals("q")) {
			  	System.out.println("Bye...");
			  	sc.close();
			  	break;
			}else if(cmd.contentEquals("i")) {
				System.out.println("Input 2 Num");
				int a=Integer.parseInt(sc.next());
				int b=Integer.parseInt(sc.next());
				System.out.println(a);
			}else if(cmd.equals("s")){
				System.out.println("Selected..");
			}else {
				System.out.println("Re-Try");
				continue;
			}
			System.out.println("Completed...");
		}
		System.out.println("System Exit ..");
	}

}
