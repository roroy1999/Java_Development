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
public class HQLApp 
{
    public static void main( String[] args )
    {
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Student_HQL.class);        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();       
        session.beginTransaction();
        //To generate rows
//        Random r = new Random();
//        for(int i=1;i<=50;i++) {
//        	Student_HQL s = new Student_HQL();
//        	s.setRollno(i);
//        	s.setName("Name"+i);
//        	s.setMarks(r.nextInt(100));// Specifing Mark should not more then 100
//        	session.save(s);
//        }
        //Query<Student_HQL> rq = session.createQuery("from Student_HQL where rollno = 7");
//        Query rq = session.createQuery("select rollno ,name, marks from Student_HQL where rollno = 7");
//        Query rq = session.createQuery("select rollno ,name, marks from Student_HQL");
//        Query rq = session.createQuery("select sum(marks) from Student_HQL s where s.marks>60");
        //Query<Student_HQL> rq = session.createQuery("from student_hql"); // Wont work since all are small
//        for(Student_HQL std : rq.list()) {
//        	System.out.println(std);
//        }
//        Object[] student = (Object[]) rq.uniqueResult();
//        List<Object[]> students = (List<Object[]>) rq.list();
//        for(Object[] student : students) {
//        	System.out.println(student[0]+" : "+student[1]+" : "+ student[2]);
//        }
//        List students = (List) rq.list();
//        for(Object student : students) {
//        	System.out.println(student);
//        }
        SQLQuery query = session.createSQLQuery("select name, marks from Student_hql where marks>60");
        //query.addEntity(Student_HQL.class);
//        List<Student_HQL> l1 = query.list();
//        for(Student_HQL std : l1) {
//        	System.out.println(std);
//        }
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Map> students = query.list();
        for(Map ma : students) {
        	System.out.println(ma.get("name")+ " : " + ma.get("marks"));
        }
        session.getTransaction().commit();
        session.close();
        
    }
}
