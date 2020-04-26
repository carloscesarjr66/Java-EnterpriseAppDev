package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "receptor", sequenceName = "SQ_TB_RECEPTOR", allocationSize = 1)
@DiscriminatorValue(value="R")
public class Receptor extends Pessoa {
	
	
	//ATRIBUTOS
	@Id
	@Column(name="cod_receptor")
	@GeneratedValue(generator = "receptor", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "receptor",cascade = CascadeType.ALL)
	private Transplante transplante;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="TB_INSTITUICAO_RECEPTOR",
	joinColumns = @JoinColumn(name="cod_receptor"),
	inverseJoinColumns = @JoinColumn(name="cod_instituicao"))
	private List<Instituicao>instituicoes=new ArrayList<Instituicao>();
	
	
	
	//CONSTRUTORES
	public Receptor() {
		super();
	}
	
	public Receptor(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpf,
			String rg, String sexo, Endereco endereco, String telefone, String email, Transplante transplante,
			List<Instituicao> instituicoes) {
		super(nome, dataNascimento, tipoSanguineo, peso, cpf, rg, sexo, endereco);
		this.telefone = telefone;
		this.email = email;
		this.transplante = transplante;
		this.instituicoes = instituicoes;
	}
	

	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Transplante getTransplante() {
		return transplante;
	}


	public void setTransplante(Transplante transplante) {
		this.transplante = transplante;
	}
	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
}
