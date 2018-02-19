package ecommerce.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ecommerce.model.Categorie;
import ecommerce.model.LigneCommande;
import ecommerce.model.Produit;

public class ProduitTest {

	public static Produit vide;
	public static Produit p;

	@BeforeClass
	public static void before() {
		vide = new Produit();
		p = new Produit("nom", 1.0, 2);
	}

	@Test
	public void testProduit() {
		assertNotNull(vide);
	}

	@Test
	public void testProduitStringDoubleInteger() {
		assertNotNull(p);
	}

	@Test
	public void testGetId() {
		assertEquals(null, p.getId());
	}

	@Test
	public void testGetVersion() {
		assertEquals(0, p.getVersion());
	}

	@Test
	public void testGetNom() {
		assertEquals("nom", p.getNom());
	}

	@Test
	public void testSetNom() {
		p.setNom("nom2");
		assertEquals("nom2", p.getNom());
	}

	@Test
	public void testGetPrix() {
		assertEquals(new Double(1.0), p.getPrix());
	}

	@Test
	public void testSetPrix() {
		p.setPrix(2.0);
		assertEquals(new Double(2.0), p.getPrix());
	}

	@Test
	public void testGetDescription() {
		p.setDescription(null);
		assertNull(p.getDescription());
	}

	@Test
	public void testSetDescription() {
		p.setDescription("lala");
		assertEquals("lala", p.getDescription());
	}

	@Test
	public void testGetStock() {
		assertEquals(new Integer(2), p.getStock());
	}

	@Test
	public void testSetStock() {
		p.setStock(4);
		assertEquals(new Integer(4), p.getStock());
	}

	@Test
	public void testGetCategorie() {
		assertNull(p.getCategorie());
	}

	@Test
	public void testSetCategorie() {
		Categorie c = new Categorie();
		p.setCategorie(c);
		assertEquals(c, p.getCategorie());
	}

	@Test
	public void testGetLigneCommandes() {
		p.setLigneCommandes(null);
		assertNull(p.getLigneCommandes());
	}

	@Test
	public void testSetLigneCommandes() {
		LigneCommande l = new LigneCommande();
		List<LigneCommande> lc = new ArrayList<>();
		lc.add(l);
		p.setLigneCommandes(lc);
		assertEquals(lc, p.getLigneCommandes());
	}

}
