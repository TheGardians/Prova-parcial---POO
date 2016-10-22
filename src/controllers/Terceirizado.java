package controllers;

public class Terceirizado extends Funcionario {

	private String nomeEmpresaOrigem;

	public Terceirizado(int matricula, String nome, String nomeEmpresaOrigem) {
		super(matricula, nome);
		setNomeEmpresaOrigem(nomeEmpresaOrigem);
	}

	public void receberVale(){
		System.out.println("Funcionário " + getNome() + " terceirizado recebeu o vale.");
	}

	public String getNomeEmpresaOrigem() {
		return nomeEmpresaOrigem;
	}

	public void setNomeEmpresaOrigem(String nomeEmpresaOrigem) {
		this.nomeEmpresaOrigem = nomeEmpresaOrigem;
	}
}