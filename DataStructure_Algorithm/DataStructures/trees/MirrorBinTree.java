package trees;

public class MirrorBinTree {

	public void Mirror(Node root)
	{
		Node temp;
		if(root == null)
			return;
		
		//if(root.left!= null )
		 temp = root.left;
		 root.left = root.right;
		 root.right = temp;
		 
		 Mirror(root.left);
		 Mirror(root.right);
			
	}
	public static void main(String args[]) {
		BinaryTree1 tree = new BinaryTree1();

		/* Let us construct the tree shown in above diagram */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		MirrorBinTree mt = new MirrorBinTree();
		mt.Mirror(tree.root);
		//System.out.println("vertical order traversal is :");
		//tree.verticalOrder(root);
		
		
	}
	
	
}
