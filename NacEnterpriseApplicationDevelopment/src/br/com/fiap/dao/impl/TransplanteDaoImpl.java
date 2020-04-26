package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TransplanteDAO;
import br.com.fiap.entity.Transplante;

public class TransplanteDaoImpl extends GenericDaoImpl<Transplante, Integer> implements TransplanteDAO {

	public TransplanteDaoImpl(EntityManager em) {
		super(em);
	} 

}
