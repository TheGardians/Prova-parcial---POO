package controllers;

import interfaces.Trabalhor;

public class Funcionario implements Trabalhor {

	private int matricula;

	private String nome;

	public Funcionario(int matricula) {
		setMatricula(matricula);
	}

	public Funcionario(int matricula, String nome) {
		this(matricula);
		setNome(nome);
	}

	@Override
	public void receberSalario() {
		System.out.println("Funcionário " + getNome() + " recebeu o salário.");
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + getMatricula() + ", nome=" + getNome() + "]";
	}
}