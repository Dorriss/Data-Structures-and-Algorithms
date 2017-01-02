package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largestNumber {
	
static String Largest(int[] arr)
	{
	
 Comparator<Integer> com = new Comparator<Integer>() {

	public int compare(Integer o1, Integer o2) {
		int a = Integer.parseInt(o1.toString() + o2.toString());
		int b= Integer.parseInt(o2.toString() + o1.toString());
		
		if(a>b)
			return -1;
		else if(b>a)
			return 1;
		else
			return 0;
		
		
		
	}


};
  List<Integer> list = new ArrayList<>();
  for(int i=0 ;i<arr.length;i++)
  {
	  list.add(arr[i]);
  }

Collections.sort(list, com);

String result = new String();

for(int i=0;i<list.size();i++)
{
	result = result + list.get(i).toString();
	}


	
		return result;
		
	}


public static void main(String args[])
{
	int arr[] = { 1,5,78};
	String res = Largest(arr);
	System.out.println(res);

}

}
