package arrays;

/**
 * given matrix wich contains one and zeros
 * All ones represent land and 0's as water.
 * Deteremine the numbr of clusters of Island
 * clusters consist of 1's in all 8 possible direction within array
 * 
 */

import java.util.Arrays;

public class FindCluster {

	// int[m][n];

	public static void main(String args[]) {
		/*int m = 4;
		int n = 4;*/
		int[][] input = { { 1, 0, 1, 1 }, { 0, 0, 1,1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };// new
		//int[][] input2 = {{0}};
		int number = findClusters(input);
		System.out.println(number);
	}

	private static int findClusters(int[][] input) {

		int r = 0;
		int c = 0;
		int m = input.length;
		int n=input[0].length;
		int cluster = 0;
		for (r = 0; r < m; r++) {
			for (c = 0; c < n; c++) {
				if (input[r][c] == 1) {

					cluster = cluster + 1;
					input[r][c] = 0;
					input = process(r, c, input);

				}
			}
		}
		
		

		return cluster;
	}

	private static int[][] process(int r, int c, int[][] input) {
		int m = input.length;
		int n = input[0].length;
		if (r > 0 && c > 0) {

			if (input[r - 1][c - 1] == 1) {

				input[r - 1][c - 1] = 0;
				input = process(r - 1, c - 1, input);
			}
		}

		if (r < m - 1 && c < n - 1) {

			if (input[r + 1][c + 1] == 1) {
				input[r + 1][c + 1] = 0;
				input = process(r + 1, c + 1, input);
			}
		}

		if (r < m - 1 && c > 0) {

			if (input[r + 1][c - 1] == 1) {
				input[r + 1][c - 1] = 0;
				input = process(r + 1, c - 1, input);
			}

		}

		if (r > 0 && c < n - 1) {
			if (input[r - 1][c + 1] == 1) {
				input[r - 1][c + 1] = 0;
				input = process(r - 1, c + 1, input);
			}

		}

		if (c < n - 1) {

			if (input[r][c + 1] == 1) {
				input[r][c + 1] = 0;
				input = process(r, c + 1, input);
			}
		}

		if (r < m - 1) {

			if (input[r + 1][c] == 1) {
				input[r + 1][c] = 0;
				input = process(r + 1, c, input);
			}

		}

		if (c > 0) {

			if (input[r][c - 1] == 1) {
				input[r][c - 1] = 0;
				input = process(r, c - 1, input);
			}

		}

		if (r > 0) {

			if (input[r - 1][c] == 1) {
				input[r - 1][c] = 0;
				input = process(r - 1, c, input);
			}

		}
		return input;

	}

}
