package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.OrgaoDAO;
import br.com.fiap.dao.impl.OrgaoDaoImpl;
import br.com.fiap.entity.Doador;
import br.com.fiap.entity.Instituicao;
import br.com.fiap.entity.Orgao;
import br.com.fiap.entity.Receptor;
import br.com.fiap.entity.TipoSanguineo;
import br.com.fiap.entity.Transplante;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TestCadastrar {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		OrgaoDAO dao = new OrgaoDaoImpl(em);
		
		Orgao orgao = new Orgao("Coracao", 4, true);
		
		Endereco endereco = new Endereco();
		
		Doador doador = new Doador("Abrelincon", 
				new GregorianCalendar(1980, Calendar.JUNE, 19),
				TipoSanguineo.AB_POSITIVO, false, 79);
		
		Receptor receptor = new Receptor("Maria", 
				new GregorianCalendar(1990, Calendar.JANUARY, 8),
				TipoSanguineo.AB_POSITIVO, 70);
		
		Transplante transplante = 
				new Transplante(Calendar.getInstance(), orgao, receptor);
		
		orgao.setDoador(doador);
		orgao.setTransplante(transplante);
		
		Instituicao instituicao = new Instituicao("Albert Einstein");
		List<Instituicao> lista = new ArrayList<Instituicao>();
		lista.add(instituicao);
		
		receptor.setInstituicoes(lista);
		doador.setInstituicoes(lista);
		
		
		try {
			dao.cadastrar(orgao);
			dao.commit();
			System.out.println("Cadastrado com Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro, ocorreu algum problema no cadastro!");
		}
		
		em.close();
		fabrica.close();
	}

}
