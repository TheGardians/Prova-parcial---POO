package controllers;

public class Terceirizado extends Funcionario{
	private String nomeEmpresaOrigem;
	
	public void receberVale(){
		System.out.println("Funcionário terceirizado recebeu o vale.");
	}
	public Terceirizado(int matricula, String nome, String empresaTerceirizada) {
		super(matricula, nome);
		this.nomeEmpresaOrigem = empresaTerceirizada;
	}
	public String getNomeEmpresaOrigem() {
		return nomeEmpresaOrigem;
	}
	public void setNomeEmpresaOrigem(String nomeEmpresaOrigem) {
		this.nomeEmpresaOrigem = nomeEmpresaOrigem;
	}
	
	
}
