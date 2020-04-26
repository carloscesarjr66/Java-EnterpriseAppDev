package br.com.fiap.teste;


import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.dao.OrgaoDAO;
import br.com.fiap.dao.ReceptorDAO;
import br.com.fiap.dao.impl.DoadorDaoImpl;
import br.com.fiap.dao.impl.OrgaoDaoImpl;
import br.com.fiap.dao.impl.ReceptorDaoImpl;
import br.com.fiap.entity.Doador;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Instituicao;
import br.com.fiap.entity.Orgao;
import br.com.fiap.entity.Receptor;
import br.com.fiap.entity.TipoSanguineo;
import br.com.fiap.entity.Transplante;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestMainCadastrar {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Endereco enderecoDoador = new Endereco("Rua das Pedras", "Vila Mariana", "São Paulo ", "SP",  "Brasil", "58964700");
		Endereco enderecoReceptor = new Endereco("Rua Pinheiros", "Pinheiros", "São Paulo ", "SP",  "Brasil", "25896540");
		Endereco enderecoInstituicao = new Endereco("Av. Albert Einstein 621", "Jardim Leonor", "São Paulo ", "SP", "Brasil", "05652900");
		
		Instituicao instituicao = new Instituicao("Albert Einstein", enderecoInstituicao);
	
		Doador doador = new Doador("Marcio da Silva", 
				new GregorianCalendar(1980, 3, 19),
				TipoSanguineo.AB_POSITIVO, 80, "23456765432", "561234", Genero.MASCULINO, false, enderecoDoador);

		Orgao orgao = new Orgao("Coracao", 4, true);
		
		Receptor receptor = new Receptor("Roberto Reis", 
				new GregorianCalendar(1990, 9, 8),
				TipoSanguineo.AB_POSITIVO, 80, "87654323456", "765843", Genero.MASCULINO,  enderecoReceptor, "4564336789", "robertoreis@gmail.com", instituicao);
		
		Transplante transplante = 
				new Transplante(Calendar.getInstance(), orgao, receptor);
		
	
		orgao.setDoador(doador);
		orgao.setTransplante(transplante);
		
		doador.setInstituicao(instituicao);
		
		OrgaoDAO daoOrgao = new OrgaoDaoImpl(em);
		ReceptorDAO daoReceptor = new ReceptorDaoImpl(em);
		DoadorDAO daoDoador = new DoadorDaoImpl(em);
	
		try {
			daoOrgao.cadastrar(orgao);
			System.out.println("Orgão cadastrado com Sucesso!");
			daoOrgao.commit();
			daoReceptor.cadastrar(receptor);
			System.out.println("Receptor cadastrado com Sucesso!");
			daoReceptor.commit();
			daoDoador.cadastrar(doador);
			System.out.println("Doador cadastrado com Sucesso!");
			daoDoador.commit();
			
		} catch (CommitException e) {
			System.out.println("Erro, ocorreu algum problema no cadastro!");
		}	
		em.close();
		fabrica.close();
	}

}
