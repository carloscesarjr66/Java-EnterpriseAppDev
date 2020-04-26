package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.InstituicaoDAO;
import br.com.fiap.entity.Instituicao;

public class InstituicaoDaoImpl extends GenericDaoImpl<Instituicao, Integer> implements InstituicaoDAO {

	public InstituicaoDaoImpl(EntityManager em) {
		super(em);
	} 

}
