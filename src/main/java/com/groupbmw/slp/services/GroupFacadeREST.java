package com.groupbmw.slp.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.groupbmw.slp.entities.Group;

/**
 * Session Bean implementation class GroupFacadeREST
 */
@Stateless
@LocalBean
@Path("groups")
public class GroupFacadeREST extends AbstractFacade<Group> {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "SalaryBonusBmw")
    private EntityManager em;
    public GroupFacadeREST() {
        // TODO Auto-generated constructor stub
    	super(Group.class);
    }
       
    

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Group> findAll() {
        return super.findAll();
    }
	
	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Group find(@PathParam("id") Long id) {
        return super.find(id);
    }
	
	@GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Group> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
	
	 @POST
	 @Override
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 public void create(Group entity) {
		 super.create(entity);
	 }
	 
	 @PUT
	 @Path("{id}")
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 public void edit(@PathParam("id") Long id, Group entity) {
	        super.edit(entity);
	 }
	 
	 @DELETE
	 @Path("{id}")
	 public void remove(@PathParam("id") int id) {
	        super.remove(super.find(id));
	 }
	 
	 @GET
	 @Path("count")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String countREST() {
		 return String.valueOf(super.count());
	 }
	
	

}
