package dynamicprogramming;

public class KnapSack01 {

	int[] b = { 3, 4, 5, 6 };
	int[] w = { 2, 3, 4, 5 };
	int MaxWieght = 5;

	public void cal() {

		int row = b.length;
		int col = MaxWieght;
		int[][] res = new int[row + 1][col + 1];
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (i == 0 || j == 0)
					res[i][j] = 0;
				else {
					if (j - w[i - 1] >= 0)
						res[i][j] = Math.max(res[i - 1][j], b[i-1] + res[i - 1][j - w[i - 1]]);

					else
						res[i][j] = res[i - 1][j];
				}

			}
		}
		System.out.println(res[row][col]);
	}

	public static void main(String args[]) {
		KnapSack01 kn = new KnapSack01();
		kn.cal();
	}

}
