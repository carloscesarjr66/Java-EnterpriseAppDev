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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORGAO")
@SequenceGenerator(name = "orgao", sequenceName = "SQ_TB_ORGAO", allocationSize = 1)
public class Orgao {

	//ATRIBUTOS
	@Id
	@Column(name="cod_orgao")
	@GeneratedValue(generator = "orgao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name = "nm_orgao")
	private String nome;
	@Column(name = "ds_isquemia")
	private int isquemia;
	@Column(name = "st_vital")
	private boolean stVital;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="cod_doador")
	private Doador doador;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="cod_transplante",nullable = false)
	private Transplante transplante;
	
	//CONSTRUTORES
	public Orgao() {
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
