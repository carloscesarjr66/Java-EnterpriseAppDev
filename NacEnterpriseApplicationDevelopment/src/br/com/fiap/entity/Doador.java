package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_DOADOR")
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
@DiscriminatorValue(value="D")

public class Doador extends Pessoa {

	//CONSTRUTORES
	public Doador() {
		super();
		
	}
	
	public Doador(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpf,
			String rg, Genero genero, boolean stVivo, Endereco endereco) {
		super(nome, dataNascimento, tipoSanguineo, peso, cpf, rg, genero, endereco);
		this.stVivo = stVivo;
	}
	
	//ATRIBUTOS
	@Id
	@Column(name="cd_doador")
	@GeneratedValue(generator = "doador", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="st_vivo")
	private boolean stVivo; 
	
	@ManyToOne(cascade =  { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_instituicao", nullable = false)
	Instituicao instituicao;
	
	@OneToMany(mappedBy="doador",cascade = CascadeType.PERSIST)
	private List<Orgao> orgaos=new ArrayList<Orgao>();
	
	public void addOrgao(Orgao orgao) {
		orgaos.add(orgao);
		orgao.setDoador(this);
	}
	
	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean getStVivo() {
		return stVivo;
	}
	
	public void setStVivo(boolean stVivo) {
		this.stVivo = stVivo;
	}


	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
