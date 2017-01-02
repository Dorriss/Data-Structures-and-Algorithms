package math;
import java.util.ArrayList;
import java.util.List;

public class Factor235 {
	
	
	// 1 f(0)
    // 2 min(2*f(0), 3*f(0), 5*f(0))
    // 3 min(2*f(1), 3*f(0), 5*f(0))
    // 4 min(2*f(1), 3*f(1), 5*f(0))
    // 5 min(2*f(2), 3*f(1), 5*f(0))
    // 6 min(2*f(2), 3*f(1), 5*f(1))
    // 8 min(2*f(2), 3*f(2), 5*f(1))
    public static void main(String args[])
    {
    	int n =10;
        List<Integer> f = new ArrayList<Integer>();
        f.add(2);
        f.add(3);
        f.add(5);
        int i1, i2, i3;
        i1 = i2 = i3 = 1;

        for (int i = 1; i < n + 1; ++i)
        {
            int min = Math.min(Math.min(2 *f.get(i1), 3 * f.get(i2)), 5 * f.get(i3));
            f.add(min);
            if(min == 2*f.get(i1)) i1++;
            if (min == 3 * f.get(i2)) i2++;
            if (min == 5 * f.get(i3)) i3++;
        }
        
        for (int i = 0; i < f.size(); i++) {
			System.out.println(f.get(i));
		}

    //    Console.WriteLine(f[n]);
    }

}
