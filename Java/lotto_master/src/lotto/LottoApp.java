package lotto;

public class LottoApp {

	public static void main(String[] args) {
		System.out.println("로또 프로그램 시작.");
		User[] users = new User[3];
		for(int j =0 ; j < 3; j++) {
			String uname = Integer.toString(j+1);	
			users[j] = new User(uname);
		}
		
		
		for(User u : users) {
			Account account = new Account(u.getUserName(), 10000);
						
			u.setAccount(account);
			System.out.println("유저 "+ u.getUserName());
			
			u.buyTicket(3);
			u.myInfo();
		}
		
		Lotto lotto = new Lotto();
		
		lotto.calcReward(users);
		lotto.sendReward(users);
		
		for(User u : users) {
			u.myInfo();
		}

	}

}
