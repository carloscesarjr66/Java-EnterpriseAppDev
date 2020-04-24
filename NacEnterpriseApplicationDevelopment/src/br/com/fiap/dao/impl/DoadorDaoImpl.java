package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Doador;

public class DoadorDaoImpl extends GenericDaoImpl<Doador, Integer> implements GenericDAO<Doador, Integer> {

	public DoadorDaoImpl(EntityManager em) {
		super(em);
	}

}
