package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.monapp.entity.CentreEquestre;

@Repository
@Transactional
public class CentreEquestreDaoImpl implements CentreEquestreDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<CentreEquestre> findAll() {
		String querystring = "SELECT c FROM CentreEquestre c " ;
		Query query = em.createQuery( querystring ) ;
		List<CentreEquestre> list = query.getResultList() ;
		return list;
	}

	@Override
	public CentreEquestre save(CentreEquestre entity) {
		em.persist(entity);
		return entity;	}

	@Override
	public void delete(CentreEquestre entity) {
		CentreEquestre eMerged = em.merge(entity);
		em.remove(eMerged);
	}
	
	@Override
	public CentreEquestre findByPrimaryKey(Integer id) {
		return em.find(CentreEquestre.class, id);
	}

	@Override
	public CentreEquestre update(CentreEquestre entity) {
		return em.merge(entity);
	}


}
