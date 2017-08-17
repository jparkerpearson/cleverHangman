
/**
 * This class launches a Hangman game
 * and plays once, used to demonstrate the HangmanGame hierarchy and the
 * IHangGuesser interface hierarchy
 * @author Owen Astrachan
 *
 */
public class HangmanExecuter {
	
	public static void main(String[] args) {

		HangmanGame game = new HangmanGame("buzzing", 12);
		IHangGuesser guesser = new FrequencyGuesser(); 
		guesser.gameSetup(game);
		while (true){
			System.out.printf("guessing %s\n ", game.getDisplay());
			if (guesser.nextGuess()){
				break;
			}

		}
		
		if (game.gameOverHung()) {
			System.out.println("you lose!");
		}
		else if (game.gameOverGuessed()) {
			System.out.println("you win!");
		}
		System.out.printf("secret word is %s\n",game.getSecret());
	}
}
