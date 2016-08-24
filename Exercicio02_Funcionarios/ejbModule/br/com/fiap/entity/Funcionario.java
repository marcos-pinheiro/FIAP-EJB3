package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.util.IRPF;

@Entity
@Table(schema = "exercicio02_funcionarios", name = "funcionario")
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cpf;
	private String nome;
	private String cargo;
	private double salario;
	private double irpf;
	private double inss;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
		calcularINSS();
		calcularIRPF();
	}

	public double getIrpf() {
		return irpf;
	}

	public double getInss() {
		return inss;
	}
	
	private void calcularINSS() {
		this.inss = salario * 0.10;
	}
	
	private void calcularIRPF() {
		this.irpf = IRPF.calcular(salario - inss);
	}
	
	private static final long serialVersionUID = 1L;
}
