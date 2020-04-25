package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Receptor;

public class ReceptorDaoImpl extends GenericDaoImpl<Receptor, Integer> implements GenericDAO<Receptor, Integer> {

	public ReceptorDaoImpl(EntityManager em) {
		super(em);
	}
	
	
}
