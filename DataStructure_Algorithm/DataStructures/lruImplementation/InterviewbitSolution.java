package lruImplementation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class InterviewbitSolution {

	HashMap<Integer, Integer> hm = new HashMap<>();
	Queue<Integer> q = new LinkedList<>();
	int capacity;

	public InterviewbitSolution(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		int value = -1;
   
			if (q.contains(key)) {
				value = hm.get(key);
				q.remove(key);
				q.add(key);

			}
		return value;
	}

	public void set(int key, int value) {

		if (!q.contains(key)) {
			if (this.capacity != 0) {
				this.capacity--;
			} else {
				q.remove();
			}
			q.add(key);
		}
		
		else
		{
			q.remove(key);
			q.add(key);
		}
		hm.put(key, value);
		
	}

}
