package br.com.fiap.entity;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name = "pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DS_TIPO")
@DiscriminatorValue("Pessoa")
public class Pessoa {
	
	
	//ATRIBUTOS
	
	@Id
	@Column(name="cod_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	protected int codigo;
	
	@Column(name = "nome")
	protected String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nasc")
	protected Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tp_sanguineo")
	protected TipoSanguineo tipoSanguineo;
	
	@Column(name = "peso")
	protected double peso;
	
	@Column(name = "cpf")
	protected String cpf;
	
	@Column(name = "rg")
	protected String rg;
	
	@Column(name = "sexo")
	protected String sexo;
	
	@OneToOne(mappedBy = "endereco",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_end")
	protected Endereco endereco;

	
	//CONSTRUTORES
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpf,
			String rg, String sexo, Endereco endereco) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoSanguineo = tipoSanguineo;
		this.peso = peso;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.endereco = endereco;
	}
	
	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getData_nascimento() {
		return dataNascimento;
	}
	public void setData_nascimento(Calendar data_nascimento) {
		this.dataNascimento = data_nascimento;
	}
	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}