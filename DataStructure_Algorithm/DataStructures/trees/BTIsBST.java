package trees;

public class BTIsBST {
	
	public boolean isBST(Node root,int min,int max)
	{
		if(root == null)
			return true;
		
		if(root.data<min || root.data>max)
		 return false;
		
		else{
			return (isBST(root.left, min, root.data-1) && isBST(root.right,root.data+1 ,max));
		}
	}
	
	public static void main(String args[])
	{
		Node n = new Node(5);
		n.left = new Node(2);
		n.right = new Node(6);
		n.left.left = new Node(1);
		n.left.right = new Node(8);
		
		int min  = Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		
		BTIsBST a = new BTIsBST();
		System.out.println(a.isBST(n, min, max));
	}

}
