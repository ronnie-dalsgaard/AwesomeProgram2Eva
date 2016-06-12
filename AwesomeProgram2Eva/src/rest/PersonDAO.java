package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Path("person")
public class PersonDAO {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Person createPerson(@QueryParam("name") String name){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person p = new Person(name);
        session.save(p);

        session.flush();
        session.close();
        
        return p;
	}
	
	@GET
	@Path("{i}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("i") int id){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql = "FROM Person p WHERE p.id = :pid";
        Query query = session.createQuery(hql);
        query.setParameter("pid",id);
        @SuppressWarnings("unchecked")
		List<Person> l = query.list();
		session.flush();
		session.close();
		if(l == null || l.isEmpty()) 
			throw new IllegalArgumentException("No person with id "+id);
        
        return l.get(0);
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql = "FROM Person";
        @SuppressWarnings("unchecked")
		List<Person> l= session.createQuery(hql).list();
        
        session.flush();
        session.close();
        return l;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePerson(Person p){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.update(p);
        
        session.flush();
        session.close();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePerson(Person p){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.delete(p);
        
        session.flush();
        session.close();
	}
}
