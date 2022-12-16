import java.util.Scanner;

public class tateti implements Itateti{

	int matrix[][];
	int ganador = -1;
	int opcion;
	int jugador1 = 0;
	int jugador2 = 1;
	Scanner input = new Scanner(System.in);

	@Override
	public void inicializarPartida() {
		this.matrix = new int[3][3];
		for(int i=0 ; i<3; i++) {
			for(int j=0; j<3; j++) {
				matrix[i][j] = -1;
			}
		}
	}
	
	@Override
	public void imprimirMatriz() {
		for(int i=0; i<3; i++) {
			System.out.println("-----------------");
			System.out.print("  ");
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == -1)
					System.out.print(" ");
				else
					System.out.print(this.matrix[i][j]);
				if(j!=2) {
					System.out.print("  |  ");
				}				
	         }
	         System.out.println();
		}
		System.out.println("-----------------");
	}

	@Override
	public void turno(boolean maquinaPrimero) {
		this.jugador1 = 0;
	}

	@Override
	public void jugar(int row, int col) {
		this.matrix[row][col] = 0;
	}

	@Override
	public boolean posicionValida(int row, int col) {
		if(row >= 0 && row < 3 && col >= 0 && col < 3 && this.matrix[row][col] == -1)
			return true;
		else 
			return false;
	}
	
	public void firstMoveComputer(int row, int col) {
		this.matrix[row][col] = jugador2;
	}
	
	public int ganarPartida() {
		// Diagonal \
		if(this.matrix[0][0] != -1 && this.matrix[0][0] == this.matrix[1][1] && this.matrix[0][0] == this.matrix[2][2])
			return this.matrix[0][0];
		// Diagonal /
		if(this.matrix[0][2] != -1 && this.matrix[0][2] == this.matrix[1][1] && this.matrix[0][2] == this.matrix[2][0])
			return this.matrix[0][2];
		// Verticales y Horizontales
		for(int i=0; i<3; i++) {
			if(this.matrix[i][0] != -1 && this.matrix[i][0] == this.matrix[i][1] && this.matrix[i][0] == this.matrix[i][2])
				return this.matrix[i][0];
			if(this.matrix[0][i] != -1 && this.matrix[0][i] == this.matrix[1][i] && this.matrix[0][i] == this.matrix[2][i])
				return this.matrix[0][i];
		}
		return -1;
	}
	
	public boolean tableroCompleto() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == -1)
					return false;
			}
		}
		return true;
	}
	
	public boolean finPartida() {
		if(tableroCompleto() || ganarPartida() != -1) 
			return true;
		return false;
	}
	
	public void movimientoJugador() {
		if(!finPartida()) {
			int row, col;
			do {
				System.out.print("N° de Fila (0-2): ");
				row = input.nextInt();
				System.out.print("N° de Columna (0-2): ");
				col = input.nextInt();
				if(posicionValida(row, col)) {
					jugar(row, col);
					break;
				}
			}while(!posicionValida(row, col));
		}
	}
	
	public void computerMove() {
		if(!finPartida()) {
			int minValue = Integer.MIN_VALUE;
			int aux;
			int mejor_fila = 0;
			int mejor_columna = 0;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(this.matrix[i][j] == -1) {
						this.matrix[i][j] = 1;
						aux = min();
						if(aux > minValue) {
							minValue = aux;
							mejor_fila = i;
							mejor_columna = j;
						}
						this.matrix[i][j] = -1;
					}
				}
			}
			this.matrix[mejor_fila][mejor_columna] = 1;
		}
	}
	
	public int min() {
		if(finPartida())
			return ganarPartida() != -1 ? 1 : 0;
		int maxValue = Integer.MAX_VALUE;
		int aux;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == -1) {
					this.matrix[i][j] = 0;
					aux = max();
					if(aux < maxValue)
						maxValue = aux;
					this.matrix[i][j] = -1;
				}
			}
		}
		return maxValue;
	}
	
	public int max() {
		if(finPartida())
			return ganarPartida() != -1 ? -1 : 0;
		int minValue = Integer.MIN_VALUE;
		int aux;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.matrix[i][j] == -1) {
					this.matrix[i][j] = 1;
					aux = min();
					if(aux > minValue)
						minValue = aux;
					this.matrix[i][j] = -1;
				}
			}
		}
		return minValue;
	}
	
	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
}
