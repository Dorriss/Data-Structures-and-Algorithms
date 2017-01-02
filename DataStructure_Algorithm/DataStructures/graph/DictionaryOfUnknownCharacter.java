package graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


/**
 * 
 * @author Kanika
 * 
 *         Given a dictionary of unknown language and characters. Find out order
 *         between characters. Example : ab bcd ce de Output : a, b, c, d, e
 *
 * 
 */

class Node{
	char vertex;
	ArrayList<Node> edgesoutwards;
	ArrayList<Node> edgesinwards;
}
public class DictionaryOfUnknownCharacter {
	 HashMap<Character,Node> dag = new HashMap<Character,Node>();
	
public static void main(String args[])
{
	ArrayList<String>  input = new ArrayList<String>();
	input.add("ab");
	input.add("bcd");
	input.add("ce");
	input.add("de");
	
	DictionaryOfUnknownCharacter sol = new DictionaryOfUnknownCharacter();
	sol.getOrderofChars(input);
	
	}
	 
public void	getOrderofChars(ArrayList<String> input)
	{
	 
	//  HashSet<Character> S = new HashSet<Character>();
		for(int i=0 ;i<input.size()-1;i++)
		{
			int index =getmismatchindex(input.get(i),input.get(i+1));
			if(index != -1)
			{
				Node node1 = new Node();
				Node node2 = new Node();
				if(!dag.containsKey(input.get(i).charAt(index)))
				{
				
				node1.vertex = input.get(i).charAt(index);
				node1.edgesoutwards = new ArrayList<Node>();
				node1.edgesinwards = new ArrayList<Node>();
				dag.put(input.get(i).charAt(index), node1);
			//	S.add(input.get(i).charAt(index));
				}
				else
					node1 = dag.get(input.get(i).charAt(index));
					
				if(!dag.containsKey(input.get(i+1).charAt(index)))
				{
					node2.vertex = input.get(i+1).charAt(index);
					node2.edgesoutwards = new ArrayList<Node>();
					node2.edgesinwards = new ArrayList<Node>();
					dag.put(input.get(i+1).charAt(index), node2);
				}
				else
				{
					node2 = dag.get(input.get(i+1).charAt(index));
					/*if(S.contains(input.get(i+1).charAt(index)))
						S.remove(input.get(i+1).charAt(index));*/
				}
				node1.edgesoutwards.add(node2);	
				node2.edgesinwards.add(node1);
				
			}
			
		}
		
		
		TopologicalSort();
	}

private void TopologicalSort(){//HashMap<Character, Node> dag){//, HashSet<Character> S) {
		ArrayList<Character> result = new ArrayList<Character>();
		ArrayList<Character> S = new ArrayList<Character>();
		S= getVerticeswithNoInwardEdges();
		if(S.size()>1)
		{
			System.out.println("error");
		}
		
		while(!S.isEmpty())
		{  
			Character n = S.remove(0);
			Node node = dag.remove(n);
			  result.add(n);
			  ArrayList<Node> edgesnode = node.edgesoutwards;
			  for (Node entrynode : edgesnode) {
				  Node n2 = dag.get(entrynode.vertex);
				  n2.edgesinwards.remove(node);
				if(entrynode.edgesinwards.size() == 0)
					S.add(entrynode.vertex);
			}
			
			
		}
		
		if(!dag.isEmpty())
			System.out.println("error");
		
		else
			for(int i=0;i<result.size();i++)
			{
				System.out.println(result.get(i));
			}
 }

private ArrayList<Character> getVerticeswithNoInwardEdges(){//HashMap<Character, Node> dag) {
	ArrayList<Character> S = new ArrayList<Character>();
	for(Entry<Character, Node> ent: dag.entrySet())
	{
		if(ent.getValue().edgesinwards.size() == 0)
			S.add(ent.getKey());
	}
	return S;
}

private int getmismatchindex(String string1, String string2) {
	int i = Math.min(string1.length(),string2.length());
	for(int j=0;j<i-1;j++)
	{
		if(string1.charAt(j)!= string2.charAt(j))
			return j;
	}
	return -1;
}
	
}
