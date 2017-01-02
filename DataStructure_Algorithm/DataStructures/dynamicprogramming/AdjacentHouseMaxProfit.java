package dynamicprogramming;

import java.lang.Object;
public class AdjacentHouseMaxProfit {

	int[] money = { 12, 5, 15, 29, 30, 1, 55, 80, 4 };

	public int calc(int i, boolean in) {

		if (i == money.length - 1 && in == true)
			return money[money.length - 1];

		if (i == money.length - 1 && in == false)
			return 0;

		if (!in) {
			if (i < money.length - 1)
				return Math.max(calc(i + 1, false), calc(i + 1, true));
			else
				return 0;
		}

		if (in) {
			if (i < money.length - 2) {
				return money[i] + Math.max(calc(i + 2, true), calc(i + 2, false));
			} else
				return money[i];
		}

		
		return 0;

	}

	public int addcalcutil() {
		int temp1 = calc(0, false);
		int temp2 = calc(0, true);
		return Math.max(temp1, temp2);
	}

	public static void main(String args[]) {
		AdjacentHouseMaxProfit ad = new AdjacentHouseMaxProfit();
		ad.addcalcutil();
	}

}
