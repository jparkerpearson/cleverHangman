import java.util.ArrayList;


public class MinExecutor {
	public static void main(String[] args){	
		int loses=0;
		int wins=0;
		
		 for(int wlength=5; wlength <= 10; wlength++){ 
				ArrayList<String> theWords=HangmanFileLoader.getAllWords(wlength);
				String[] staticWords=new String[theWords.size()];
			for(int j=0; j<theWords.size();j++) {
					staticWords[j]=theWords.get(j);
			}
	
				int itr=staticWords.length;
				
				for (int i=0;i<itr;i++)
				{
					System.out.println(staticWords[i]);
					
				HangmanGame game = new HangmanGame(staticWords[i], 10);
				IHangGuesser guesser = new FrequencyGuesser(); 
				guesser.gameSetup(game);
		    	while (true){
					System.out.printf("guessing %s\n ", game.getDisplay());
					if (guesser.nextGuess()){
						break;
					}
					
				}
		    
				if (game.gameOverHung()) {
				loses++;
				}
				else if (game.gameOverGuessed()) {
				
					wins++;
				}
				
				theWords=HangmanFileLoader.getAllWords(wlength);
				
			}
		 }
	//	 System.out.println("Loses:" + loses + " Wins:" + wins);
		
	}
}



