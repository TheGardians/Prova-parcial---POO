package program;

import controllers.Empresa;
import controllers.Funcionario;
import controllers.Terceirizado;
import exceptions.ContratacaoNaoPermitida;
import exceptions.DivisaoPorZero;

public class Program {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(111, "Everton");
		Funcionario f2 = new Funcionario(222, "Elisson");
		Funcionario f3 = new Funcionario(333, "Jackson");
		Funcionario f4 = new Funcionario(444, "Joãozinho");
		Funcionario f5 = new Funcionario(555, "Dentista");
		Funcionario f6 = new Funcionario(666, "Quem");
		Funcionario f7 = new Funcionario(777, "Funcionario");
		Funcionario t1 = new Terceirizado(11, "Roger", "IBM");
		Funcionario t2 = new Terceirizado(22, "Maria", "IBM");
		Funcionario t3 = new Terceirizado(333, "Zezinho", "Microsoft");

		Empresa google = new Empresa("Google");

		try {
			google.adimitirFuncionario(f1);
			google.adimitirFuncionario(f2);
			google.adimitirFuncionario(f3);
			google.adimitirFuncionario(f4);
			google.adimitirFuncionario(f5);
			google.adimitirFuncionario(t1);
			google.adimitirFuncionario(t2);
			google.adimitirFuncionario(f6);
			google.adimitirFuncionario(f7);
			google.adimitirFuncionario(t3);
		} catch(DivisaoPorZero e) {
			System.out.println("Adimitir primeiro os Funcionário depois os terceirizados.");
		} catch(ContratacaoNaoPermitida e1) {
			System.out.println("Estamos no limite de Funcionários terceirizados. Podemos contratar apenas 30% de terceirizados em nossa empresa.");
			System.out.println(" você não pode ser contratado no momento");
		}
		System.out.println(google.getFuncionarios());
	}
}