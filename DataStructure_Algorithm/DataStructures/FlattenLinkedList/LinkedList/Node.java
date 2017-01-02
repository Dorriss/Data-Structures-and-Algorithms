package FlattenLinkedList.LinkedList;

public class Node {
	int data;
	Node next;
	Node down;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	
	public Node(int data,Node next,Node down)
	{
		this.data = data;
		this.next = next;
		this.down = down;
	}


}
