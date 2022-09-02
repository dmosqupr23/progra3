package DivideAndConquer;

public class mergeMultiple {

	public static void main(String[] args) {

		int[] arr1 = new int[] { 1, 3, 5, 7, 9, 11, 13 };
		int[] arr2 = new int[] { 2, 4, 6, 8, 10, 12, 14 };
		int[] arr3 = new int[30];

		MergeArrays(arr1, arr2, arr3, 0, 0, arr1.length, arr2.length, 0);

		int k = 0;
		while (arr3[k] != 0) {
			System.out.print(arr3[k] + " ");
			k++;
		}
	}

	public static void MergeArrays(int[] arr1, int[] arr2, int[] arr3, int ini1, int ini2, int fin1, int fin2,
			int ind3) {
		if ((ini1 < fin1) && (ini2 < fin2)) {
			if (arr1[ini1] <= arr2[ini2]) {
				arr3[ind3] = arr1[ini1];
				ini1++;
			} else {
				arr3[ind3] = arr2[ini2];
				ini2++;
			}
			ind3++;
			MergeArrays(arr1, arr2, arr3, ini1, ini2, fin1, fin2, ind3);
		} else {
			while (ini1 < fin1) {
				arr3[ind3] = arr1[ini1];
				ini1++;
				ind3++;
			}
			while (ini2 < fin2) {
				arr3[ind3] = arr2[ini2];
				ini2++;
				ind3++;
			}
		}
	}
}
