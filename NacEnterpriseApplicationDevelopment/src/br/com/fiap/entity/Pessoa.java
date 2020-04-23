package br.com.fiap.entity;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name = "pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
public class Pessoa {
	
	//ATRIBUTOS
	@Id
	@Column(name="cod_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nasc")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tp_sanguineo")
	private TipoSanguineo tipoSanguineo;
	
	@Column(name = "peso")
	private float peso;
	
	@Column(name = "cpf_recpt")
	private double cpfReceptor;
	
	@Column(name = "rg_recept")
	private String rgReceptor;
	
	@Column(name = "sexo")
	private String sexo;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_end")
	private Endereco endereco;

	
	//CONSTRUTORES
	public Pessoa() {
		super();
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public double getCpfReceptor() {
		return cpfReceptor;
	}
	public void setCpfReceptor(double cpfReceptor) {
		this.cpfReceptor = cpfReceptor;
	}
	public String getRgReceptor() {
		return rgReceptor;
	}
	public void setRgReceptor(String rgReceptor) {
		this.rgReceptor = rgReceptor;
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