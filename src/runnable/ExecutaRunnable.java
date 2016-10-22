package runnable;

import java.util.ArrayList;
import java.util.List;

import controllers.Empregado;

public class ExecutaRunnable implements Runnable {

	private List<Empregado> empregados = new ArrayList<Empregado>();

	@Override
	public void run() {
		int quantidadeFuncionarios = 0;
		for (Empregado empregado : empregados) {
			if (empregado.getComissao() < (empregado.getSalarioLiquido() * 0.2)) {
				quantidadeFuncionarios++;
			}
		}
		System.out.println("Empregados que ganham comissão abaixo 20% do salário líquido: " + quantidadeFuncionarios);
	}

	public void preencherArray(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public static void main(String[] args) {
		Empregado emp = new Empregado(1000, 250);
		Empregado emp2 = new Empregado(2000, 350);
		Empregado emp3 = new Empregado(3000, 650);

		List<Empregado> empList = new ArrayList<Empregado>();
		empList.add(emp);
		empList.add(emp2);
		empList.add(emp3);

		ExecutaRunnable executaRunnable = new ExecutaRunnable();
		executaRunnable.preencherArray(empList);

		executaRunnable.calculaFolhaSalarial();

		Thread thread = new Thread(executaRunnable);
		thread.start();
	}

	private void calculaFolhaSalarial() {
		double salarioTotalEmpresa = 0;
		for (Empregado empregado : empregados) {
			double salarioBruto = empregado.getSalarioLiquido() + empregado.getComissao();
			salarioTotalEmpresa += salarioBruto;
		}
		System.out.println("Folha salarial: " + salarioTotalEmpresa);
	}
}