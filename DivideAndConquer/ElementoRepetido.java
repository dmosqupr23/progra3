package DivideAndConquer;

import java.util.ArrayList;

public class ElementoRepetido {

	public static void main(String[] args) {

		ArrayList<Integer> elementos = new ArrayList<>();
		elementos.add(1);
		elementos.add(2);
		elementos.add(3);
		elementos.add(4);
		elementos.add(5);
		elementos.add(6);
		elementos.add(7);
		elementos.add(7);
		elementos.add(8);
		elementos.add(9);
		
		System.out.println(Repetido(elementos, 0, elementos.size()-1));
	}
	
	public static int Repetido(ArrayList<Integer> lista, int ini, int fin) {
		/*
		 * a = 1 ; b = 2 ; k = 0 ---> a = b^k  --> log(n)
		 */
		if(lista.get(ini)-1 == ini && lista.get(fin)-1 == fin) {
			return -1;
		}
		int mid = (ini + fin)/2;
		
		if (lista.get(mid) == mid) {
			return lista.get(mid);
		}
		else {
			if(lista.get(mid)-1 == mid) {
				return Repetido(lista, mid+1, fin);
			}
			else {
				return Repetido(lista, ini, mid);
			}
		}
	}
}
