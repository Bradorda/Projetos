package DSBD.model;

import java.time.LocalDate;

public class Venda {
	
	
	private String numeroNF;
	private String cliente;
	private String produto;
	private int quantidade;
	private double valor;
	private LocalDate data;
	
	public Venda(String numeroNF, String cliente, String produto, int quantidade, double valor, LocalDate data) {
		this.numeroNF = numeroNF;
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.data = data;
	}
	
	
	public Venda() {
	
	}


	public String getNumeroNF() {
		return numeroNF;
	}


	public void setNumeroNF(String numeroNF) {
		this.numeroNF = numeroNF;
	}


	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}