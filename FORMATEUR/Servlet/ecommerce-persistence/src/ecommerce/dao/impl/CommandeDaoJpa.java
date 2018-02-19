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
import ecommerce.dao.CommandeDao;
import ecommerce.model.Commande;

public class CommandeDaoJpa implements CommandeDao {

	@Override
	public Commande find(Long id) {
		Commande commande = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			commande = em.find(Commande.class, id);

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
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Query query = em.createQuery("from Commande");
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
	public void create(Commande obj) {
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
	public Commande update(Commande obj) {
		Commande objCopy = null;
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
	public void delete(Commande obj) {
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
	public List<Commande> findAllByAnneeAndPrix(String annee, Double prix) {
		List<Commande> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

//			Query query = em.createQuery("select c from Commande c where c.date like :annee and c.prixTotal > :prix");
//			query.setParameter("annee", annee);
//			query.setParameter("prix", prix);
//			liste = query.getResultList();

			Query query = em.createQuery("select c from Commande c where year(c.date) = :annee and c.prixTotal > :prix");
			query.setParameter("annee", annee);
			query.setParameter("prix", prix);
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
	public List<Commande> findAllByAnneeAndPrixWithCriteria(String annee, Double prix) {
		List<Commande> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Commande> criteriaQuery = cb.createQuery(Commande.class);
			
			Root<Commande> c = criteriaQuery.from(Commande.class);
			criteriaQuery.select(c);
			
			criteriaQuery.where(
					cb.and(
							cb.equal(
									cb.function("year", String.class, c.get("date")), 
									annee),
							cb.gt(c.get("prixTotal"), prix)
						  )
					);			
			
			TypedQuery<Commande> query = em.createQuery(criteriaQuery);
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
	public List<Commande> findAllByProduit(String nom) {
		List<Commande> liste = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

//			Query query = em.createQuery("select c from Commande c join c.ligneCommandes lc join lc.produit p where p.nom = :nom");
//			query.setParameter("nom", nom);
//			liste = query.getResultList();
			
//			Query query = em.createQuery("select c from Commande c join c.ligneCommandes lc where lc.produit.nom = :nom");
//			query.setParameter("nom", nom);
//			liste = query.getResultList();
			
//			Query query = em.createQuery("select lc.commande from LigneCommande lc where lc.produit.nom = :nom");
//			query.setParameter("nom", nom);
//			liste = query.getResultList();
			
			Query query = em.createQuery("select c from LigneCommande lc join lc.produit p join lc.commande c where p.nom = :nom");
			query.setParameter("nom", nom);
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
