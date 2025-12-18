
import java.util.ArrayList;

public class GameWordTest{

	public static void main(String []args){
		GameWord gw = new GameWord("CAT");
		System.out.println(gw.reverse());         // tac		
		GameWord gw2 = new GameWord("ACT");
		GameWord gw3 = new GameWord("QUIZ");
		GameWord gw4 = new GameWord("LOOP");
		GameWord gw5 = new GameWord("LOPP");

		System.out.println(gw.anagram("act"));    // true
		System.out.println(gw.anagram(gw2));      // true
		System.out.println(gw.anagram(gw3));      // false
		
		System.out.println(gw3.pointValue(0, 0, GameWord.RIGHT));      // 96
		
		ArrayList<String> words = gw.permutations();
		System.out.println(words); 				  // [cat, cta, act, atc, tca, tac] 
		
		System.out.println(gw); 				  // cat
		System.out.println(gw4.anagram(gw5));      // false
		
	}

}