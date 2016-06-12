package rest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDAO {

	public Person getPerson(int id){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql = "FROM Person p WHERE p.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        @SuppressWarnings("unchecked")
		List<Person> list = query.list();
		session.flush();
		session.close();
		if(list == null || list.isEmpty()) 
			throw new IllegalArgumentException("No person with id "+id);
        
        return list.get(0);
	}
	
	public Person createPerson(String name){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person pers = new Person(name);
        session.save(pers);

        session.flush();
        session.close();
        
        return pers;
	}
}
