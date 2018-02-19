package ecommerce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ecommerce.Application;
import ecommerce.dao.CategorieDao;
import ecommerce.model.Categorie;

public class CategorieDaoJpa implements CategorieDao {

	@Override
	public Categorie find(Long id) {
		Categorie categorie = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			categorie = em.find(Categorie.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("from Categorie");
			liste = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
		return liste;
	}

	@Override
	public void create(Categorie obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Categorie update(Categorie obj) {
		Categorie objCopy = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			objCopy = em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}

		return objCopy;
	}

	@Override
	public void delete(Categorie obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Categorie> findAllByNomOrDescription(String nom, String description) {
		List<Categorie> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Categorie> criteriaQuery = cb.createQuery(Categorie.class);
			
			Root<Categorie> categorie = criteriaQuery.from(Categorie.class);
			criteriaQuery.select(categorie);
			
			if(!nom.isEmpty()) {
				criteriaQuery.where(cb.like(categorie.get("nom"), nom));
			} else if(!description.isEmpty()) {
				criteriaQuery.where(cb.like(categorie.get("description"), description));
			}
			
			TypedQuery<Categorie> query = em.createQuery(criteriaQuery);
			liste = query.getResultList();
			

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
		return liste;
	}

	@Override
	public Categorie findByNom(String nom) {
		Categorie categorie = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("select c from Categorie c where c.nom = :nom");
			query.setParameter("nom", nom);
			categorie = (Categorie) query.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAllByDescription(String description) {
		List<Categorie> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("select c from Categorie c where c.description like :motCle");
			query.setParameter("motCle", "%"+description+"%");
			liste = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (em != null) {
				em.close();
			}
		}
		return liste;
	}

}
