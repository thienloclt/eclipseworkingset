package ecommerce.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ecommerce.Application;
import ecommerce.model.Categorie;
import ecommerce.model.Produit;

public class ECommerceTest {

	public static void main(String[] args) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Categorie hitech = new Categorie("High-Tech");
			em.persist(hitech);

			Categorie telephone = new Categorie("T�l�phone");
			telephone.setMere(hitech);
			em.persist(telephone);

			Categorie smartphone = new Categorie("Smartphone");
			smartphone.setMere(telephone);
			em.persist(smartphone);

			Categorie telFixe = new Categorie("T�l�phone Fixe");
			telFixe.setMere(telephone);
			em.persist(telFixe);

			Produit iphoneX = new Produit("IPhone X", 1100.0, 5);
			iphoneX.setCategorie(smartphone);

			em.persist(iphoneX);
			
			iphoneX.setPrix(800.0);

			
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

}
