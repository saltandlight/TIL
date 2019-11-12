package ifswhitch;

public class Game2 {

	public static void main(String[] args) {
		String str="jmlee@tonesol.com";
//		int c=str.indexOf("jmlee");
//		System.out.println(c);
		String id=str.substring(0, str.indexOf("@"));
		
		String domain=str.substring(str.indexOf("@")+1, str.indexOf("."));
		System.out.println(id+" "+domain);
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}

}
