package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.monapp.entity.Owner;

@Repository
@Transactional
public class OwnerDaoImpl implements OwnerDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Owner> findAll() {
		String querystring = "SELECT r FROM Owner r " ;
		Query query = em.createQuery( querystring ) ;
		List<Owner> list = query.getResultList() ;
		return list;
	}

	@Override
	public Owner save(Owner entity) {
		em.persist(entity);
		return entity;	}

	@Override
	public void delete(Owner entity) {
		Owner eMerged = em.merge(entity);
		em.remove(eMerged);
	}
	
	@Override
	public Owner findByPrimaryKey(Integer id) {
		return em.find(Owner.class, id);
	}

	@Override
	public Owner update(Owner entity) {
		return em.merge(entity);
	}


}
