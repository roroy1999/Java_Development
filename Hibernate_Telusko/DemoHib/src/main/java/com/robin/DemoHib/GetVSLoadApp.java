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
public class GetVSLoadApp 
{
    public static void main( String[] args )
    {
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop_Pesistence.class);        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();       
        session.beginTransaction();
        Laptop_Pesistence lap1 = session.get(Laptop_Pesistence.class, 102);
        //System.out.println(lap1);
        Laptop_Pesistence lap2 = session.load(Laptop_Pesistence.class,102);
        //System.out.println(lap2);
        session.getTransaction().commit();
        session.close();
        
    }
}
