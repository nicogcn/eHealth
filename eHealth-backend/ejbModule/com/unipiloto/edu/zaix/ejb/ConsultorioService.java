package com.unipiloto.edu.zaix.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipiloto.edu.zaix.entities.Consultorio;

/**
 * Session Bean implementation class ConsultorioService
 */
@Stateless
@LocalBean
public class ConsultorioService implements ConsultorioServiceLocal {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ConsultorioService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Consultorio getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Consultorio.class, id);
	}

	

}
