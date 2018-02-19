package ecommerce.test;

import ecommerce.Application;
import ecommerce.dao.CategorieDao;
import ecommerce.dao.ClientDao;
import ecommerce.dao.LoginDao;
import ecommerce.model.Categorie;
import ecommerce.model.Client;
import ecommerce.model.Login;
import ecommerce.model.Role;

public class ECommerceTestCategorie {

	public static void main(String[] args) {
		LoginDao loginDao = Application.getInstance().getLoginDao();
		ClientDao clientDao = Application.getInstance().getClientDao();
		CategorieDao categorieDao = Application.getInstance().getCategorieDao();

		Categorie hitech = new Categorie("High-Tech");
		hitech.setDescription("Produits hautes technologies de l'avenir incertain");
		categorieDao.create(hitech);

		Categorie telephone = new Categorie("Téléphone");
		telephone.setMere(hitech);
		telephone.setDescription("Tout type de téléphone quelque soit l'origine du monde");
		categorieDao.create(telephone);

		Categorie smartphone = new Categorie("Smartphone");
		smartphone.setMere(telephone);
		smartphone.setDescription("Téléphone anti sociaux multi facettes");
		categorieDao.create(smartphone);

		Categorie telFixe = new Categorie("Téléphone Fixe");
		telFixe.setMere(telephone);
		telFixe.setDescription("Téléphone qui prend la poussière dans l'appartement");
		categorieDao.create(telFixe);
		
		System.out.println(categorieDao.findAllByDescription("T"));
	}

}
