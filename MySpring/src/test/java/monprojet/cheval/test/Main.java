package monprojet.cheval.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.dao.ChevalDao;
import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.CentreEquestre;
import monprojet.cheval.model.Cheval;
import monprojet.cheval.model.Registre;

public class Main {
	
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Cheval cheval1 = new Cheval("name1", "remarque1");
		Cheval cheval2 = new Cheval("name2", "remarque2");
		Cheval cheval3 = new Cheval("name3", "remarque3");
		Cheval cheval4 = new Cheval("name4", "remarque4");

		CentreEquestre centreEquestre1 = new CentreEquestre("nom1", "adresse1", "codepostal1");
		CentreEquestre centreEquestre2 = new CentreEquestre("nom2", "adresse2", "codepostal2");

		Registre registre1 = new Registre("numero1", sdf.parse("01-01-2018"));
		Registre registre2 = new Registre("numero2", sdf.parse("02-02-2018"));
		Registre registre3 = new Registre("numero3", sdf.parse("03-03-2018"));
		Registre registre4 = new Registre("numero4", sdf.parse("04-04-2018"));

		ApplicationContext context1 = new ClassPathXmlApplicationContext("META-INF/Spring/cheval.xml");
		ChevalDao chevalDao = (ChevalDao) context1.getBean(ChevalDao.class);
		CentreEquestreDao centreEquestreDao = (CentreEquestreDao) context1.getBean(CentreEquestreDao.class);
		RegistreDao registreDao = (RegistreDao) context1.getBean(RegistreDao.class);

		centreEquestreDao.create(centreEquestre1);
		centreEquestreDao.create(centreEquestre2);

		cheval1.setCentreEquestre(centreEquestre1);
		cheval2.setCentreEquestre(centreEquestre2);
		cheval3.setCentreEquestre(centreEquestre1);
		cheval4.setCentreEquestre(centreEquestre1);

		chevalDao.create(cheval1);
		chevalDao.create(cheval2);
		chevalDao.create(cheval3);
		chevalDao.create(cheval4);

		registre1.setCheval(cheval1);
		registre2.setCheval(cheval2);
		registre3.setCheval(cheval3);
		registre4.setCheval(cheval4);

		registreDao.create(registre1);
		registreDao.create(registre2);
		registreDao.create(registre3);

		List<Cheval> chevals = chevalDao.findAll();

		for (Cheval cheval : chevals) {
			System.out.println("-----cheval: " + cheval.getName());
		}

		List<Registre> registres = registreDao.findAll();

		for (Registre registre : registres) {
			System.out.println("-----registre: " + registre.getNumero());
		}

		List<CentreEquestre> centreEquestres = centreEquestreDao.findAll();

		for (CentreEquestre centreEquestre : centreEquestres) {
			System.out.println("-----centreEquestre: " + centreEquestre.getCodepostal());
			for (Cheval cheval : centreEquestre.getChevals()) {
				System.out.println("        .....cheval: " + cheval.getName());
			}
		}

		((ClassPathXmlApplicationContext) context1).close();
	}
}