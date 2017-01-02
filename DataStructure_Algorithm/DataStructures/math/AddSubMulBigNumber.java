package math;
import java.util.ArrayList;

/**
 * 
 * @author I072842 Add two big signed numbers both given as array of digits
 * Not supported for decimal numbers yet
 * 
 */
public class AddSubMulBigNumber {
	 int carry = 0;
	 char sign ;
	 ArrayList<Object> resultadd = new ArrayList<>();
	 ArrayList<Object> resultmul = new ArrayList<>();
	

	public static void main(String args[])
	{
		ArrayList<Object> a1 = new ArrayList<>();
		ArrayList<Object> a2 = new ArrayList<>();
		
		a1.add('-');
		a1.add(5);
		a1.add(5);
	//	a1.add('.');
		//a1.add(0);
		//a1.add(0);
		
		a2.add('-');
		a2.add(2);
		a2.add(2);
	//	a2.add(9);
	//	a2.add('.');
//		a2.add(6);
		
		AddSubMulBigNumber ad = new AddSubMulBigNumber();
	//	ad.check(a1, a2, '+');
	//	ad.AdditionAll(a1, a2);
		
		ad.mul(a1, a2);
	}
	 void check(ArrayList<Object> a1, ArrayList<Object> a2,char operation)
	{
	char a1sign = (char) a1.get(0);
	char a2sign = (char) a2.get(0);
	
	if(a2sign == operation)
	{
		a2sign = '+';
	}
	else
		a2sign = '-';
	
	
	if(a1sign == a2sign)
	{
		this.sign = a1sign;
		 add(a1,a2);
		 resultadd.add(0,sign);
		
	}
	else{		
		sub(a1,a2);
	}
	
	
		
		
	}
	private  void  add(ArrayList<Object> a1, ArrayList<Object> a2) {
		
		resultadd = new ArrayList<>();
		carry =0;
		
		
		if (a1.size() == 0 && a2.size() == 0) 
			return ;
		
		if(a1.size() == 0 )
		{
			resultadd = a2;
			return;
		}
		
		if(a2.size() == 0 )
		{
			resultadd = a1;
			return ;
		}
		int diff = Math.abs(a1.size() - a2.size());
		if (a1.size() < a2.size()) {
			while (diff > 0) {
				a1.add(0,0);
				diff--;
			}

		}

		if (a1.size() > a2.size()) {
			while (diff > 0) {
				a2.add(0,0);
				diff--;
			}

		}
		
		int size = a1.size()-1;
		/*for(int i=0;i<=size;i++)
			result.add(0);*/
		
		while(size>=0)
		{
			int addresult = Math.addExact((int)a1.get(size),(int)a2.get(size));
			addresult= Math.addExact(carry,addresult);
			if(addresult >=10 )
			{
				carry = addresult/10;
				addresult = addresult%10;
			}
			else 
				carry =0;
			
			resultadd.add(0,addresult);
			--size;
			
			
		}
		
		if(carry>0)
		{
		resultadd.add(0, carry);
		carry =0;
		}
		
	}
	private  void sub(ArrayList<Object> a1, ArrayList<Object> a2) {
		if (a1.size() == 0 && a2.size() == 0) 
			return ;
		
		if(a1.size() == 0 )
		{
			resultadd = a2;
		}
		
		if(a2.size() == 0 )
		{
			resultadd = a1;
			return ;
		}
		
		int diff = Math.abs(a1.size() - a2.size());
		if (a1.size() < a2.size()) {
			while (diff > 0) {
				a1.add(1,0);
				diff--;
			}

		}

		if (a1.size() > a2.size()) {
			while (diff > 0) {
				a2.add(1,0);  
				diff--;
			}

		}
		
		int size = a1.size()-1;
		
		boolean check =true;
		 int index =1;
		while(check)
		{
			if((int)a1.get(index)>(int)a2.get(index))
			{   sign = (char)a1.get(0);
				check=false;
				
			}
			else if((int)a1.get(index)<(int)a2.get(index))
			{
				ArrayList<Object> temp = a1;
				a1=a2;
				a2 = temp;
				sign =(char)a2.get(0);
				check=false;
			}
			else{
				if(index == size+1)
					return;
				index++;
			}
				
				
		}
		
		while(size>=1)
		{
			
			if((int)a1.get(size)<(int)a2.get(size))
			{
				a1.set(size,(int)a1.get(size)+10);
			    a1=borrow(a1,size-1);
			}
			int subresult = Math.subtractExact((int)a1.get(size),(int)a2.get(size));
			resultadd.add(0,subresult);
			--size;
			
			
		}
		
		resultadd.add(0, sign);

		
	}
	private  ArrayList<Object> borrow(ArrayList<Object> a1, int i) {
		
		if((int)a1.get(i)==0)
		{   
			a1.set(i,(int)a1.get(i)+10-1);
			a1=	borrow(a1,i-1);
		}
		else
			a1.set(i, (int)a1.get(i)-1);
		
		return a1;
	}
	
	
public  void mul(ArrayList<Object> a1, ArrayList<Object> a2) {
	
	resultmul = new ArrayList<>();
	int shift =0;
		carry =0;
		for(int i=a1.size()-1;i>0;i--)
		{
			
			ArrayList<Object> temp = new ArrayList<>();
			
			for(int j =a2.size()-1;j>0;j--)
			{
				int	mul = carry + (int)a1.get(i)*(int)a2.get(j);
				
				if(mul >= 10)
				{
					carry = mul/10;
					mul = mul%10;
				}
				else
					carry =0;
				
				temp.add(0,mul);
			}
			if(carry != 0)
			{
				temp.add(0, carry);
				carry =0;
			}
				
			for(int k=1;k<=shift;k++)
				temp.add(0);
			add(resultmul,temp);
			resultmul = resultadd;
			shift = shift+1;
			
		}
	}
	
}