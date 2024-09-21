package com.robin.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.robin.Entity.Alien;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Alien al = new Alien();
//    	al.setAid(2);
//    	al.setAname("royroy");
//    	al.setColor("puple");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersist1");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	Alien al = em.find(Alien.class, 2);
    	//em.persist(al);
    	//em.merge(al);
    	em.remove(al);
    	em.getTransaction().commit();
//    	Alien a = em.find(Alien.class, 102);
//    	System.out.println(a);
    }
}
