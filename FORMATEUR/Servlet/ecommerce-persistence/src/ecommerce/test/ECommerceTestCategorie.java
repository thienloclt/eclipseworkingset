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

		Categorie telephone = new Categorie("T�l�phone");
		telephone.setMere(hitech);
		telephone.setDescription("Tout type de t�l�phone quelque soit l'origine du monde");
		categorieDao.create(telephone);

		Categorie smartphone = new Categorie("Smartphone");
		smartphone.setMere(telephone);
		smartphone.setDescription("T�l�phone anti sociaux multi facettes");
		categorieDao.create(smartphone);

		Categorie telFixe = new Categorie("T�l�phone Fixe");
		telFixe.setMere(telephone);
		telFixe.setDescription("T�l�phone qui prend la poussi�re dans l'appartement");
		categorieDao.create(telFixe);
		
		System.out.println(categorieDao.findAllByDescription("T"));
	}

}
