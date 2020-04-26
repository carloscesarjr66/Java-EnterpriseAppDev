package br.com.fiap.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {
	
	//ATRIBUTOS
	@Id
	@Column(name="cod_end")
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "pais")
	private String pais;
	
	@Column(name = "cep")
	private String cep;
	
	@OneToOne(mappedBy = "endereco")
	private Pessoa pessoa;
		
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Instituicao instituicoes;
	
	
	//CONSTRUTORES
	public Endereco() {
		super();
	}
	
	
	public Endereco(String logradouro, String bairro, String cidade, String uf, String pais, String cep, Pessoa pessoa,
			Instituicao instituicoes) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.cep = cep;
		this.pessoa = pessoa;
		this.instituicoes = instituicoes;
	}


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
		return instituicoes;
	}


	public void setInstituicao(Instituicao instituicoes) {
		this.instituicoes = instituicoes;
	}
	
}
