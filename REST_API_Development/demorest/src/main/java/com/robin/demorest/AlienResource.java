package com.robin.demorest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		
	
		return repo.getAliens();
	}
	
	@GET
	@Path("alien")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Alien getAlien(@QueryParam("id") int id) {
	    return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> createAlien(Alien a1) {
		System.out.println(a1);
		
		repo.create(a1);
		return repo.getAliens();
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> updateAlien(Alien a1) {
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0) {
			repo.create(a1);
		}else {
			
			repo.update(a1);
		}
		
		return repo.getAliens();
	}
	
	@DELETE
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien killAlien(@PathParam("id") int id) {
		
		Alien a = repo.getAlien(id);
		
		if(a.getId()!=0) {
			repo.delete(id);
		}
		
		return a;
	}
}
