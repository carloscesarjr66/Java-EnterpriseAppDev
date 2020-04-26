package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.entity.Doador;

public class DoadorDaoImpl extends GenericDaoImpl<Doador, Integer> implements DoadorDAO {

	public DoadorDaoImpl(EntityManager em) {
		super(em);
	}

}
