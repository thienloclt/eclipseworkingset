package monprojet.cheval.dao;

import monprojet.cheval.model.Login;

public interface LoginDao extends Dao<Login, Long>{
	public Login findByNamePass(String name , String pass);
}
