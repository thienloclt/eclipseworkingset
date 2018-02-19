package ecommerce.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ecommerce.Application;
import ecommerce.dao.ProduitDao;
import ecommerce.model.Produit;

public class ProduitJpaTest2 {

	public static Produit p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Produit();
		p.setCategorie(null);
		p.setDescription("lala");
		p.setLigneCommandes(null);
		p.setNom("nom");
		p.setPrix(2.0);
		p.setStock(3);
	}

	@Test
	public void test() {
		
		ProduitDao produitDao = Application.getInstance().getProduitDao();
		produitDao.create(p);
		Produit pFind = produitDao.find(p.getId());
		
		assertEquals(0,pFind.getVersion());
		assertEquals("lala",pFind.getDescription());
		assertNull(pFind.getCategorie());
//		assertNull(pFind.getLigneCommandes());
		assertEquals("nom",pFind.getNom());
		assertEquals(new Double(2.0),pFind.getPrix());
		assertEquals(new Integer(3),pFind.getStock());
		
		
		pFind.setDescription("lulu");
		p = produitDao.update(pFind);
		assertEquals("lulu",pFind.getDescription());
		
		List<Produit> pl = new ArrayList<>();
		pl.add(pFind);
		
		List<Produit> plF = produitDao.findAll();
		assertEquals(pl,plF);
	}

}
