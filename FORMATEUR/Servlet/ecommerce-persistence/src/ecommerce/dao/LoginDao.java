package ecommerce.dao;

import ecommerce.model.Login;

public interface LoginDao extends Dao<Login, Long>{
	public Login findByLoginAndPassword(String login, String password);

}
