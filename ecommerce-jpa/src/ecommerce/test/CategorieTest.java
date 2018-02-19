package ecommerce.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ecommerce.Application;
import ecommerce.dao.CategorieDao;
import ecommerce.model.Categorie;

public class CategorieTest {
	private static CategorieDao categorieDao;

	@BeforeClass
	public static void init() {
		categorieDao = Application.getInstance().getCategorieDao();
	}

	@AfterClass
	public static void destroy() {
		Application.stop();
	}

	@Test
	public void test() {
		Categorie hitech = new Categorie("High-Tech");
		hitech.setDescription("High-Tech Description");
		categorieDao.create(hitech);
		
		Categorie hitechFind = categorieDao.find(hitech.getId());
		Assert.assertEquals("High-Tech Description", hitechFind.getDescription());
		
		Categorie telephone = new Categorie("Téléphone");
		telephone.setMere(hitech);
		categorieDao.create(telephone);
		
		Categorie telephoneFind = categorieDao.find(telephone.getId());
		
		
		Assert.assertEquals("High-Tech", telephoneFind.getMere().getNom());
		
		telephone.setDescription("Téléphone description");
		
		telephoneFind = categorieDao.update(telephone);
		
		Assert.assertEquals("Téléphone description", telephone.getDescription());
		Assert.assertEquals("Téléphone description", telephoneFind.getDescription());
		

		Categorie smartphone = new Categorie("Smartphone");
		smartphone.setMere(telephone);
		categorieDao.create(smartphone);
		
		categorieDao.delete(smartphone);
		
		Categorie smartphoneFind = categorieDao.find(smartphone.getId());
		Assert.assertNotNull(smartphone);
		Assert.assertNull(smartphoneFind);
		
		if(smartphoneFind == null){
			Assert.fail("La suppression du Login a échoué");
		}
//
//		Categorie telFixe = new Categorie("Téléphone Fixe");
//		telFixe.setMere(telephone);
//		categorieDao.create(telFixe);
	}

}
