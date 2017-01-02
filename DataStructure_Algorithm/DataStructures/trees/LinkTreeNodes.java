package trees;
import java.util.LinkedList;
import java.util.Queue;

//Definition for binary tree with next pointer.
  class TreeLinkNode {
     int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
 
public class LinkTreeNodes {
    public void connect(TreeLinkNode root) {
        
        if(root== null)
        return;
        
        Queue<TreeLinkNode> q = new LinkedList<>();
        if(root.left!= null)
        q.add(root.left);
        if(root.right!= null)
        q.add(root.right);
 
        
        while(!q.isEmpty())
        {	
        	int size = q.size();
        	while(size>0)
        	{
        	TreeLinkNode node = q.poll();
        	size--;
        	if(node.left!= null)
        		q.add(node.left);
        	if(node.right!= null)
        		q.add(node.right);
        	
        	if( size ==0)
        	node.next= null;
        	else
        		node.next =q.peek();
        	}
        }
        
    }
}
