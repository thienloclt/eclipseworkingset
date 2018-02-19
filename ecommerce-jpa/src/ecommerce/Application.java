package ecommerce;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ecommerce.dao.AdresseDao;
import ecommerce.dao.CategorieDao;
import ecommerce.dao.ClientDao;
import ecommerce.dao.CommandeDao;
import ecommerce.dao.LigneCommandeDao;
import ecommerce.dao.LoginDao;
import ecommerce.dao.ProduitDao;
import ecommerce.dao.impl.AdresseDaoJpa;
import ecommerce.dao.impl.CategorieDaoJpa;
import ecommerce.dao.impl.ClientDaoJpa;
import ecommerce.dao.impl.CommandeDaoJpa;
import ecommerce.dao.impl.LigneCommandeDaoJpa;
import ecommerce.dao.impl.LoginDaoJpa;
import ecommerce.dao.impl.ProduitDaoJpa;

public class Application {
	private static Application instance = null;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");

	private ProduitDao produitDao = new ProduitDaoJpa();
	private CategorieDao categorieDao = new CategorieDaoJpa();
	private ClientDao clientDao = new ClientDaoJpa();
	private AdresseDao adresseDao = new AdresseDaoJpa();
	private LoginDao loginDao = new LoginDaoJpa();
	private CommandeDao commandeDao = new CommandeDaoJpa();
	private LigneCommandeDao ligneCommandeDao = new LigneCommandeDaoJpa();
	
	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}
	
	public static void stop() {
		Application inst = getInstance();
		inst.adresseDao = null;
		inst.produitDao = null;
		inst.categorieDao = null;
		inst.clientDao = null;
		inst.loginDao = null;
		inst.commandeDao = null;
		inst.ligneCommandeDao = null;
		inst.emf.close();
		inst.emf = null;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public ProduitDao getProduitDao() {
		return produitDao;
	}

	public CategorieDao getCategorieDao() {
		return categorieDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public AdresseDao getAdresseDao() {
		return adresseDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

	public LigneCommandeDao getLigneCommandeDao() {
		return ligneCommandeDao;
	}
	
	

}
