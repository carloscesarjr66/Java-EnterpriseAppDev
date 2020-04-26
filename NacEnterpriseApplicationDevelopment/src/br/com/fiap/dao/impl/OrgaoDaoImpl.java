package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.OrgaoDAO;
import br.com.fiap.entity.Orgao;

public class OrgaoDaoImpl extends GenericDaoImpl<Orgao, Integer> implements OrgaoDAO {

	public OrgaoDaoImpl(EntityManager em) {
		super(em);
	} 

}
