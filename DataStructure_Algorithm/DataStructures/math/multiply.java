package math;

public class multiply {
	public static String multiply(String a, String b) {
		int a1 = a.length();
		int b1 = b.length();
		int A[] = new int[a1]; //= new  //a.toCharArray();
		int B[] = new int[b1];// = //b.toCharArray();
		
		
		
		for(int i=0;i<a1;i++)
		{
			A[i] = Character.getNumericValue(a.charAt(i));
		}
		
		for(int i=0;i<b1;i++)
		{
			B[i] = Character.getNumericValue(b.charAt(i));
		}
		
		if(a1 ==1 && A[0] == 0)
			return "0";
		if(b1 ==1 && B[0] == 0)
			return "0";
		
		int[] C = new int[A.length+B.length];
        int s = C.length-1;
        
        for(int j=B.length-1; j>=0; j--){
            int carry=0;
            int shift = s;
            for(int i=A.length-1; i>=0; i--){
                int m = A[i]*B[j];
                int sum = m+C[shift]+carry;
                int num = sum%10;
                int c = sum/10;
                C[shift] = num;
                carry=c;
                shift--;
            }
            C[shift]=C[shift]+carry;            
            s--;            
        }
        
		String ret = new String();
		for(int i =C.length-1 ;i>=0;i--)
		{
		    while(true)
		    {
		       if( C[i] == 0)
		        i--;
		        else
		        break;
		    }
		    
			ret =  Integer.toString(C[i]) + ret;
		}
		return ret;
	}
	
	
	public static void main(String args[])
	{
		System.out.println(multiply("5", "456"));
	}
	
}
