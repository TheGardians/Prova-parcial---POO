package controllers;

import java.util.ArrayList;
import java.util.List;

import exceptions.ContratacaoNaoPermitida;
import exceptions.DivisaoPorZero;

public class Empresa {

	// porcertagem mínima de funcionários na empresa
	private final float PORCENTAGEM_MINIMA_FUNCIONARIOS = 0.3F;

	private String nome;

	private List<Funcionario> funcionarios;

	public Empresa(String nome) {
		setNome(nome);
		setFuncionarios(new ArrayList<>());
	}

	public void fazerPagamentoFuncionarios() {
		for (Funcionario funcionario : getFuncionarios()) {
			funcionario.receberSalario();
			if (funcionario instanceof Terceirizado) {
				((Terceirizado) funcionario).receberVale();
			}
		}
	}

	private float quantidadeTerceirizados() {
		float total = 0;
		for (Funcionario funcionario : getFuncionarios()) {
			if (funcionario instanceof Terceirizado) {
				total++;
			}
		}
		return total;
	}

	public void adimitirFuncionario(Funcionario funcionario) throws DivisaoPorZero, ContratacaoNaoPermitida {
		if (funcionario instanceof Terceirizado) {
			float totalFuncionarios = getFuncionarios().size();
			float totalTercerizados = quantidadeTerceirizados();

			if (totalFuncionarios == 0) {
				throw new DivisaoPorZero();
			}

			float porcetagemTerceirizados = (totalTercerizados + 1) / (totalFuncionarios + 1);

			if (porcetagemTerceirizados > PORCENTAGEM_MINIMA_FUNCIONARIOS) {
				throw new ContratacaoNaoPermitida();
			}

			getFuncionarios().add(funcionario);
			System.out.println("Terceirazado " + funcionario.getNome() + " contratado.");
			
		} else {
			funcionarios.add(funcionario);
			System.out.println("Funcionário " + funcionario.getNome() + " contratado.");
		}
	}

	public void demitirFuncionario(int matricula) {
		Funcionario funcionario = buscarFuncionario(matricula);
		if (funcionario != null) {
			getFuncionarios().remove(funcionario);
			System.out.println("Funcionário " + funcionario.getNome() + " demitido.");
		} else {
			System.out.println("Funcionário com a matrícula " + matricula + " não encontrado para demissão.");
		}
	}

	private Funcionario buscarFuncionario(int matricula) {
		for (Funcionario funcionario : getFuncionarios()) {
			if (funcionario.getMatricula() == matricula) {
				return funcionario;
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