package DivideAndConquer;

public class DesplazoCircular {

	public static void main(String[] args) {
		
		int[] arr = new int[] {35, 42, 5, 15, 27, 29};
		System.out.println(mayorElementoDesplazoCircular(arr, 0, arr.length-1));
		
		int[] arr2 = new int[] {27, 29, 35, 42, 5, 15};
		System.out.println(mayorElementoDesplazoCircular(arr2, 0, arr.length-1));
		
		int[] arr3 = new int[] {1, 3, 5, 6, 7, 15};
		System.out.println(mayorElementoDesplazoCircular(arr3, 0, arr.length-1));
		
		int[] arr4 = new int[] {20, 1, 3, 5, 6, 7, 15};
		System.out.println(mayorElementoDesplazoCircular(arr4, 0, arr.length-1));
	}

	public static int mayorElementoDesplazoCircular(int[] arr, int ini, int fin) {
		if(ini == fin)
			return ini;
		if(arr[fin] > arr[ini])
			return arr[fin];
		if(fin == ini+1)
			if(arr[fin] > arr[ini])
				return arr[fin];
			else
				return arr[ini];
		int mid = (ini+fin)/2;
		
		if(arr[mid] < arr[mid-1])
			return arr[mid-1];
		int val1 =  mayorElementoDesplazoCircular(arr, mid+1, fin);
		int val2 = mayorElementoDesplazoCircular(arr, ini, mid);
		if(val1 > val2)
			return val1;
		else
			return val2;
	}
}

