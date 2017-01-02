package setproblems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;

public class DocumentSets {

	public static void main(String args[]) {

		ArrayList<String> doc = new ArrayList<String>();
		doc.add("Alex said that it would be different this time would");
		doc.add("I will make it different this time I will make");
		doc.add("You look a sight different today You look a sight");
		doc.add("It was surely a different place back then It was");
		doc.add("Alex said  this time would that it would be different");
		doc.add("You You look a sight look a sight different today");

		getSets(doc);
	}

	public static void getSets(ArrayList<String> input) {

		int len = input.size();

		HashMap<HashSet<String>, ArrayList<Integer>> hm = new HashMap<HashSet<String>, ArrayList<Integer>>();

		for (int i = 0; i < len; i++) {
			HashSet<String> hs = new HashSet<String>();
					
			ArrayList<Integer> lst = new ArrayList<Integer>();
			String temp = new String();

			temp = input.get(i);
			for (String str : temp.split(" ")) {
				if (!str.isEmpty()) {
					hs.add(str);
				}
			}

			/*List sortedList = new ArrayList(hs);
			Collections.sort(sortedList);*/
			
			
			//HashSet<String> newhs = new HashSet<String>(sortedList);
			//hs = new HashSet(sortedList);

			if (hm.containsKey(hs)) {
				lst = hm.get(hs);
				lst.add(i);
				// hm.put(hs,lst);
			} else {
				lst.add(i);

			}
			hm.put(hs, lst);

		}
		
		System.out.println("number of sets is"+ hm.size());
		for(Entry st:hm.entrySet())
		{
			System.out.println("Elements of set"+ st.getKey());
			System.out.println("Document belonging to set are"+ st.getValue());
		}
		

	}
}
