package DivideAndConquer;

import java.util.ArrayList;

public class PicosDeUnVector {

	public static void main(String[] args) {

		ArrayList<Integer> lista1 = new ArrayList<>();
		lista1.add(0);
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista1.add(5);
		lista1.add(1);
		lista1.add(0);

		// System.out.println(ElementoMenor(lista1, 0, lista1.size()-1));
		System.out.println(ElementoMenorDYC(lista1, 0, lista1.size()));
	}

	public static int ElementoMenor(ArrayList<Integer> lista, int ini, int fin) {
		if (lista.get(ini) > lista.get(ini + 1)) {
			return lista.get(ini);
		} else if (lista.get(fin) > lista.get(fin - 1)) {
			return lista.get(fin);
		} else {
			return ElementoMenor(lista, ini + 1, fin - 1);
		}
	}

	public static int ElementoMenorDYC(ArrayList<Integer> lista, int ini, int fin) {
		if (ini == fin)
			return ini;
		int mid = (ini + fin)/2;
		if(lista.get(mid) > lista.get(mid+1)) {
			return ElementoMenorDYC(lista, ini, mid);
		}
		return ElementoMenorDYC(lista, mid+1, fin);
	}
}
