import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class CleverHangman extends HangmanGame {
ArrayList<String> words; 
int wlength;
int counter;
	public CleverHangman(int wordlength, int misses) {
		super(wordlength, misses);
		wlength=wordlength;
			words=HangmanFileLoader.getAllWords(wordlength);
			 counter=misses;
		}
		
	 public boolean makeGuess(char ch){
		 if (myLettersGuessed[ch-'a']){
	    		return false;
	    	}
		 myLettersGuessed[ch-'a'] = true;
		 
	HashMap<String,Integer> wordIndicator= new HashMap<String,Integer>(); 
		 for (String s: words)   {
			 String entry="";
			 for (int i=0; i<wlength;i++) {
				 entry+="_";
			 }
	    	for (int i=0;i<s.length();i++) {
	    		if (s.charAt(i)==ch) {
	    			if(i<wlength-1) {
	    				entry=entry.substring(0,i)+ch+entry.substring(i);
	    			}
	    			else {
	    				entry=entry.substring(0,i)+ch;
	    			}
	    		}
	    	}
	    	if (wordIndicator.containsKey(entry)) {
	    		wordIndicator.put(entry, wordIndicator.get(entry)+1);
	    	}
	    	else {
	    		wordIndicator.put(entry, 1);
	    	}
	    }
		 System.out.println(words);
		 System.out.println(wordIndicator);
		 // get biggest value from wordIndicator
		 // if that value is 0 return that char is not in the word
		 // else remove all words from words that do not include the letter in that location
		 int maxVal=0;
		 String maxString = "";
		 for (int x=0;x<wlength;x++) {
			 maxString+="_";
		 }
		 for (String itz:wordIndicator.keySet()) {
			if (wordIndicator.get(itz)>maxVal) {
				maxVal=wordIndicator.get(itz);
				maxString=itz;
			}
		 }
		 
		 Iterator<String> it = words.iterator();
			while (it.hasNext()){
			    boolean indicator=false;
				String str = it.next();
			    for (int j=0; j<str.length();j++) {
			    	if (str.charAt(j)==ch) {
			    		if (maxString.charAt(j)!=ch) {
			    			indicator=true;
			    		}
			    	}	
			    }
			    for (int j=0; j<maxString.length();j++) {
			    	if (maxString.charAt(j)==ch) {
			    		if (str.charAt(j)!=ch) {
			    			indicator=true;
			    		}
			    	}
			    }
			    if (indicator) {
			    	it.remove();
			    }
			}
			
	    	if (maxString.indexOf(ch)==-1){
	    		myMissCount++;
	    		return false;
	    		
	    	}
	    	
	    	for(int k=0; k < maxString.length(); k++){
	    		if (maxString.charAt(k) == ch){
	    			myDisplay.setCharAt(k,ch);
	    		}
	    	}
	    		return true;
	    	
	    }       
	
	
}
