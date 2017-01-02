package bittricks;


/**
 * 
 * @author I072842
 * 
 * ********************
 x & (x-1) will clear the lowest set bit of x
 x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
 x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
 x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
 x | (x + 1) = x with the lowest cleared bit set.
 x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
 x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
 x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.
 * 
 *
 */
public class bittrickscheck {
	
	
	
	public static void main(String args[])
	{
		int a = 10;
		int abinary = Integer.parseInt(Integer.toBinaryString(a));
		System.out.println(abinary);
		
		a = a & a-1;
		int abinaryclearlowestsetbit = Integer.parseInt(Integer.toBinaryString(a));
		System.out.println(abinaryclearlowestsetbit);
		
		a=10;
		a = a & ~(a-1);
		int abinaryextractlowestsetbit = Integer.parseInt(Integer.toBinaryString(a));
		System.out.println(abinaryextractlowestsetbit);
		
	}
	

}
