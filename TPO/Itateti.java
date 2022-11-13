
public interface Itateti {
	public void inicializarPartida();
	public void turno(boolean maquinaPrimero);
	public void jugar(int row, int col);
	public void imprimirMatriz();
	public boolean posicionValida(int row, int col);
}
