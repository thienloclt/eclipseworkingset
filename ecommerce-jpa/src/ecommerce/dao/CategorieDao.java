package ecommerce.dao;

import java.util.List;

import ecommerce.model.Categorie;

public interface CategorieDao extends Dao<Categorie, Long>{
	List<Categorie> findAllByNomOrDescription(String nom, String description);
	Categorie findByNom(String nom);
	List<Categorie> findAllByDescription(String description);
}
