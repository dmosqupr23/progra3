package DivideAndConquer;

public class itemsOrderedExceptOne {

	public static void main(String[] args) {
		
		int[] lista1 = new int[] {1,2,10,3,4,5,6,7,9};
		System.out.println(func(lista1, 0, lista1.length-1));
	}

	public static int func(int[] arr, int ini, int fin) {
		if(ini==fin)
			return -1;
		
		int mid = (ini+fin)/2;
		if(mid > 0 && arr[mid]<arr[mid-1])
			return arr[mid];
		else if(mid < arr.length && arr[mid]>arr[mid+1])
			return arr[mid];
		
		int val = func(arr, ini, mid);
		if(val == -1)
			val = func(arr, mid+1, fin);
		return val;
	}
}
