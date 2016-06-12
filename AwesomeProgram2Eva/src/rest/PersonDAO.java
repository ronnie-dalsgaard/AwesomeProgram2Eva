package rest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDAO {

	public Person getPerson(int id){
		return null;
	}
	
	public void createPerson(String name){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person pers = new Person();
        pers.setFname("Fætter Guf");
//        pers.setFname("Sorteper");
//        pers.setFname("George Gearl�s");
        System.out.println("New person = " + pers);
        
        session.save(pers);
        System.out.println("New person = " + pers);

        session.flush();
        session.close();
	}
}
