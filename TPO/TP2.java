import java.util.Scanner;
import java.util.Random;

public class TP2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		boolean firstMove = true;
		
		tateti matrix = new tateti();
		matrix.inicializarPartida();
		int ganador = -1;
		int opcion = 0;
		do {
			System.out.println("Seleccione 1 si desea jugar primero, o 2 si desea jugar segundo");
			opcion = input.nextInt();
			matrix.setOpcion(opcion);
		}while(opcion != 1 && opcion != 2);
		
		matrix.turno(opcion == 2 ? true : false);
		do {
			if(matrix.getOpcion() == 1) {
				matrix.movimientoJugador();
				matrix.setGanador(matrix.ganarPartida());
				if(matrix.finPartida())
					break;
				matrix.computerMove();
				matrix.setGanador(matrix.ganarPartida());
				if(matrix.finPartida())
					break;
				matrix.imprimirMatriz();
				}
			else {
				if(firstMove) {
					int randomRow = rand.nextInt(3);
					int randomCol = rand.nextInt(3);
					matrix.firstMoveComputer(randomRow, randomCol);
					firstMove = false;
					matrix.imprimirMatriz();
					matrix.movimientoJugador();
					matrix.setGanador(matrix.ganarPartida());
				}
				else {
					matrix.computerMove();
					matrix.setGanador(matrix.ganarPartida());
					if(matrix.finPartida())
						break;
					matrix.imprimirMatriz();
					matrix.movimientoJugador();
					matrix.setGanador(matrix.ganarPartida());
					if(matrix.finPartida())
						break;
				}
			}
		}while(!matrix.finPartida());
		matrix.imprimirMatriz();
		if(matrix.tableroCompleto())
			System.out.println("EMPATE");
		if(matrix.getGanador() == 1)
			System.out.println("Has Perdido");
		if(matrix.getGanador() == 0)
			System.out.println("Has Ganado");	
	}
}
