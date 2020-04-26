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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "SQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao {
	
	//ATRIBUTOS
	@Id
	@Column(name="cod_instituicao")
	@GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_instituicao")
	private String nome;
	
	@ManyToMany(mappedBy = "instituicoes")
	private List<Receptor>receptores=new ArrayList<Receptor>();
	
	
	@ManyToMany(mappedBy = "instituicoes")
	private List<Doador>doadores=new ArrayList<Doador>();
	
	@OneToMany(mappedBy = "enderecos",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cod_end", nullable = false)
	private List<Endereco>enderecos=new ArrayList<Endereco>();
	
	
	//CONSTRUTORES
	public Instituicao() {
		super();
	}
	
	
	public Instituicao(String nome, List<Receptor> receptores, List<Doador> doadores, List<Endereco> enderecos) {
		super();
		this.nome = nome;
		this.receptores = receptores;
		this.doadores = doadores;
		this.enderecos = enderecos;
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
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
