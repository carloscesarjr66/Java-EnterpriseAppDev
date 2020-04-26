package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
@DiscriminatorValue(value="D")

public class Doador extends Pessoa {

	//ATRIBUTOS
	@Id
	@Column(name="cod_doador")
	@GeneratedValue(generator = "doador", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="st_vivo")
	private boolean stVivo; 
	
	@ManyToMany(cascade = CascadeType.PERSIST)
		@JoinTable(name="TB_INSTITUICAO_DOADOR",
				joinColumns = @JoinColumn(name="cod_doador"),
				inverseJoinColumns = @JoinColumn(name="cod_instituicao"))
	private List<Instituicao> instituicoes;
	
	@OneToMany(mappedBy="doador",cascade = CascadeType.PERSIST)
	private List<Orgao> orgaos=new ArrayList<Orgao>();
	
	public void addOrgao(Orgao orgao) {
		orgaos.add(orgao);
		orgao.setDoador(this);
	}
	
	//CONSTRUTORES
	public Doador() {
		super();
		
	}
	
		public Doador(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpf,
				String rg, String sexo, boolean stVivo, Endereco endereco) {
			super(nome, dataNascimento, tipoSanguineo, peso, cpf, rg, sexo, endereco);
			this.stVivo = stVivo;
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


	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
}
