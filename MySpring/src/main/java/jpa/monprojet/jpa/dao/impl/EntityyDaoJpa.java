package monprojet.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.jpa.dao.EntityyDao;
import monprojet.jpa.model.Entityy;


@Transactional
@Repository
public class EntityyDaoJpa implements EntityyDao {
	
	@PersistenceContext
	private EntityManager em;

	public Entityy find(Long id) {
		return em.find(Entityy.class, id);
	}
	

	public List<Entityy> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Entityy update(Entityy obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Entityy obj) {
		// TODO Auto-generated method stub

	}
	
	public void create(Entityy obj) {
		em.persist(obj);
	}
}