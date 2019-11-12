package lotto;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	private int lottoNum[];
	private double reward[];
	private static int sNum = 1;
	private static double totalReward = 10000000.0;
	
	public Lotto() {
		Random rand = new Random();
		lottoNum = new int[7];
		lottoNum[0] = rand.nextInt(45)+1;
		for(int i = 1; i < lottoNum.length; i++) {
			lottoNum[i] = rand.nextInt(45)+1;
			for(int j = 0; j < i; j++) {
				if(lottoNum[j] == lottoNum[i]) {
					i--;
				}
				
			}
		}
		sNum++;
		System.out.println(Arrays.toString(lottoNum));
	}
	public double[] sendReward(User[] users) {
		double allreward[] = new double[users.length];
		int i = 0;
		for(User user : users) {
			for(int r : user.rtRank()) {
				if(r == 1) {
					allreward[i] += reward[0];
				}else if(r==2){
					allreward[i] += reward[1];
				}else if(r==3){
					allreward[i] += reward[2];
				}else if(r==4){
					allreward[i] += reward[3];
				}else {
					allreward[i] += 0;
				}
				
			}
			i++;
		}
		return allreward;
	}
	public void calcReward(User[] users) {
		int reward[] = new int[4];
		double[] countRanks = new double[4];
		for(User user: users) {
			for(int r : user.rtRank()) {
				if(r != 0 && r!= 5 ) {
					countRanks[r-1]++;
				}
			}
		}
//		System.out.println(countRanks[0]); 0.0이 출력됨...
		this.reward[0] = totalReward * 0.5 / countRanks[0];
		this.reward[1] = totalReward * 0.3 / countRanks[1];
		this.reward[2] = totalReward * 0.1 / countRanks[2];
		this.reward[3] = 500;
		System.out.printf("1등 : .3f%원\n2등 = .3f%원\n3등 = .3f%원\n4등 = 500원",reward[0],reward[1],reward[2]);
	}
	public int[] getLottoNum() {
		return lottoNum;
	}
	public void setLottoNum(int[] lottoNum) {
		this.lottoNum = lottoNum;
	}
	public double[] getReward() {
		return reward;
	}
	public void setReward(double[] reward) {
		this.reward = reward;
	}
	public static int getsNum() {
		return sNum;
	}
	public static void setsNum(int sNum) {
		Lotto.sNum = sNum;
	}
	public static double getTotalReward() {
		return totalReward;
	}
	public static void setTotalReward(int totalReward) {
		Lotto.totalReward = totalReward;
	}
	@Override
	public String toString() {
		return "Lotto [lottoNum=" + Arrays.toString(lottoNum) + ", reward=" + Arrays.toString(reward) + "]";
	}
	
	

}
