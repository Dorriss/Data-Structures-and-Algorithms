package MyOwnAutomata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class createnparse {

	@Test
	public void test() {
		
		State st3 = new State(false, true, 3, null);
		
		Map<Character,State> tr2 = new HashMap<Character,State>();
		tr2.put('b',st3);
		
		
		
		State st2 = new State(false, false, 2, tr2);
		Map<Character,State> tr1 = new HashMap<Character,State>();
		tr1.put('a',st2);
		
		State st1 = new State(true, false, 1,tr1);
		
	
		FSA myFSA = new FSA();
		
		myFSA.AddState(st1);
		myFSA.AddState(st2);
		myFSA.AddState(st3);
		System.out.println(myFSA.Parse("a"));
		
		//fail("Not yet implemented");
	}

}
