package FlattenLinkedList.LinkedList;

public class Solution {
	
	 Node root; 

	public  Node getRoot() {
		return root;
	}

	public  void setRoot(Node root) {
		this.root = root;
	}

	public static void main(String args[]) {
		Node root = null;
		
	Solution sol = new Solution();
			sol.setRoot(sol.createNonFlatList());

	sol.setRoot(sol.flatten(sol.getRoot()));
	}

	private  Node createNonFlatList() {
		
		Node n =new Node(15,new Node(16,null,null), new Node(20,new Node(21, null, null),null));
		
		Node root =new Node(7,new Node(8,null,null),new Node(14,n,null));
		
		return root;
	}

	private  Node flatten(Node node) {
		Node temp = node;

		if (node == null)
			return null;

		while (temp.getDown() == null)
		{
			if (temp.getNext() == null)
				return temp;
			else
			temp = temp.getNext();
		}

		
		
		if (temp.getDown() != null)

		{
			//Node temp1 = new Node();
			Node temp1 = temp.getNext();
			temp.setNext(flatten(temp.getDown()));
			temp.setDown(null);

			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(temp1);
		}

		return node;
	}

}
