package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.monapp.entity.Cheval;

@Repository
@Transactional
public class ChevalDaoImpl implements ChevalDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cheval> findAll() {
		String querystring = "SELECT c FROM Cheval c " ;
		Query query = em.createQuery( querystring ) ;
		List<Cheval> list = query.getResultList() ;
		return list;
	}

	@Override
	public Cheval save(Cheval entity) {
		em.persist(entity);
		return entity;	}

	@Override
	public void delete(Cheval entity) {
		Cheval eMerged = em.merge(entity);
		em.remove(eMerged);
	}
	
	@Override
	public Cheval findByPrimaryKey(Integer id) {
		return em.find(Cheval.class, id);
	}

	@Override
	public Cheval update(Cheval entity) {
		return em.merge(entity);
	}


}
