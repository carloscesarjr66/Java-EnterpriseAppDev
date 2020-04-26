package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.entity.Endereco;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco, Integer> implements EnderecoDAO  {

	public EnderecoDaoImpl(EntityManager em) {
		super(em);
		
	}
	
}
