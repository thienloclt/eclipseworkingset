package ecommerce.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ecommerce.Application;
import ecommerce.dao.ClientDao;
import ecommerce.dao.LoginDao;
import ecommerce.model.Client;
import ecommerce.model.ClientId;
import ecommerce.model.Login;
import ecommerce.model.Role;

public class LoginTest {
	
	private static LoginDao loginDao;
	private static ClientDao clientDao;
	
	@BeforeClass
	public static void init() {
		loginDao = Application.getInstance().getLoginDao();
		clientDao = Application.getInstance().getClientDao();
	}
	
	@AfterClass
	public static void destroy( ) {
		Application.stop();
	}
	
	@Test
	public void test() {
		int start = loginDao.findAll().size();

		Client solange = new Client("MENDY", "Solange");
		clientDao.create(solange);

		Login login = new Login("root", "password", Role.ADMIN);
		login.setClient(solange);
		loginDao.create(login);
		
		Login loginFind = loginDao.find(login.getId());
		
		Assert.assertEquals(0, loginFind.getVersion());
		Assert.assertEquals("root", loginFind.getLogin());
		Assert.assertEquals("password", loginFind.getMotDePasse());
		Assert.assertEquals(Role.ADMIN, loginFind.getRole());
		Assert.assertEquals(new ClientId("MENDY", "Solange"), loginFind.getClient().getId());
		
		Client julien = new Client("BERTRAND", "Julien");
		clientDao.create(julien);
		
		login.setLogin("ruut");
		login.setMotDePasse("789456123");
		login.setRole(Role.USER);
		login.setClient(julien);

		loginDao.update(login);
		
		loginFind = loginDao.find(login.getId());
		
		Assert.assertEquals(1, loginFind.getVersion());
		Assert.assertEquals("ruut", loginFind.getLogin());
		Assert.assertEquals("789456123", loginFind.getMotDePasse());
		Assert.assertEquals(Role.USER, loginFind.getRole());
		Assert.assertEquals(new ClientId("BERTRAND", "Julien"), loginFind.getClient().getId());
		
		int middle = loginDao.findAll().size();

		Assert.assertEquals(1, (middle - start));
		
		loginDao.delete(loginFind);
		
		int end = loginDao.findAll().size();
		
		if(end != start) {
			Assert.fail("La suppression du Login a échoué");
		}
		
		loginFind = loginDao.find(login.getId());
		
		Assert.assertNull(loginFind);
		
		clientDao.delete(solange);
		clientDao.delete(julien);
	}
}
