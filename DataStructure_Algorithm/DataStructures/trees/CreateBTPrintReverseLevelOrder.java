package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CreateBTPrintReverseLevelOrder {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */

		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scin.nextInt();
		}

		createBT(arr);
	}

	private static void createBT(int[] arr) {

		int length = arr.length;

		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < length; i++) {
			if (!hm.containsKey(arr[i])) {
				ArrayList<Integer> childlist = new ArrayList<Integer>();
				childlist.add(i);
				hm.put(arr[i], childlist);
			}

			else if (hm.containsKey(arr[i])) {
				ArrayList<Integer> childlist = hm.get(arr[i]);
				if (childlist == null)
					childlist = new ArrayList<Integer>();
				childlist.add(i);
				hm.put(arr[i], childlist);

			}

			if (!hm.containsKey(i)) {
				//ArrayList<Integer> childlist = new ArrayList<Integer>();
				hm.put(i, null);
			}

		}

		levelOrderReverse(hm);
	}

	public static void levelOrderReverse(HashMap<Integer, ArrayList<Integer>> tree) {
		ArrayList<Integer> root = tree.get(-1);
		if (root.isEmpty())
			return;

		LinkedList<Integer> q = new LinkedList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		q.addAll(tree.get(-1));
		while (!q.isEmpty()) {
			st.push(-5);
			int size = q.size();
			while (size > 0) {
				ArrayList<Integer> children = new ArrayList<Integer>();
				Integer element = q.removeFirst();
				size--;
				if (tree.get(element) != null) {
					children = tree.get(element);
					for (int i = children.size() - 1; i >= 0; i--) {
						q.add(children.get(i));
					}
				}

				st.push(element);
			}

		}
		while (!st.isEmpty()) {
			if (st.peek() == -5) {
				st.pop();
				System.out.println();
			} else
				System.out.print(st.pop() + " ");
		}
	}
}