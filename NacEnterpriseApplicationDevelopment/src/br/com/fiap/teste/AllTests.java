package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.impl.ReceptorDaoImpl;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Instituicao;
import br.com.fiap.entity.Orgao;
import br.com.fiap.entity.Receptor;
import br.com.fiap.entity.TipoSanguineo;
import br.com.fiap.entity.Transplante;
import br.com.fiap.exception.CommitException;

@RunWith(Suite.class)
@SuiteClasses({ ReceptorDaoTest.class, DoadorDaoTest.class })

public class AllTests {
	static GenericDAO<Receptor, Integer> daoReceptor;
	static GenericDAO<Receptor, Integer> daoEndereco;
	
	Receptor receptor;
	List <Receptor> receptores;
	Endereco endereco;
	List<Instituicao> instituicoes;
	List<Orgao> orgaos;
	Transplante transplante = new Transplante(new GregorianCalendar(2019, 7, 20), orgaos, receptores);

	@BeforeAll
	 static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		daoReceptor = new ReceptorDaoImpl(em);
	}
	
	@BeforeEach 
	void cadastrar() {
		receptor = new Receptor("Marcio Correia", 
				new GregorianCalendar(1987, 5, 20), 
				TipoSanguineo.A_POSITIVO,
				74.4, "85698745621", "7458793", "M", 
				endereco,
				 3450, "11856759874", "marcio.correia@gmail.com", transplante, instituicoes);
		daoReceptor.cadastrar(receptor);
		
		try {
			daoReceptor.commit();
		} catch (CommitException e) {
			fail("Falha no cadastro do receptor");
		}
	}
}
