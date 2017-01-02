package arrays;

public class DiamondCollectionProblem {
	static // int[][] mat = new int[3][3];
	int r = 3;
	static int c = 3;
	static int[][] mat = { { 0, -1, 1 }, { 1, 0, 0 }, { 1, 0, 1 } };

	public static void main(String args[]) {
		int a = collectmax();
		System.out.println(a);

	}

	private static int collectmax() {

		// top first to last
		int i = 0;
		int j = 0;
		int collection = 0;
		int[][] temp = mat;
		int max = 0;
		if(mat[0][0] == -1 || mat[r-1][c-1] == -1)
		{
			System.out.println("solution not possible");
			return collection;
		}
		while (i != (r - 1) || j != (c - 1)) {
			
			if (i == r - 1 && j < c - 1) {
				max = temp[i][j + 1];
				if (max == -1) {
					System.out.println("no path forward terminated without completion");
					return collection;
				}
				j = j + 1;
				if (temp[i][j] == 1) {
					temp[i][j] =temp[i][j]- 1;
					collection =collection+ 1;
				}
			} else if (j == c - 1 && i < r - 1) {
				max = temp[i + 1][j];
				if (max == -1) {
					System.out.println("no path forward terminated without completion");
					return collection;
				}
				i = i + 1;
				if (temp[i][j] == 1) {
					temp[i][j] =temp[i][j]- 1;
					collection =collection+ 1;
				}

			} else {
				max = Math.max( temp[i + 1][j],temp[i][j + 1]);
				boolean bool = false;
				if (max == temp[i+1][j] && max != -1) {
					i = i + 1;
					if (temp[i][j] == 1) {
						temp[i][j] =temp[i][j]- 1;
						collection =collection+ 1;
					   bool = true;
					}
				} else if (max == temp[i][j+1] && max != -1 && bool ==false) {
					j = j + 1;
					if (temp[i][j] == 1) {
						temp[i][j] =temp[i][j]- 1;
						collection =collection+ 1;
					}
				} else if (max == -1) {
					System.out.println("no path forward terminated without completion");
					return collection;
				}

			}
		}
			i = r - 1;
			j = c - 1;
			while (i != 0 || j != 0) {

				if (i == 0 && j > 0) {
					max = temp[i][j - 1];
					if (max == -1) {
						System.out.println("no path forward terminated without completion");
						return collection;
					}
					j = j - 1;
					if (temp[i][j] == 1) {
						temp[i][j] =temp[i][j]- 1;
						collection =collection+ 1;
					}
				} else if (j == 0 && i > 0) {
					max = temp[i - 1][j];
					if (max == -1) {
						System.out.println("no path forward terminated without completion");
						return collection;
					}
					i = i - 1;
					if (temp[i][j] == 1) {
						temp[i][j] =temp[i][j]- 1;
						collection =collection+ 1;
					}

				} else {
					max = Math.max(temp[i][j - 1], temp[i - 1][j]);
					boolean bool = false;
					if (max == temp[i][j-1] && max != -1) {
						j = j -1;
						if (temp[i][j] == 1) {
							temp[i][j] =temp[i][j]- 1;
							collection =collection+ 1;
						}
						bool = true;
					} else if (max == temp[i-1][j] && max != -1 && !bool) {
						i = i - 1;
						if (temp[i][j] == 1) {
							temp[i][j] =temp[i][j]- 1;
							collection =collection+ 1;
						}
					} else if (max == -1) {
						System.out.println("no path forward terminated without completion");
						return collection;
					}

				}

			}

		

		// while (i != 0 && j != 0) {

		return collection;
	}

}
