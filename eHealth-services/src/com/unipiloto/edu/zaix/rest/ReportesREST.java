package com.unipiloto.edu.zaix.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.unipiloto.edu.zaix.ejb.PacienteServiceLocal;
import com.unipiloto.edu.zaix.ejb.ReporteServiceLocal;
import com.unipiloto.edu.zaix.entities.Reporte;

@RequestScoped
@Path("/reportes")
public class ReportesREST {
	@EJB
	private ReporteServiceLocal rs;
	
	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reporte newReporte(Reporte repInstance){
		rs.addReporte(repInstance);
		return repInstance;
	}
	
	@EJB
	private PacienteServiceLocal ps;
	
	@GET
	@Path("Reportes-of/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reporte> reportesOfPaciente(@PathParam(value="id") int id){
		return ps.reportesOfPaciente(id);
	}
}