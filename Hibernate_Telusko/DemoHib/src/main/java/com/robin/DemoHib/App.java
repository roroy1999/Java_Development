package com.robin.DemoHib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.query.Query;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	AlienName an = new AlienName();
//    	an.setfName("Robin");
//    	an.setmName("Roy");
//    	an.setlName("Alexander");
        Alien robin = new Alien();
//        robin.setAid(106);
//        robin.setAname("robin");
//        robin.setAname(an);
//        robin.setColor("Green");
    	
//    	Laptop laptop = new Laptop();
//    	laptop.setLid(102);
//    	laptop.setLname("HP");
//    	Laptop laptop2 = new Laptop();
//    	laptop2.setLid(103);
//    	laptop2.setLname("Apple");
//    	Student student = new Student();
//    	student.setRollno(2);
//    	student.setName("Rohan");
//    	student.setMarks(100);
//    	//student.setLaptop(laptop);
//    	//student.getLaptop().add(laptop);
//    	laptop.setStudent(student);
//    	laptop2.setStudent(student);
    	//laptop.getStudent().add(student);
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        //Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
//        Session session = sf.openSession();
        Session session1 = sf.openSession();
        
        
        //Transaction tx = session.beginTransaction();
        //session.beginTransaction();
        session1.beginTransaction();
        
//        session.save(robin);
//        robin = (Alien)session.get(Alien.class, 105);
//        robin = (Alien)session1.get(Alien.class, 105);
        Query q1 = session1.createQuery("From Alien where aid = 105");
        q1.setCacheable(true);
        robin = (Alien)q1.uniqueResult();
        System.out.println(robin);
        
        //tx.commit();
//        session.save(laptop2);
//        session.save(student);
        //Student robin = session.get(Student.class, 2);
//        session.getTransaction().commit();
        session1.getTransaction().commit();
        session1.close();
        Session session2 = sf.openSession();
        session2.beginTransaction();
        //robin = (Alien)session2.get(Alien.class, 105);
        //System.out.println(robin);
        
        Query q2 = session2.createQuery("From Alien where aid = 105");
        q2.setCacheable(true);
        robin = (Alien)q2.uniqueResult();
        System.out.println(robin);
        session2.getTransaction().commit();
        session2.close();
//        Query<Student> l1 = session.createQuery("From Student", Student.class);
//        System.out.println(robin);
//        List<Laptop> laptop = robin.getLaptop();
//        for(Laptop l : laptop) {
//        	System.out.println(l);
//        }
//        for(Student std : l1.list()) {
//        	System.out.println(std);
//        }
    }
}
