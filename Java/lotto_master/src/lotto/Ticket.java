package lotto;
 
public class Ticket {
    // atts
    private int[] myNum;
    private int rank;
 
    // constructor
    Ticket(){
        myNum = new int[6];
        rank = 0;
    }
    Ticket(int[] myNum){
    	this.myNum = new int[6];
        for(int i = 0; i < 6; i++){
            this.myNum[i] = myNum[i];
        }
        this.rank = 0;
    }
 
    // methods
    
    public int decRank(int[] lottoNum){
        int count = 0;
        int result = 0;
        boolean bonus = false;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(lottoNum[i] == myNum[j]){
                    count++;
                    break;
                }
            }
        }
 
        for(int i = 0; i < 6; i++){
            if(lottoNum[7] == myNum[i]){
                bonus = true;
                break;
            }
        }
 
        if(count == 6){
            result = 1;
        }else if(count == 5 && bonus == true){
            result = 2;
        }else if(count == 5){
            result = 3;
        }else if(count == 4){
            result = 4;
        }else{
            result = 5;
        }
        
        this.rank = result;
 
        return result;
    }
 
 
    /**
     * @return the myNum
     */
    public int[] getMyNum() {
        return myNum;
    }
 
    /**
     * @param myNum the myNum to set
     */
    public void setMyNum(int[] myNum) {
        this.myNum = myNum;
    }
 
    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
 
    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
 
}



