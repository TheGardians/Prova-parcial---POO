package controllers;

import java.util.ArrayList;
import java.util.List;

import exceptions.ContratacaoNaoPermitida;
import exceptions.DivisaoPorZero;

public class Empresa {
	private String nome;
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Empresa(String nome) {
		super();
		this.nome = nome;
	}
	
	public void fazerPagamentoFuncionarios(){
		for(Funcionario funcionario : funcionarios){
			funcionario.receberSalario();
			if(funcionario instanceof Terceirizado){
				((Terceirizado) funcionario).receberVale();
			}
		}
	}
	public void adimitirFuncionario(Funcionario f) throws DivisaoPorZero, ContratacaoNaoPermitida{
		
		if(f instanceof Terceirizado){
			float totalFuncionarios = funcionarios.size();
			float totalTercerizados = 0;
			for(Funcionario funcionario : funcionarios){
				if(funcionario instanceof Terceirizado){
					totalTercerizados++;
				}
			}
			if(totalFuncionarios == 0){
				throw new DivisaoPorZero();
			}
			float porcetagemTerceirizados = (totalTercerizados+1)/(totalFuncionarios+1);	
			if(porcetagemTerceirizados > 0.3F){
				throw new ContratacaoNaoPermitida();
			}
			funcionarios.add(f);
			System.out.println("Terceirazado "+f.getNome()+" contratado.");
			
		}else{
			funcionarios.add(f);
			System.out.println("Funcionário "+f.getNome()+" contratado.");
		}
		
	}
	
	public void demitirFuncionario(int matricula){
		Funcionario f = buscarFuncionario(matricula);
		if(f != null){
			funcionarios.remove(f);
			System.out.println("Funcionário "+f.getNome()+" demitido.");
		}else{
			System.out.println("Funcionário não encontrado com a matrícula "+matricula+" para demissão.");
		}
	}
	
	private Funcionario buscarFuncionario(int matricula){
		for(Funcionario f : funcionarios){
			if(f.getMatricula() == matricula){
				return f;
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
