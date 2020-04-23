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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	
	@ManyToMany(mappedBy = "instituicao")
	private List<Receptor>receptores=new ArrayList<Receptor>();
	
	@OneToOne(mappedBy = "instituicao", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@ManyToMany(mappedBy = "instituicao")
	private List<Doador>doadores=new ArrayList<Doador>();
	
	
	//CONSTRUTORES
	public Instituicao() {
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
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
