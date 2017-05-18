package com.unipiloto.edu.zaix.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.unipiloto.edu.zaix.entities.Paciente;
import com.unipiloto.edu.zaix.entities.Reporte;

/**
 * Session Bean implementation class PacienteService
 */
@Stateless
@LocalBean
public class PacienteService implements PacienteServiceLocal {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PacienteService() {}

    @Override
	public void addPaciente(Paciente pacienteInstance) {    	
		em.persist(pacienteInstance);
	}

	@Override
	public void editPaciente(Paciente pacienteInstance) {
		em.merge(pacienteInstance);	
	}

	@Override
	public Paciente deletePaciente(int id) {
		Paciente pacienteInstance = em.find(Paciente.class, id);
		em.remove(pacienteInstance);
		return pacienteInstance;
	}

	@Override
	public Paciente findById(int id) {		
		return em.find(Paciente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> findAllPacientes() {
		return em.createNamedQuery("Paciente.findAll").getResultList();
	}

	@Override
	public List<Reporte> reportesOfPaciente(int id) {
		return findById(id).getReportes();
	}
}