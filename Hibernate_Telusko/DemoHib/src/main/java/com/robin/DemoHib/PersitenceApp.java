package com.robin.DemoHib;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
public class PersitenceApp 
{
    public static void main( String[] args )
    {
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop_Pesistence.class);        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();       
        session.beginTransaction();
//        Random r = new Random();
//        for(int i=1;i<=50;i++) {
//        	Laptop_Pesistence s = new Laptop_Pesistence();
//        	s.setLid(i);
//        	s.setBrand("Brand"+i);
//        	s.setPrice(r.nextInt(10000));// Specifing Mark should not more then 100
//        	session.save(s);
//        }
//        Laptop_Pesistence l1 = new Laptop_Pesistence();
//        l1.setLid(52);
//        l1.setBrand("Samsung");
//        l1.setPrice(710);
//        session.save(l1);
//        session.remove(l1);
        Laptop_Pesistence l2 = new Laptop_Pesistence();
        l2.setLid(50);
        l2.setBrand("apple");
//        session.update(l2);
        session.remove(l2);
        session.getTransaction().commit();
//        session.evict(l1);
//        l1.setPrice(660);
        session.close();
        
    }
}
