package math;

public class PowerOfTwoIntegers {
	
	public static void main(String args[])
	{
		System.out.println(isPower(1));
	}

public static boolean isPower(int a) {
	
       
        for(int x=2;x<Math.floor(Math.sqrt(a)+1);x++)
        {
        	int y=1;
        	while(Math.pow(x, y)<=a)
        	{
        		if(Math.pow(x, y) == a)
        			return true;
        		else
        			y=y+1;
        	}
        }
		return false;
    }
}
