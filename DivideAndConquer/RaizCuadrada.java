package DivideAndConquer;

public class RaizCuadrada {

	public static void main(String[] args) {

		//System.out.println(sqrt(18));
		System.out.println(sqrtDYC(9, 0));
	}
	
	public static int sqrt(int x)
    {
        int i = 1;
        while (i*i <= x) {
            i++;
        }
        return i - 1;
    }
	
	public static int sqrtDYC(int x, int cont) {
		if(x==1)
			return cont;
		return sqrtDYC(x/2, cont+1);
	}
}
