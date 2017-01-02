package maxsumsubarray;

public class maxsum2Darray {

	public static void Solution() {
		int[][] arr = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } ,{1,3,15,-10,-20}};
		int row = arr.length;
		int col = arr[0].length;
		int max_sum = Integer.MIN_VALUE;
		int max_left, max_right, max_up, max_down;
		int[] temp = new int[col];
		returntype rr = new returntype();
		max_left = 0;
		max_right = col;
		max_up = 0;
		max_down = 0;
		for (int j = 0; j < row; j++) {
			for (int k = 0; k < col; k++) {
				temp[k] = 0;
			}
			for (int i = j; i < row; i++) {
				for (int k = 0; k < col; k++) {
					temp[k] = temp[k] + arr[i][k];
				}
				rr = Solution1D(temp);
				if (rr.getMaxsum() > max_sum) {
					max_left = rr.getLeftindex();
					max_right = rr.getRightindex();
					max_sum = rr.getMaxsum();
					max_down = i;
					max_up = j;
				}

			}
		}

		System.out.println("maximum sum is" + max_sum);
		System.out.println("left index" + max_left);
		System.out.println("right index" + max_right);
		System.out.println("upper index" + max_up);
		System.out.println("bottom index" + max_down);
	}

	public static returntype Solution1D(int[] input) {
		returntype ret = new returntype();
		int sum = 0;
		int max_sum = 0;
		int left_index = 0;

		for (int i = 0; i < input.length; i++) {
			if (sum + input[i] >= 0) {
				sum = sum + input[i];
			} else {
				sum = 0;
				left_index = i + 1;
			}
			if (max_sum < sum) {
				max_sum = Math.max(max_sum, sum);
				ret.setMaxsum(max_sum);
				ret.setLeftindex(left_index);
				ret.setRightindex(i);

			}
		}

		return ret;

	}

	public static void main(String args[]) {
		Solution();
	}

}
