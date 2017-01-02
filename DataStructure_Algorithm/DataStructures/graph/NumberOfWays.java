package graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberOfWays {

	public static void main(String args[]) {
		Node A = new Node();
		Node B = new Node();
		Node C = new Node();
		A.Id = "A";
		B.Id = "B";
		C.Id = "C";
		List<Node> achild = new ArrayList<>();
		List<Node> bchild = new ArrayList<>();
		List<Node> cchild = new ArrayList<>();

		achild.add(B);
	//	achild.add(C);
		//bchild.add(A);
		//cchild.add(B);

		A.outvertices = achild;
		B.outvertices = bchild;
		C.outvertices = cchild;

		System.out.println(traverse(A, B, 4));

	}

	public static class Node {
		String Id;
		List<Node> outvertices;

	}

	public static int traverse(Node start, Node end, int max) {
		int result = 0;
		if (start == null && max > 0) {
			return 0;
		}
		if (start.outvertices == null && max > 0) {
			return 0;
		}
		if (start.Id.equals(end.Id)) {
			result = 1;
		}
		if (max == 0)
			return result;
		Iterator itr = start.outvertices.iterator();
		while (itr.hasNext()) {
			int temp = traverse((Node) itr.next(), end, max - 1);
			result = result + temp;
		}
		return result;
	}
}
