import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

public class FrequencyGuesser implements IHangGuesser {
	private HangmanGame myGame;
	ArrayList<String> words;
	HashSet<Character> lettersGuessed;
	ArrayList<String> words2;
	@Override
	public void gameSetup(HangmanGame game) {
		// TODO Auto-generated method stub
		myGame = game;
		words=HangmanFileLoader.getAllWords(game.myDisplay.length());
		words2=words;
		lettersGuessed=new HashSet<Character>();
		
	}
	
	public char letterToGuess() {
		Iterator<String> it = words2.iterator();
		HashMap<Character,Integer> frequents= new HashMap<Character,Integer>();
		while (it.hasNext()){
			String temp1 =it.next();
		    String temp = removeDuplicates(temp1);
		   // System.out.println(temp + " " + temp1);
//		    System.out.println(it);
		    for (int i=0; i<temp.length(); i++) {
		    	if (frequents.containsKey(temp.charAt(i))) {
		    		frequents.put(temp.charAt(i), frequents.get(temp.charAt(i))+1);
		    	}
		    	else {
		    		if (!lettersGuessed.contains(temp.charAt(i))) {
		    		frequents.put(temp.charAt(i),1);
		    		}
		    	}
		    	
		    }
		    
		}
		int maxValue=1;
    	for (Integer value : frequents.values()) {

    		if (value>maxValue){
    			
    		   maxValue=value;
    	   }
    	}
   // 	System.out.println(words);
    	char output='~';
    	  for (Character key : frequents.keySet()) {
  //  		System.out.println(key + " amount of times: " + frequents.get(key));
    		  if (frequents.get(key) == maxValue) {
    				if (key.compareTo(output)<0)
    			    output=(char) key;
    	//		    System.out.println("Letter to guess:" + output);
    			  
    			}
    	  }
   // 	  System.out.println("Max letter is:" + output);
 
   //  System.out.println( output);
		return output;
	}
	
	public String removeDuplicates(String entry) {
		HashSet<String> duplicates= new HashSet<String>();
		for (int i=0;i<entry.length()-1;i++) {
			duplicates.add(entry.substring(i,i+1));
		}
		duplicates.add(entry.substring(entry.length()-1));
		String output="";
		for (String s:duplicates){
			output+=(s);
		}
			
		return output ;
	}

	@Override
	public boolean nextGuess() {
		// TODO Auto-generated method stub
		boolean indicator; 
		char guess=this.letterToGuess();
		lettersGuessed.add(guess);
		indicator = myGame.makeGuess(guess);
		if (!indicator){
			
		//	System.out.println(indicator);
			
			Iterator<String> it = words2.iterator();
			while (it.hasNext()){
			    String s = it.next();
			    if (s.indexOf(guess)==-1) {
			        it.remove();
			    }
			}
		}
		else{
			char temp=guess;
			Iterator<String> it = words2.iterator();
			while (it.hasNext()){
			    String s = it.next();
			    if (s.indexOf(temp)!=-1) {
			        it.remove();
			    }
			}
		}
		
		return myGame.gameOverHung() || myGame.gameOverGuessed();
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

}
