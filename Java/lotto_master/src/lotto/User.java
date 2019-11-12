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
//       return "이름:"+userName+
//   }
    
    public void checkMyNum(int[] lottoNum) {
    	int result;
    	for(Ticket ticket : tickets) {
    		result = ticket.decRank(lottoNum);
    		System.out.println(result +"등 당첨!");
    	}
    }
 
    //유저들-내 티켓들의 랭크들을 배열로 리턴하는 함수
    int[] rtRank() {
        int [] rankArr= new int[tickets.length];
        for(int i=0;i<tickets.length;i++) {
            rankArr[i]=tickets[i].getRank();
        }
        return rankArr;
    }
    
    int reward(int money) {
        //money를 account.deposit에 넣는다.
 
        account.deposit(money);
        return 0;
    }
 
 
    public void myInfo() {
        
        System.out.println("내가 산 복권의 갯수는 "+tickets.length+"개 입니다.");
        for(int i=0;i<tickets.length;i++) {
            System.out.print((i+1)+"번 복권은 ");
            System.out.print(Arrays.toString(tickets[i].getMyNum()));
            System.out.println(" 찍었습니다.");
        }
        System.out.println("내 계좌 잔액은 "+account.getBalance()+"입니다.");
    }
 
    void buyTicket(int n) {
        
        this.tickets = new Ticket[n];
     
        for (int i = 0; i < n; i++) {
            account.withdraw(1000);// 티켓당 1000원
            System.out.println("수동이면 0, 자동이면 1을 입력해주세요");
            int def=scan.nextInt();
            if(def==0)
                tickets[i]=new Ticket(inputMyNum(0));//생성자 수정할 것.
            else if(def==1)
                tickets[i]=new Ticket(inputMyNum(1));//생성자 수정할 것.
            
        }
    }
 
    private int[] inputMyNum(int def) {
        int [] mynum=new int[6];
        boolean [] check=new boolean[21];
        Random r = new Random();
      
        if(def==1) {//random 으로 받습니다.
            for(int i=0;i<6;i++) {
                int num=r.nextInt(20)+1; //1~20
                //중복을 체크합니다
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
        }else if(def==0) {//Scanner에서 받습니다.
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


