package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K id) throws KeyNotFoundException;
	
	void deletar (K id) throws KeyNotFoundException;
	
	void commit() throws CommitException;
}
