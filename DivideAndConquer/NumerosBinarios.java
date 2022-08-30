package DivideAndConquer;

import java.util.ArrayList;

public class NumerosBinarios {

	public static void main(String[] args) {

		ArrayList<Integer> elementos = new ArrayList<>();
		elementos.add(0);
		elementos.add(0);
		elementos.add(0);
		elementos.add(1);
		elementos.add(1);
		elementos.add(1);
		elementos.add(1);
		elementos.add(1);

		System.out.println(cantidadUnos(elementos, 0, elementos.size() - 1));
	}

	public static int cantidadUnos(ArrayList<Integer> vector, int ini, int fin) {
		if (vector.get(fin) == 0) 
			return 0;
		if (vector.get(ini) == 1) 
			return fin-ini+1;

		int mid = (ini + fin) / 2;
		
		if(vector.get(mid) == 1) 
			return cantidadUnos(vector, ini, mid) + (fin-mid);
		
		return cantidadUnos(vector, mid+1, fin);
	}
}
