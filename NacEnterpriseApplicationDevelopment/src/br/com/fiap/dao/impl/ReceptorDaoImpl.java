package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReceptorDAO;
import br.com.fiap.entity.Receptor;

public class ReceptorDaoImpl extends GenericDaoImpl<Receptor, Integer> implements ReceptorDAO {

	public ReceptorDaoImpl(EntityManager em) {
		super(em);
	}
	
	
}
