package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="TB_ORGAO")
@SequenceGenerator(name = "orgao", sequenceName = "SQ_TB_ORGAO", allocationSize = 1)
public class Orgao {

	//CONSTRUTORES
	public Orgao() {
		super();
	}
		
	public Orgao(String nome, int isquemia, boolean stVital) {
		super();
		this.nome = nome;
		this.isquemia = isquemia;
		this.stVital = stVital;
	}

	//ATRIBUTOS
	@Id
	@Column(name="cd_orgao")
	@GeneratedValue(generator = "orgao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_orgao")
	private String nome;
	@Column(name = "ds_isquemia")
	private int isquemia;
	@Column(name = "st_vital")
	private boolean stVital;

	@OneToOne(mappedBy = "orgao", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Transplante transplante;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_doador", nullable = false)
	private Doador doador;
	
		
	
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
	public int getIsquemia() {
		return isquemia;
	}
	public void setIsquemia(int isquemia) {
		this.isquemia = isquemia;
	}
	public boolean isStVital() {
		return stVital;
	}
	public void setStVital(boolean stVital) {
		this.stVital = stVital;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Transplante getTransplante() {
		return transplante;
	}

	public void setTransplante(Transplante transplante) {
		this.transplante = transplante;
	}
	
}
