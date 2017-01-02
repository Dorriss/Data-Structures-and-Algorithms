package string;
import java.util.HashMap;
import java.util.Map.Entry;

public class PercentagestringMatch {

	public static void main(String args[]) {
		String s1 = "hello hi i am happy check";
		String s2 = "hello hi check check";

		HashMap<String, Integer> h1 = createHashMapWords(s1);
		HashMap<String, Integer> h2 = createHashMapWords(s2);

		System.out.println("string2 as percentage of string1 is"+ getPercentage(h1, h2) );
		System.out.println("string1 as percentage of string2 is"+ getPercentage(h2, h1) );

	}

	private static double getPercentage(HashMap<String, Integer> h1, HashMap<String, Integer> h2) {
		double count1 = 0;
		double count2 = 0;

		if(h1.isEmpty() || h2.isEmpty())
			return 0;
		
		for (Integer i : h1.values())
			count1 = count1+i;

		for (Entry<String, Integer> s : h1.entrySet()) {
			if (h2.containsKey(s.getKey())) {
				if (h2.get(s.getKey()) >= s.getValue()) {
					count2 = count2 + s.getValue();
				} else
					count2 = count2 + h2.get(s.getKey());
			}

		}
		
		return ((double)(count2*100/count1));

	}

	private static HashMap<String, Integer> createHashMapWords(String s1) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (String s : s1.split(" ")) {
			if (!s.isEmpty()) {
				if (hm.containsKey(s))
					hm.put(s, hm.get(s) + 1);
				else
					hm.put(s, 1);
			}
		}

		return hm;
	}

}
