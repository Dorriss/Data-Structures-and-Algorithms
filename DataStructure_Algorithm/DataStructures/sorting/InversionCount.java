package sorting;
import java.util.ArrayList;

public class InversionCount {
	ArrayList<Integer> a = new ArrayList<>();

	public static void main(String argd[]) {
		// ArrayList<Integer> a = new ArrayList<>();

		InversionCount sol = new InversionCount();
		/*sol.a.add(2);
		sol.a.add(4);
		sol.a.add(1);
		sol.a.add(3);
		sol.a.add(5);
		*/
		sol.a.add(59);
		sol.a.add(29);

		sol.countInversions(sol.a);

	}

	public int countInversions(ArrayList<Integer> a) {
		
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < this.a.size(); i++) {
			temp.add(0);
		}
		int count = mergesort(temp, 0, a.size() - 1);
		System.out.println(count);
		return count;

	}

	private int mergesort(ArrayList<Integer> temp, int i, int j) {

		int count = 0;
		int mid = 0;

		
		if (j > i) {

			mid = (i + j) / 2;

			count = mergesort(temp, i, mid);
			count = count + mergesort(temp, mid + 1, j);

			count = count + merge(temp, i, mid, j);
		}
		return count;

	}

	private int merge(ArrayList<Integer> temp, int left, int mid, int right) {

		int inv_count = 0;
		int i = left;
		int k = mid+1;
		int j = right;


		if (left == right)
			return 0;

		while ((i <= mid) && (j <= right)) {
			if (a.get(i) <= a.get(j)) {
				// temp[k++] = arr[i++];
				temp.set(k, a.get(i));
				k++;
				i++;
			} else {
				// temp[k++] = arr[j++];
				temp.set(k, this.a.get(j));
				k++;
				j++;
				inv_count = inv_count + (mid - i);
			}
		}

		/*
		 * Copy the remaining elements of left subarray (if there are any) to
		 * temp
		 */
		while (i <= mid) {
			// temp[k++] = arr[i++];
			temp.set(k, this.a.get(i));
			k++;
			i++;
		}

		/*
		 * Copy the remaining elements of right subarray (if there are any) to
		 * temp
		 */
		while (j <= right) {
			temp.set(k, this.a.get(j));
			k++;
			j++;
			// temp[k++] = arr[j++];
		}

		/* Copy back the merged elements to original array */
		for (i = left; i <= right; i++) {
			// arr[i] = temp[i];

			this.a.set(i, temp.get(j));
		}

		return inv_count;
		// return 0;
	}
}
