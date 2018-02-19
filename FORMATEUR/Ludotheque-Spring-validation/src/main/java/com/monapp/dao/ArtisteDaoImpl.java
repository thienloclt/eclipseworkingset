package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.metier.Artiste;

@Transactional
@Repository
public class ArtisteDaoImpl implements ArtisteDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Artiste> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Artiste> crit = cb.createQuery(Artiste.class);
		Root<Artiste> r = crit.from(Artiste.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Artiste save(Artiste entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Artiste entity) {
		Artiste eMerged = em.merge(entity);
		em.remove(eMerged);
		
	}
	
	@Override
	public Artiste findByPrimaryKey(Integer id) {
		return em.find(Artiste.class, id);
	}

	@Override
	public Artiste update(Artiste entity) {
		return em.merge(entity);
	}



}
