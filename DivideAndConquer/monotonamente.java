package DivideAndConquer;

public class monotonamente {

	public static void main(String[] args) {
		
		int[] arr = new int[] {3, 22, 27, 47, 57, 67, 89, 91, 95, 99};
		System.out.println(punto_cero(arr, 67, 1));

	}
	
	public static int punto_cero(int[] vectorx, int elemento, int ini) {
		// a = 1 ; b = 2 ; k = 0 --> log(n)
		if(elemento == vectorx[0])
			return 0;
		if(elemento > vectorx[ini])
			return punto_cero(vectorx, elemento, ini*2);
		else
			return busquedaBinaria(vectorx, elemento, ini/2, ini);
	}

	public static int busquedaBinaria(int[] n�meros, int n�mero, int inicio, int fin) {

	    int centro = (inicio + fin) / 2;

	    if (fin < inicio) {
	         return -1;
	    }

	    if (n�mero < n�meros[centro]) {
	        return busquedaBinaria(n�meros, n�mero, inicio, centro - 1);
	    }

	    if (n�mero > n�meros[centro]) {
	        return busquedaBinaria(n�meros, n�mero, centro + 1, fin);
	    }

	    if (n�mero == n�meros[centro]) {
	        return centro;
	    }

	    return -1;
	}
}
