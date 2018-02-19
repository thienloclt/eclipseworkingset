package ecommerce.dao;

import java.util.List;

import ecommerce.model.Produit;

public interface ProduitDao extends Dao<Produit, Long>{
	List<Produit> findAllByNom(String nom);
	List<Produit> findAllByStock(Integer quantite);
	List<Produit> findAllByPrix(Double min, Double max);
}
