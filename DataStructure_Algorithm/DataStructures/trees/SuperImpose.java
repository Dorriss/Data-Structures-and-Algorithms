package trees;

public class SuperImpose {


	public Node superImposeTree(Node root1, Node root2) {
		Node root = null;

		if ((root1 == null && root2 == null)) {
			return null;
		}

		if (root1 == null && root2 != null) {
			root = root2;
			return root;
		}
		
		if (root1 != null && root2 == null) {
			root = root1;
			return root;
		}
		
		if (root1.data == root2.data) {
			root = root1;
			root.left = superImposeTree(root1.left, root2.left);
			root.right = superImposeTree(root1.right, root2.right);

			return root;

		}	

		if (root1.data != root2.data) {
			System.out.println("not superimposible");
		}
		return null;

	}

	public static void main(String args[]) {
		BinaryTree1 tree1 = new BinaryTree1();
		BinaryTree1 tree2 = new BinaryTree1();

		// Let us construct the tree shown in above diagram
		tree1.root = new Node(5);
		tree1.root.left = new Node(1);
		tree1.root.right = new Node(2);

		tree2.root = new Node(5);
		tree2.root.right = new Node(2);
		tree2.root.right.left = new Node(6);
		tree2.root.right.right = new Node(7);

		/*
		 * tree.root.right = new Node(3); tree.root.left.left = new Node(4);
		 * tree.root.left.right = new Node(5); tree.root.right.left = new
		 * Node(6); tree.root.right.right = new Node(7);
		 * tree.root.right.left.right = new Node(8); tree.root.right.right.right
		 * = new Node(9);
		 */

		System.out.println("vertical order traversal is :");
		SuperImpose si = new SuperImpose();
		Node root = si.superImposeTree(tree1.root, tree2.root);
         if(root!= null)
		System.out.println(root.data);

		// tree.verticalOrder(root);
	}

}
