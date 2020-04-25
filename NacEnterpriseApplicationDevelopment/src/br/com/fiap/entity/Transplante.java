package br.com.fiap.entity;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	public Transplante(Calendar dataTransplante, List<Orgao> orgaos, List<Receptor> receptores) {
		super();
		this.dataTransplante = dataTransplante;
		this.orgaos = orgaos;
		this.receptores = receptores;
	}

	//ATRIBUTOS
	@Id
	@Column(name="cod_transplante")
	@GeneratedValue(generator = "transplante", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_transplante")
	private Calendar dataTransplante;
	
	@OneToMany(mappedBy = "transplante")
	private List<Orgao> orgaos=new ArrayList<Orgao>();
	
	public void addOrgao(Orgao orgao) {
		orgaos.add(orgao);
		orgao.setTransplante(this);
	}
	
	@OneToMany(mappedBy = "transplante")
	private List<Receptor> receptores=new ArrayList<Receptor>();
	
	public void addReceptor(Receptor receptor) {
		receptores.add(receptor);
		receptor.setTransplante(this);
	}
	
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

	public List<Receptor> getReceptores() {
		return receptores;
	}

	public void setReceptores(List<Receptor> receptores) {
		this.receptores = receptores;
	}


	public List<Orgao> getOrgaos() {
		return orgaos;
	}


	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

}
