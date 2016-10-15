package controllers;
import interfaces.*;

public class Funcionario implements Trabalhor{
	private int matricula;
	private String nome;


	@Override
	public void receberSalario() {
		System.out.println("Funcionário "+this.nome+" recebeu seu salário");
	}
	public Funcionario(int matricula){
		this.matricula = matricula;
	}
	
	public Funcionario(int matricula, String nome) {
		this(matricula);
		this.nome = nome;
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
		return "Funcionario [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
	
}
