package com.robin.springJDBCDemo.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.robin.springJDBCDemo.model.Alien;

@Repository
public class AlienRepo {
	
	private JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Alien alien) {
		
		String sql = "insert into alien (id, name, tech) values(?,?,?)";
//		template.update(sql,alien.getId(),alien.getName(),alien.getTech());
		int row =template.update(sql,alien.getId(),alien.getName(),alien.getTech());
		System.out.println(row + " rows Affected");
	}
	
	public List<Alien> findAll(){
		String sql = "select * from alien";
		
		//RowMapper Is Functional Interface
		RowMapper<Alien> mapper = new RowMapper<Alien>() {
			
			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTech(rs.getString(3));
				return a;
			}
		};
		List<Alien> aliens = template.query(sql,mapper);
		return aliens;
	}
}
