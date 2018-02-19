package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.LoginDao;
import monprojet.cheval.model.Login;


@Transactional
@Repository
public class LoginDaoJpa implements LoginDao {

	@PersistenceContext
	private EntityManager em;

	public Login find(Long id) {
		return em.find(Login.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Login findByNamePass(String usrname , String passwrd) {

		Query query = em.createQuery("from Login where login = :usrname and passwrd = :passwrd");
		query.setParameter("usrname", usrname);
		query.setParameter("passwrd", passwrd);
		List<Login> founds = (List<Login>) query.getResultList();
        return (founds == null || founds.isEmpty()) ? null : founds.get(0);
	}

	public void create(Login obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Login> findAll() {
		List<Login> list = null;

		Query query = em.createQuery("from Login");
		list = query.getResultList();

		return list;
	}

	public Login update(Login obj) {
		return em.merge(obj);
	}

	public void delete(Login obj) {
		em.remove(em.merge(obj));
	}
}