package ecommerce.test;

import ecommerce.Application;
import ecommerce.dao.AdresseDao;
import ecommerce.dao.CategorieDao;
import ecommerce.dao.ClientDao;
import ecommerce.dao.LoginDao;
import ecommerce.dao.ProduitDao;
import ecommerce.model.Adresse;
import ecommerce.model.Categorie;
import ecommerce.model.Civilite;
import ecommerce.model.Client;
import ecommerce.model.ClientId;
import ecommerce.model.Login;
import ecommerce.model.Produit;
import ecommerce.model.Role;

public class ECommerceTestDao {

	public static void main(String[] args) {
		ProduitDao produitDao = Application.getInstance().getProduitDao();
		CategorieDao categorieDao = Application.getInstance().getCategorieDao();
		ClientDao clientDao = Application.getInstance().getClientDao();
		LoginDao loginDao = Application.getInstance().getLoginDao();
		AdresseDao adresseDao = Application.getInstance().getAdresseDao();
		
		Categorie hitech = new Categorie("High-Tech");
		Application.getInstance().getCategorieDao().create(hitech);
		
		Categorie telephone = new Categorie("Téléphone");
		telephone.setMere(hitech);
		categorieDao.create(telephone);
		
		telephone.setDescription("dfkdfhsdfijdf");
		
		categorieDao.update(telephone);

		Categorie smartphone = new Categorie("Smartphone");
		smartphone.setMere(telephone);
		categorieDao.create(smartphone);

		Categorie telFixe = new Categorie("Téléphone Fixe");
		telFixe.setMere(telephone);
		categorieDao.create(telFixe);

		Produit iphoneX = new Produit("IPhone X", 1100.0, 5);
		iphoneX.setCategorie(smartphone);
		iphoneX.setDescription("Le téléphone le plus cher du monde !!!");
		produitDao.create(iphoneX);

		iphoneX.setPrix(750.0);
		
		produitDao.update(iphoneX);
		
		Produit galaxyS8 = new Produit("Galaxy S8", 600.0, 5);
		galaxyS8.setCategorie(smartphone);
		produitDao.create(galaxyS8);
		
		smartphone = categorieDao.find(smartphone.getId()); 
		
//		Erreur car attribut mere sur categorie en lazy loading
//		System.out.println(smartphone.getMere().getNom());
		
		for(Produit produit : smartphone.getProduits()) {
			System.out.println(produit.getNom());
		}
		
		
		
		Client apollon = new Client("DRIDI", "Hachem");
		apollon.setCivilite(Civilite.M);
		apollon.setEmail("hachem@olympe.fr");
		clientDao.create(apollon);
		
		Login loginApollon = new Login("apollon", "soleil", Role.ADMIN);
		loginApollon.setClient(apollon);
		loginDao.create(loginApollon);
		
		
		Adresse anthony = new Adresse("1 rue de Paris", "92160", "Anthony");
		anthony.setClient(apollon);
		adresseDao.create(anthony);
		
		Adresse bizert = new Adresse("3 rue de Tunis", "75035", "Bizert");
		bizert.setClient(apollon);
		adresseDao.create(bizert);
		
		Client hachem = clientDao.findWithAdresses(new ClientId("DRIDI", "Hachem"));
		
		System.out.println(hachem.getAdresses());
	}

}
