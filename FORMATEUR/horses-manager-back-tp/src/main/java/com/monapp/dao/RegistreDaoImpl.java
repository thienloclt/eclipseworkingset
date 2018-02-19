package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.monapp.entity.Registre;

@Repository
@Transactional
public class RegistreDaoImpl implements RegistreDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Registre> findAll() {
		String querystring = "SELECT r FROM Registre r " ;
		Query query = em.createQuery( querystring ) ;
		List<Registre> list = query.getResultList() ;
		return list;
	}

	@Override
	public Registre save(Registre entity) {
		em.persist(entity);
		return entity;	}

	@Override
	public void delete(Registre entity) {
		Registre eMerged = em.merge(entity);
		em.remove(eMerged);
	}
	
	@Override
	public Registre findByPrimaryKey(Integer id) {
		return em.find(Registre.class, id);
	}

	@Override
	public Registre update(Registre entity) {
		return em.merge(entity);
	}


}
