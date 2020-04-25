package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.impl.DoadorDaoImpl;
import br.com.fiap.entity.Doador;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Instituicao;
import br.com.fiap.entity.Orgao;
import br.com.fiap.entity.TipoSanguineo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.KeyNotFoundException;

class DoadorDaoTest {

	static GenericDAO<Doador, Integer> daoDoador;
	static GenericDAO<Endereco, Integer> daoEndereco;
	
	Doador doador;
	Endereco endereco;
	List<Instituicao> instituicoes;
	List<Orgao>orgaos;
	
	@BeforeAll
	static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		daoDoador = new DoadorDaoImpl(em);
	}
	
	@BeforeEach 
	void cadastrar() {
		doador = new Doador("Marco da Silva", 
				new GregorianCalendar(1980, 6, 27), 
				TipoSanguineo.A_POSITIVO,
				80.4, "12345678901", "7890567", "M", 
				endereco,
				(char) 0, instituicoes, orgaos);
		daoDoador.cadastrar(doador);
		try {
			daoDoador.commit();
		} catch (CommitException e) {
			fail("Falha no cadastro do doador");
		}
	}
	
	@Test
	@DisplayName("Remover um doador")
	void deletaSucessoTest() {
		try {
			daoDoador.deletar(doador.getCodigo());
			daoDoador.commit();
		} catch (KeyNotFoundException | CommitException e) {
			fail("Falha no commit");
		}
		assertThrows(KeyNotFoundException.class, () -> { daoDoador.pesquisar(doador.getCodigo()); });
	}
	
	@Test
	@DisplayName("Atualização das informações do doador")
	void atualizaSucessoTest() {
		doador.setPeso(78.2);
		doador.setNome("Mario da Silva");
		
		daoDoador.atualizar(doador);
		try {
			daoDoador.commit();
		} catch (CommitException e) {
			fail("Falha no commit");
		}
		
		try {
			Doador busca = daoDoador.pesquisar(doador.getCodigo());
			
			assertEquals(78.2, busca.getPeso());
			assertEquals("Mario da Silva", busca.getNome());
			
		} catch (KeyNotFoundException e) {
			fail("Doador não existe no banco");
		}
	}
	
	@Test
	@DisplayName("Pesquisa de doador")
	void buscaSucessoTest() {
		try {
			Doador busca = daoDoador.pesquisar(doador.getCodigo());
			assertEquals("Marco da Silva", busca.getNome());
		} catch (KeyNotFoundException e) {
			fail("Doador não existe no banco");
		}
	}
	
	@Test
	@DisplayName("Cadastro de doador com sucesso")
	void cadastroSucessoTest() {
		assertNotEquals(0, doador.getCodigo());
	}

}

