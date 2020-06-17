package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Conta;
import modelo.excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta");
		
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Cliente: ");
		String cliente = sc.nextLine();
		
		System.out.print("Saldo Inicial: ");
		double saldoInicial = sc.nextDouble();
		
		System.out.print("Limite para Saques: ");
		double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, cliente, saldoInicial, limiteSaque);
		
		System.out.println();
		System.out.print("Entre o valor para Saque: ");
		double valorSaque = sc.nextDouble();
		try {
		conta.saque(valorSaque);
		}
		catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		
		
	}

}
