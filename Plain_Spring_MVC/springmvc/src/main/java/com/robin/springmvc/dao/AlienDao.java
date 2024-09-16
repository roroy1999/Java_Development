package com.robin.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robin.springmvc.model.Alien;

import javax.transaction.Transactional;

@Component
public class AlienDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Alien> getAliens(){
		Session session = sessionFactory.getCurrentSession();
		List<Alien> alien = session.createQuery("from Alien",Alien.class).list();
		
		return alien;
	}

	@Transactional
	public void addAlien(Alien a) {
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
		
	}

	@Transactional
	public Object getAlien(int aid) {
		
		Session session = sessionFactory.getCurrentSession();
		Alien a = session.get(Alien.class, aid);
		return a;
	}
}
