package ecommerce.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonTestV4 {

	@Test
	public void testAdd() {
		
		assertEquals((Double)2.0,(Double)2.05, 0.1);
		
	}

	@Test
	public void testMul() {
		fail("Not yet implemented");
	}

}
