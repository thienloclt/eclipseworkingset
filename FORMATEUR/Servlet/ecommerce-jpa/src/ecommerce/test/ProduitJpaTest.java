package ecommerce.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ecommerce.Application;
import ecommerce.model.Produit;

public class ProduitJpaTest {

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
		Application.getInstance().getProduitDao().create(p);
	}

	@Test
	public void testFind() {
		assertEquals(p, Application.getInstance().getProduitDao().find(p.getId()));

	}

	@Test
	public void testFindAll() {
		Application.getInstance().getProduitDao().create(p);
		List<Produit> lp = new ArrayList<>();
		lp.add(p);
		assertEquals(lp, Application.getInstance().getProduitDao().findAll());
	}

	@Test
	public void testCreate() {
		Application.getInstance().getProduitDao().create(p);
		assertEquals(p, Application.getInstance().getProduitDao().find(p.getId()));
	}

	@Test
	public void testUpdate() {
		Application.getInstance().getProduitDao().create(p);
		p.setNom("nom2");
		Application.getInstance().getProduitDao().update(p);
		assertEquals(p, Application.getInstance().getProduitDao().find(p.getId()));
		p.setNom("nom");

	}

	@Test
	public void testDelete() {
		Application.getInstance().getProduitDao().create(p);
		Application.getInstance().getProduitDao().delete(p);
		assertNull(Application.getInstance().getProduitDao().find(p.getId()));
	}

	@Test
	public void testFindAllByNom() {
		Application.getInstance().getProduitDao().create(p);
		List<Produit> lp = new ArrayList<>();
		lp.add(p);
		assertEquals(p, Application.getInstance().getProduitDao().findAllByNom("nom"));
	}

	@Test
	public void testFindAllByStock() {
		Application.getInstance().getProduitDao().create(p);
		List<Produit> lp = new ArrayList<>();
		lp.add(p);
		assertEquals(p, Application.getInstance().getProduitDao().findAllByStock(3));
	}

	@Test
	public void testFindAllByPrix() {
		Application.getInstance().getProduitDao().create(p);
		List<Produit> lp = new ArrayList<>();
		lp.add(p);
		assertEquals(p, Application.getInstance().getProduitDao().findAllByPrix(1.5, 2.5));
	}

}
