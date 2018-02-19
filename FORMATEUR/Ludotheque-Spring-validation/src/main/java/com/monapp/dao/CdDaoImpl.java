package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.metier.CD;


@Transactional
@Repository
public class CdDaoImpl implements CdDao{

	@PersistenceContext
	EntityManager em;


	@Override
	public List<CD> findAll() {
		String querystring = "SELECT c FROM CD c " ;
		Query query = em.createQuery( querystring ) ;
		List<CD> list = query.getResultList() ;
		return list;
	}

	@Override
	public CD save(CD entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(CD entity) {
		entity = em.merge(entity);
		em.remove(entity);
		
	}

	public CD findByPrimaryKey(Integer id) {
		return em.find(CD.class, id);
	}

	@Override
	public CD update(CD entity) {
		em.merge(entity);
		return null;
	}
}
