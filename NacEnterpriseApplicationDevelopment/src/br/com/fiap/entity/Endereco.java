package br.com.fiap.entity;


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

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {
	//CONSTRUTORES
	public Endereco() {
		super();
	}
	
	
	public Endereco(String logradouro, String bairro, String cidade, String uf, String pais, String cep) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.cep = cep;
	}

	//ATRIBUTOS
	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "logradouro", length = 100)
	private String logradouro;
	
	@Column(name = "bairro", length = 40)
	private String bairro;
	
	@Column(name = "cidade", length = 50)
	private String cidade;
	
	@Column(name = "uf", length=20)
	private String uf;
	
	@Column(name = "pais", length=40)
	private String pais;
	
	@Column(name = "cep", length=10)
	private String cep;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_pessoa", nullable = true, unique = true)
	private Pessoa pessoa;
		
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_instituicao", nullable = true, unique = true)
	private Instituicao instituicao;
	

	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
