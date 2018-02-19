package ecommerce.test;

import org.junit.Assert;
import org.junit.Test;

import ecommerce.dao.Calcul;

public class DesTests {

	@Test
	public void testAddition() {
		int sum = Calcul.add(1,3,5,7,9,15);
		
		Assert.assertEquals(40, sum);
	}
	
	@Test
	public void testMultiplication() {
		Assert.assertEquals(14175, Calcul.mul(1,3,5,7,9,15));
	}
}
