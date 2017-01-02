package arrays;
/**
 * 
 * Given a gold mine of n*m dimension. Each field in this mine contains an
 * integer which is amount of gold in tons. Initially miner is in first column
 * but could be at any row i. He can move only (right ->, right up /, right down
 * \). Find out maximum amount of gold he can collect and path followed by him.
 *
 * 
 */
public class GoldMineProblem {

	int[][] goldMine;

	public static void main(String args[]) {
		GoldMineProblem sol = new GoldMineProblem();
		int[][] goldMine1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		sol.goldMine = goldMine1;
		int max = sol.getMaxGold();
		System.out.println(max);

	}

	public int getMaxGold() {

		if (goldMine == null || goldMine.length == 0) {
			return 0;
		}
		int rowLength = goldMine.length;
		int colLength = goldMine[0].length;

		int[][] goldMineTable = new int[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				goldMineTable[i][j] = 0;
			}
		}
		for (int col = colLength - 1; col >= 0; col--) {
			for (int row = 0; row < rowLength; row++) {

				int right = col == colLength - 1 ? 0 : goldMineTable[row][col + 1];

				int rightUp = (row == 0 || col == colLength - 1 ? 0 : goldMineTable[row - 1][col + 1]);

				int rightDown = (row == rowLength - 1 || col == colLength - 1 ? 0 : goldMineTable[row + 1][col + 1]);

				goldMineTable[row][col] = goldMine[row][col] + Math.max(rightUp, Math.max(right, rightDown));
			}
		}
		int max = 0;

		for (int i = 0; i < rowLength; i++) {
			max = max < goldMineTable[i][0] ? goldMineTable[i][0] : max;
		}
		return max;
	}

}
