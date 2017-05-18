package com.unipiloto.edu.zaix.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.unipiloto.edu.zaix.ejb.EnfermedadServiceLocal;
import com.unipiloto.edu.zaix.ejb.PacienteServiceLocal;
import com.unipiloto.edu.zaix.entities.Enfermedade;
import com.unipiloto.edu.zaix.entities.Paciente;

@Path("/pacientes")
public class PacienteREST {
	
	@EJB
	private EnfermedadServiceLocal es;
	
	@GET
	@Path("/enfermedades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enfermedade> enfermedades(){
		List<Enfermedade> lista = es.findAll();
		for (Enfermedade enfermedade : lista) {
			System.out.println(enfermedade.getIdEnfermedad());
			System.out.println(enfermedade.getNombre());
			System.out.println(enfermedade.getPacientes().get(0).getNombre());
		}
		return es.findAll();
	}
	
	@EJB 
	private PacienteServiceLocal ps;
	//CREATE
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Paciente newPaciente(Paciente pInstance){		
		ps.addPaciente(pInstance);
		System.out.println(pInstance.getNombre());
		
		return pInstance;
	}
	//READ
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> allPacientes(){
		return ps.findAllPacientes();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente find (@PathParam(value="id") int id){
		return ps.findById(id);
	}
	//UPDATE	
	@PUT
	@Path("/modify/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Paciente modifyPaciente(@PathParam(value="id") int id, Paciente pInstance){
		pInstance.setIdPaciente(id);
		ps.editPaciente(pInstance);
		return pInstance;
	}
	//DELETE
	
	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente removePaciente(@PathParam(value="id") int id){		
		return ps.deletePaciente(id);		
	}
}