package DivideAndConquer;

public class indiceIgualElemento {

	public static void main(String[] args) {

		int[] arr = new int[] {0,1,2,3,4,5};
		System.out.println(indexSameElement(arr, 0, arr.length-1));
	}

	public static int indexSameElement(int[] arr, int ini, int fin) {
		if(arr[0] != 0)
			return -1;
		
		int mid = (ini+fin)/2;
		if(arr[mid] == mid)
			return mid;
		else
			return -1;
			
	}
}
