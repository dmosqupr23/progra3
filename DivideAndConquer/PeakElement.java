package DivideAndConquer;

import java.util.ArrayList;

public class PeakElement {

	public static void main(String[] args) {

		int[] lista1 = new int[] {7,2,3,4,5,6};

		System.out.println(search(lista1, 0, lista1.length-1));
	}
	
	public static int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
