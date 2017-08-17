import java.util.ArrayList;
import java.util.Iterator;


public class FrequencyTester {
	public static void main(String[] args){		
		ArrayList<String> theWords=HangmanFileLoader.getAllWords(5);
		Iterator<String> it = theWords.iterator();
		while(it.hasNext()) {
				HangmanGame game = new HangmanGame(it.next(), 10);
				IHangGuesser guesser = new FrequencyGuesser(); 
				guesser.gameSetup(game);
		    	while (true){
					System.out.printf("guessing %s\n ", game.getDisplay());
					if (guesser.nextGuess()){
						break;
					}
					
				}
		    	if (game.gameOverHung()) {
					System.out.println("you lose");
					}
					else if (game.gameOverGuessed()) {
					
						System.out.println("you won the word was tropical");
					}
		    	
					
		}
				
			}
		 
	//	 System.out.println("Loses:" + loses + " Wins:" + wins);
		
	}


