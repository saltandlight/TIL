package lotto;
 
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
public class User {
    private String userName;
    private final int MAX_TICKET = 5;
    Ticket[] tickets;
    Account account;
    Scanner scan= new Scanner(System.in);
    public User() {
    }
 
    public User(String userName) {
        this.setUserName(userName);
    }
 
    
    public User(String userName, Ticket[] tickets, Account account) {
		this.setUserName(userName);
		this.tickets = tickets;
		this.account = account;
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
 
//    String myInfo() {
//       return "�̸�:"+userName+
//   }
    
    public void checkMyNum(int[] lottoNum) {
    	int result;
    	for(Ticket ticket : tickets) {
    		result = ticket.decRank(lottoNum);
    		System.out.println(result +"�� ��÷!");
    	}
    }
 
    //������-�� Ƽ�ϵ��� ��ũ���� �迭�� �����ϴ� �Լ�
    int[] rtRank() {
        int [] rankArr= new int[tickets.length];
        for(int i=0;i<tickets.length;i++) {
            rankArr[i]=tickets[i].getRank();
        }
        return rankArr;
    }
    
    int reward(int money) {
        //money�� account.deposit�� �ִ´�.
 
        account.deposit(money);
        return 0;
    }
 
 
    public void myInfo() {
        
        System.out.println("���� �� ������ ������ "+tickets.length+"�� �Դϴ�.");
        for(int i=0;i<tickets.length;i++) {
            System.out.print((i+1)+"�� ������ ");
            System.out.print(Arrays.toString(tickets[i].getMyNum()));
            System.out.println(" ������ϴ�.");
        }
        System.out.println("�� ���� �ܾ��� "+account.getBalance()+"�Դϴ�.");
    }
 
    void buyTicket(int n) {
        
        this.tickets = new Ticket[n];
     
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
      
        if(def==1) {//random ���� �޽��ϴ�.
            for(int i=0;i<6;i++) {
                int num=r.nextInt(20)+1; //1~20
                //�ߺ��� üũ�մϴ�
                if(check[num]==true) {
                    i--;
                    continue;
                }
                else {
                    mynum[i]=num;
                    System.out.println(mynum[i]);
                    check[num]=true;
                }
            }
        }else if(def==0) {//Scanner���� �޽��ϴ�.
            for(int i=0;i<6;i++) {
                mynum[i]=scan.nextInt();
            }
        }
        return mynum;        
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
 
}


