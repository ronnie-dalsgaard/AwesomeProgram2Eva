package rest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_test {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

//        saveTest(session);
        loadTest(session);

        session.flush();
        session.close();
        
        System.exit(0);
    }
	
	private static void saveTest(Session session){
        Person pers = new Person();
        pers.setFname("Fætter Guf");
//        pers.setFname("Sorteper");
//        pers.setFname("George Gearløs");
        System.out.println("New person = " + pers);
        
        session.save(pers);
        System.out.println("New person = " + pers);
	}
	
	@SuppressWarnings("unchecked")
	private static void loadTest(Session session){
        List<Person> everybody = session.createQuery("FROM Person").list();
        for(Person p : everybody){
        	System.out.println(p);
        }
	}
	
}
