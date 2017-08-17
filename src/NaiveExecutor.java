

public class NaiveExecutor {

	public static void main(String[] args){
		
		for(int wlength=5; wlength <= 8; wlength++){
		    GuessExecutor ng = new GuessExecutor(wlength,10, new FrequencyGuesser());
		    System.out.printf("word length: %d\n",wlength);
		    
		}
	}
}
