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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
@DiscriminatorValue(value="D")
public class Doador extends Pessoa {
	public Doador(String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo, double peso, String cpfReceptor,
			String rgReceptor, String sexo, Endereco endereco, char stVivo, List<Instituicao> instituicao,
			List<Orgao> orgaos) {
		super(nome, dataNascimento, tipoSanguineo, peso, cpfReceptor, rgReceptor, sexo, endereco);
		this.stVivo = stVivo;
		this.instituicao = instituicao;
		this.orgaos = orgaos;
	}

	//ATRIBUTOS
	@Id
	@Column(name="cod_doador")
	@GeneratedValue(generator = "doador", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="st_vivo")
	private char stVivo; 
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
		@JoinTable(name="TB_INSTITUICAO_DOADOR",
				joinColumns = @JoinColumn(name="cod_doador"),
				inverseJoinColumns = @JoinColumn(name="cod_instituicao"))
	private List<Instituicao> instituicao;
	
	@OneToMany(mappedBy="doador",cascade = CascadeType.PERSIST)
	private List<Orgao> orgaos=new ArrayList<Orgao>();
	
	public void addOrgao(Orgao orgao) {
		orgaos.add(orgao);
		orgao.setDoador(this);
	}
	
	//CONSTRUTORES
	public Doador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public char getStVivo() {
		return stVivo;
	}
	public void setStVivo(char stVivo) {
		this.stVivo = stVivo;
	}



	public List<Instituicao> getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}



	
	
}
