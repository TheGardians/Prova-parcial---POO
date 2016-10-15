package controllers;

public class Empregado {
	
	private double salarioLiquido;
	private double comissao;
	
	public Empregado(double salarioLiquido, double comissao) {
		super();
		this.salarioLiquido = salarioLiquido;
		this.comissao = comissao;
	}

	public double getSalarioLiquido() { 	
		return this.salarioLiquido;
	}

	public double getComissao() { 
		return this.comissao;
	}
}
