package ecommerce.dao;

import ecommerce.model.Login;

public interface LoginDao extends Dao<Login, Long>{
	public Login findByNamePass(String name , String pass);
}
