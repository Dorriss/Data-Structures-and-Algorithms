package lruImplementation;
import java.util.HashMap;

public class LRUCache {

	int capacity;
	HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
	Node head = null;
	Node tail = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {

		if (hm.containsKey(key)) {
			Node m = hm.get(key);
			remove(m);
			setHead(m);
			return m.value;
		}
		return -1;

	}

	private void setHead(Node m) {

		m.next = head;
		m.pre = null;

		if (head != null)
			head.pre = m;

		head = m;
		if (head == null)
			tail = head;

	}

	private void remove(Node m) {

		if (m.pre != null)
			m.pre.next = m.next;
		else
			head = m.next;

		if (m.next != null)
			m.next.pre = m.pre;
		else
			tail = m.pre;
	}
	
	public void set(int key,int value)
	{
		if(hm.containsKey(key))
		{
			Node n = hm.get(key);
			n.value = value;
			remove(n);
			setHead(n);
			
		}
		else
		{
			Node created = new Node(key, value);
			if(hm.size() >= capacity)
			{
				hm.remove(tail.key);
				remove(tail);
				setHead(created);
			}
			else
				setHead(created);
			
			hm.put(key, created);
		}
	}

}
