
/**
 * This class launches a CleverHangman game
 * and plays once, used to demonstrate the HangmanGame hierarchy and the
 * IHangGuesser interface hierarchy
 * @author Parker Pearson
 *
 */
public class CleverHangManExector {
	
	public static void main(String[] args) {

		CleverHangman game = new CleverHangman(4,10);
		IHangGuesser guesser = new HumanGuesser(); 
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
		System.out.printf("secret word is %s\n",game.words.get(0));
	}
}
