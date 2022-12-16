package PoliciasYLadrones;

public class PoliciasYLadrones {

	public static void main(String[] args) {
		String[] vector = { "p", "l", "p", "p", "p", "p", "l", "l", "p" };
		int k = 2;
		System.out.println(capturas(vector, k));
	}

	public static int capturas(String[] arr, int k) {
		int pol = -1, thi = -1, res = 0, n=arr.length;
		 
        for (int i = 0; i < n; i++) {
            if (arr[i] == "p") {
                pol = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == "l") {
                thi = i;
                break;
            }
        }

        if (thi == -1 || pol == -1)
            return 0;
        
        while (pol < n && thi < n) {
 
            if (Math.abs(pol - thi) <= k) {
                pol++;
                while (pol < n && arr[pol] != "p") {
                    pol++;
                }
                thi++;
                while (thi < n && arr[thi] != "l") {
                    thi++;
                }
                res++;
            }
 
            else if (thi < pol) {
                thi++;
                while (thi < n && arr[thi] != "l") {
                    thi++;
                }
            }
            else {
                pol++;
                while (pol < n && arr[pol] != "p") {
                    pol++;
                }
            }
        }
        return res;
	}
}
