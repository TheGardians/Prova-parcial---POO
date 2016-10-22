package exceptions;

public class NaoMultiploDe3Exception extends Exception {

	private static final long serialVersionUID = -6236197870409765963L;

	private int linha;

	private int coluna;

	public NaoMultiploDe3Exception(int linha, int coluna, String message) {
		super(message);
		setLinha(linha);
		setColuna(coluna);
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}