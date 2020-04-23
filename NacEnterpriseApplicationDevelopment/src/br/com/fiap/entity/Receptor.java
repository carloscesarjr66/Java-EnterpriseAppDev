package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_RECEPTOR")
@SequenceGenerator(name = "receptor", sequenceName = "SQ_TB_RECEPTOR", allocationSize = 1)
public class Receptor extends Pessoa {
	
	//ATRIBUTOS
	@Id
	@Column(name="cod_receptor")
	@GeneratedValue(generator = "receptor", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "email_recept")
	private String email;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_transplante", nullable = false)
	private Transplante transplante;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinTable(name="TB_INSTITUICAO_RECEPTOR",
	joinColumns = @JoinColumn(name="cod_receptor"),
	inverseJoinColumns = @JoinColumn(name="cod_instituicao"))
	private List<Instituicao>instituicoes=new ArrayList<Instituicao>();
	
	//CONSTRUTORES
	public Receptor() {
		super();
		// TODO Auto-generated constructor stub
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
