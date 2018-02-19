package monprojet.jpa.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import monprojet.jpa.dao.EntityyDao;
import monprojet.jpa.model.Entityy;

@ContextConfiguration(locations = "classpath:META-INF/Spring/jpa.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLight {

	@Autowired
	private EntityyDao entityyDao;

	@Test
	public void apopulate() {

		Entityy entityy = new Entityy("admin");
		Entityy entityyMaj = new Entityy("user");

		entityyDao.create(entityy);
		entityyDao.create(entityyMaj);

		Entityy entityyFind = entityyDao.find(entityy.getId());
		
		
		
		Assert.assertEquals(entityyFind.getName(), entityy.getName());
		Assert.assertEquals(entityyFind.getName(), entityyMaj.getName());
	}
}
