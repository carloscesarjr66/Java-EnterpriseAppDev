package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.impl.ReceptorDaoImpl;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Instituicao;
import br.com.fiap.entity.Orgao;
import br.com.fiap.entity.Receptor;
import br.com.fiap.entity.TipoSanguineo;
import br.com.fiap.entity.Transplante;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.KeyNotFoundException;

public class ReceptorDaoTest {

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
				endereco, "11856759874", "marcio.correia@gmail.com", transplante, instituicoes);
		daoReceptor.cadastrar(receptor);
		
		try {
			daoReceptor.commit();
		} catch (CommitException e) {
			fail("Falha no cadastro do receptor");
		}
	}

	
	@Test
	@DisplayName("Atualização das informações do receptor")
	public void atualizaSucessoTest() {
		System.out.println("receptor" + receptor.getNome());
		receptor.setPeso(75.2);
		receptor.setNome("Lucas da Silva");
		
		daoReceptor.atualizar(receptor);
		try {
			daoReceptor.commit();
		} catch (CommitException e) {
			fail("Falha no commit");
		}
		
		try {
			Receptor busca = daoReceptor.pesquisar(receptor.getCodigo());
			assertEquals("Lucas da Silva", busca.getNome());
			
		} catch (KeyNotFoundException e) {
			fail("Doador não existe no banco");
		}
	}
	
	@Test
	@DisplayName("Pesquisa de receptor")
	public void buscaSucessoTest() {
	
		try {			
			Receptor busca = daoReceptor.pesquisar(receptor.getCodigo());
			assertEquals("Marcio Correia", busca.getNome());
		} catch (KeyNotFoundException e) {
			fail("Receptor não existe no banco");
		}
	}
	
	@Test
	@DisplayName("Cadastro de receptor com sucesso")
	public void cadastroSucessoTest() {
		assertNotEquals(0, receptor.getCodigo());
	}
	
	
	@Test
	@DisplayName("Remover um receptor")
	public void deletaSucessoTest() {
		try {
			daoReceptor.deletar(receptor.getCodigo());
			daoReceptor.commit();
		} catch (KeyNotFoundException | CommitException e) {
			fail("Falha no commit");
		}
		assertThrows(KeyNotFoundException.class, () -> { daoReceptor.pesquisar(receptor.getCodigo()); });
	}

}
