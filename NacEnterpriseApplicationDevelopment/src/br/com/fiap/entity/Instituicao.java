package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "SQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao {
	
	//CONSTRUTORES
	public Instituicao() {
		super();
	}
	
	
	public Instituicao(String nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	
	//ATRIBUTOS
	@Id
	@Column(name="cd_instituicao")
	@GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_instituicao")
	private String nome;
	
	@OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<Receptor>receptores=new ArrayList<Receptor>();	
	
	@OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<Doador>doadores=new ArrayList<Doador>();
	
	@OneToOne(mappedBy = "instituicao", cascade = CascadeType.ALL)
	private Endereco endereco;
	


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
	public Endereco getEnderecos() {
		return endereco;
	}
	public void setEnderecos(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Doador> getDoadores() {
		return doadores;
	}

	public void setDoadores(List<Doador> doadores) {
		this.doadores = doadores;
	}

	public List<Receptor> getReceptores() {
		return receptores;
	}

	public void setReceptores(List<Receptor> receptores) {
		this.receptores = receptores;
	}

}
