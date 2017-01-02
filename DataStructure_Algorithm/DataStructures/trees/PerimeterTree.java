package trees;

public class PerimeterTree {


	public void traverse(Node root)
	{
	  if (root == null) return;
	//  cout << p->data << " ";
	  System.out.println(root.data);
	  if (root.left != null ) traverseL(root.left ); //special function for outer left
	  if (root.right!= null) traverseR(root.right); //special function for outer right
	}

	public void traverseL(Node root)
	{
	//  cout << p->data << " ";
		System.out.println(root.data);
	  if (root.left != null ) traverseL(root.left ); //still in outer left
	  if (root.right!= null) traverseC(root.right); 
	}

	public void traverseR(Node root)
	{
	  if (root.left != null) traverseC(root.left );
	  if (root.right != null) traverseR(root.right); //still in outer right
	 // cout << p->data << " ";
	  System.out.println(root.data);
	}

	public void traverseC(Node root)
	{
	  if (root.left == null && root.right == null) //bottom reached
	   // cout << p->data << " ";
		  System.out.println(root.data);
	  else
	  {
	    if (root.left != null ) traverseC(root.left );
	    if (root.right != null) traverseC(root.right);
	  }
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

		//MirrorBinTree mt = new MirrorBinTree();
		PerimeterTree pt = new PerimeterTree();
		pt.traverse(tree.root);
		//System.out.println("vertical order traversal is :");
		//tree.verticalOrder(root);
		
		
	}
	
}
