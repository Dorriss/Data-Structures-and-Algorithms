package sorting;
import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeKLists {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		
		ListNode result = null;
		
		int k = a.size();
		
		if(k==1)
			return a.get(0);
       
		if(k==2)
		{
			ListNode start1 = a.get(0);
			ListNode start2 = a.get(1);
			ListNode temp = null;
			
			while(start1!= null && start2!= null)
			{
			if(start1.val < start2.val)
			{
				
				ListNode tempnode = new ListNode(start1.val);
				start1 = start1.next;
				if(result == null)
				{
					result = tempnode;
				}
				if(temp  == null)
				temp = tempnode;
				else
				{
					temp.next = tempnode;
					temp = temp.next;
				}
				
			}
			
			else
			{
				ListNode tempnode = new ListNode(start2.val);
				start2 = start2.next;
				if(result == null)
				{
					result = tempnode;
				}
				if(temp  == null)
				temp = tempnode;
				else
				{
					temp.next = tempnode;
					temp = temp.next;
				}
			}
			}
			
			if(start1 != null)
			{
				temp.next = start1;
				return result;
			}
			
			if(start2 != null)
			{
				temp.next = start2;
				return result;
			}
			
			//insert logic
		}
		
		if(k>2)
		{
			ArrayList<ListNode> temp = new ArrayList<ListNode>();
			temp.add(a.get(0));
			a.remove(0);
			temp.add(mergeKLists(a));
			result = mergeKLists(temp);
			
			
		}
		

		return result;
	}

	public static void main(String args[]) {

		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		MergeKLists sol = new MergeKLists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(10);
		l1.next.next = new ListNode(20);

		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(11);
		l2.next.next = new ListNode(13);

		ListNode l3 = new ListNode(3);
		l3.next = new ListNode(8);
		l3.next.next = new ListNode(9);

		arr.add(l1);
		arr.add(l2);
		arr.add(l3);

		ListNode result = sol.mergeKLists(arr);
		
		while(result != null)
		{
		if(result.next != null)	
		System.out.print(result.val  + "->");
		else
			System.out.println(result.val);
		result= result.next;
		}

	}

}
