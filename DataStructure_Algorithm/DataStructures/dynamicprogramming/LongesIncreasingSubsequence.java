package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LongesIncreasingSubsequence {

	public static int LCS(int[] arr) {
		int[] LCSArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i - 1 < 0) {
				LCSArr[i] = 1;

			} else {
				for (int j = i - 1; j > 0; j--) {
					if (arr[i] >= arr[j]) {
						LCSArr[i] = Math.max(LCSArr[i], LCSArr[j] + 1);
					}
				}
			}

		}

		int max = 0;
		for (int k = 0; k < arr.length; k++) {
			max = Math.max(max, LCSArr[k]);
		}

		return max;

	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            {
              arr[i] = Integer.parseInt(reader.readLine());
        }

		
		System.out.println(LCS(arr));
	}

}
