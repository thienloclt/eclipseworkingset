package ecommerce.test;

import ecommerce.Application;
import ecommerce.dao.ClientDao;
import ecommerce.dao.LoginDao;
import ecommerce.model.Client;
import ecommerce.model.Login;
import ecommerce.model.Role;

public class ECommerceTestLogin {

	public static void main(String[] args) {
		LoginDao loginDao = Application.getInstance().getLoginDao();
		ClientDao clientDao = Application.getInstance().getClientDao();

		int start = loginDao.findAll().size();
		
		System.out.println("compte 0 : " + start);

		Client solange = new Client("MENDY", "Solange");

//		clientDao.create(solange);

		Login login = new Login("root", "password", Role.ADMIN);
		login.setClient(solange);

//		loginDao.create(login);
		
		Login loginFind = loginDao.find(login.getId());
		
		System.out.println(login);
		System.out.println(loginFind);

		login.setMotDePasse("789456123");
		login.setRole(Role.USER);

		loginDao.update(login);
		
		loginFind = loginDao.find(login.getId());
		
		System.out.println(login);
		System.out.println(loginFind);

		int middle = loginDao.findAll().size();

		System.out.println("compte 5 bis : " + (middle - start));
		
		loginDao.delete(login);
		
		int end = loginDao.findAll().size();
		
		System.out.println("compte 7 : " + (end - start));
	}

}
