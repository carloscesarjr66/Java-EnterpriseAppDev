package br.com.fiap.entity;



import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="TB_TRANSPLANTE")
@SequenceGenerator(name = "transplante", sequenceName = "SQ_TB_TRANSPLANTE", allocationSize = 1)
public class Transplante {
	
	//CONSTRUTORES
	public Transplante() {
		super();
	}
	
	public Transplante(Calendar dataTransplante, Orgao orgao, Receptor receptor) {
		super();
		this.dataTransplante = dataTransplante;
		this.orgao = orgao;
		this.receptor = receptor;
	}
	//ATRIBUTOS
	@Id
	@Column(name="cd_transplante")
	@GeneratedValue(generator = "transplante", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_transplante")
	private Calendar dataTransplante;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_orgao")
	private Orgao orgao;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_receptor")
	private Receptor receptor;
	
	
	//GETTERS E SETTER
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Calendar getDataTransplante() {
		return dataTransplante;
	}
	public void setDataTransplante(Calendar dataTransplante) {
		this.dataTransplante = dataTransplante;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public Orgao getOrgaos() {
		return orgao;
	}

	public void setOrgaos(Orgao orgao) {
		this.orgao = orgao;
	}

}
