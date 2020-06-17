package modelo.entidades;

import modelo.excecoes.DomainException;

public class Conta {

	private Integer numero;
	private String nomeCliente;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numero, String nomeCliente, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void deposito(Double valor) {
		this.saldo += valor;
	}

	public void saque(Double valor) {

		if (getLimiteSaque() < valor) {
			throw new DomainException ("O valor excede o limite para saque");
		} else if (valor > getSaldo()) {
			throw new DomainException("Conta não possui saldo para este saque");
		} else {
			this.saldo -= valor;
			System.out.print(this);
		}
	}

	@Override
	public String toString() {
		return "Novo Saldo: " + String.format("%.2f", getSaldo());
	}
	
}