package ecommerce.dao;

import java.util.List;

import ecommerce.model.Commande;

public interface CommandeDao extends Dao<Commande, Long>{
	List<Commande> findAllByAnneeAndPrix(String annee, Double prix);
	
	List<Commande> findAllByAnneeAndPrixWithCriteria(String annee, Double prix);
	
	List<Commande> findAllByProduit(String nom);
}
