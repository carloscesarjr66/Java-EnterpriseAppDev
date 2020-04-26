package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.entity.Pessoa;

public class PessoaDaoImpl extends GenericDaoImpl<Pessoa, Integer> implements PessoaDAO {

	public PessoaDaoImpl(EntityManager em) {
		super(em);
	}  

}
