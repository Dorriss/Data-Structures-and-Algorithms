package arrays;

public class BalanceLoadAlgo {

	public static void main(String args[]) {
		int[] arr = { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 7, 2, 8 };
		int n = balanceLoad(arr);
		System.out.println(n);
	}

	static int balanceLoad(int[] serverLoads) {
		int n = serverLoads.length;
		int sum = 0;
		int avgload;
		for (int i = 0; i < n; i++) {
			sum = sum + serverLoads[i];
		}
		if (sum % n == 0)
			avgload = sum / n;
		else
			avgload = (sum / n) + 1;

		int iteration = 0;
		int[] newserverload = serverLoads;

		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {

				if (newserverload[j] <= avgload) {
					count++;
				}
			}
			if (count == n)
				return iteration;

			else {
				iteration = iteration + 1;
				for (int j = 0; j < n; j++) {
					if (j == 0) {
						if (newserverload[j] < avgload) {
							newserverload[j] = newserverload[j] + 1;
							newserverload[j + 1] = newserverload[j + 1] - 1;
						} else if (newserverload[j] > avgload) {
							newserverload[j] = newserverload[j] - 1;
							newserverload[j + 1] = newserverload[j + 1] + 1;
						}
					} else if (j == n - 1) {
						if (newserverload[j] < avgload) {
							newserverload[j] = newserverload[j] + 1;
							newserverload[j - 1] = newserverload[j - 1] - 1;
						} else if (newserverload[j] > avgload) {
							newserverload[j] = newserverload[j] - 1;
							newserverload[j - 1] = newserverload[j - 1] + 1;
						}

					} else {
						if (newserverload[j] > avgload) {
							if (newserverload[j - 1] < avgload) {
								newserverload[j] = newserverload[j] - 1;
								newserverload[j - 1] = newserverload[j - 1] + 1;
							}
							if (newserverload[j + 1] < avgload) {
								{
									newserverload[j] = newserverload[j] - 1;
									newserverload[j + 1] = newserverload[j + 1] + 1;
								}

							}

						}

					}

				}
			}

		}
		return iteration;
	}
}
