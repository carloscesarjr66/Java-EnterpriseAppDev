package br.com.fiap.entity;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_RECEPTOR")
@SequenceGenerator(name = "receptor", sequenceName = "SQ_TB_RECEPTOR", allocationSize = 1)
@DiscriminatorValue(value="R")
public class Receptor extends Pessoa {	
	//CONSTRUTORES
	public Receptor() {
		super();
	}
	
	public Receptor(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpf,
			String rg, Genero genero, Endereco endereco, String telefone, String email, 
			Instituicao instituicao) {
		super(nome, dataNascimento, tipoSanguineo, peso, cpf, rg, genero, endereco);
		this.telefone = telefone;
		this.email = email;
		this.instituicao = instituicao;
	}
	
	
	//ATRIBUTOS
	@Id
	@Column(name="cd_receptor")
	@GeneratedValue(generator = "receptor", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "email")
	private String email;
	
	@OneToOne(mappedBy = "receptor",cascade = CascadeType.ALL)
	private Transplante transplante;
	
	@ManyToOne(cascade =  { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_instituicao", nullable = false)
	private Instituicao instituicao;
	


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
	public Instituicao getInstituicoes() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
