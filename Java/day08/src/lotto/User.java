package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class User {
	private String userName;
	private final int MAX_TICKET = 5;
	Ticket[] tickets;
	Account account;

	public User() {

	}

	public User(String userName) {
		this.userName = userName;
	}

	public Ticket[] getTickets() {
		return tickets;
	}

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

//	String myInfo() {
//	   return "�̸�:"+userName+
//   }

	//������-�� Ƽ�ϵ��� ��ũ���� �迭�� �����ϴ� �Լ�
	int[] rtRank() {
		int [] rankArr= new int[tickets.length];
		for(int i=0;i<tickets.length;i++) {
			rankArr[i]=tickets.rank;
		}
		return rankArr;
	}
	
	int reward(int money) {
		//money�� account.deposit�� �ִ´�.

		account.deposit(money);
	}


	public void myInfo() {
		
		System.out.println("���� �� ������ ������ "+tickets.length+"�Դϴ�.");
		for(int i=0;i<tickets.length;i++) {
			System.out.print((i+1)+"�� ������ ");
			System.out.print(toString(myNum));
			System.out.println(" ������ϴ�.");
		}
		System.out.println("�� ���� �ܾ��� "+account.balance+"�Դϴ�.");
	}

	void buyTicket(int n) {
		Scanner scan= new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			account.withdraw(1000);// Ƽ�ϴ� 1000��
			System.out.println("�����̸� 0, �ڵ��̸� 1�� �Է����ּ���");
			int def=scan.nextInt();
			if(def==0)
				tickets[i]=new Ticket(inputMyNum(0));//������ ������ ��.
			else if(def==1)
				tickets[i]=new Ticket(inputMyNum(1));//������ ������ ��.
			
		}
	}

	private int[] inputMyNum(int def) {
		int [] mynum=new int[6];
		boolean [] check=new boolean[21];
		Random r = new Random();
		Scanner scan= new Scanner(System.in);
		if(def==0) {//random ���� �޽��ϴ�.
			for(int i=0;i<6;i++) {
				int num=r.nextInt(20)+1; //1~20
				//�ߺ��� üũ�մϴ�
				if(check[num]==true) {
					i--;
					continue;
				}
				else {
					mynum[i]=num;
					check[num]=true;
				}
			}
		}else if(def==1) {//Scanner���� �޽��ϴ�.
			for(int i=0;i<6;i++) {
				mynum[i]=scan.nextInt();
			}
		}
		return mynum;		
	}
	
	

}
