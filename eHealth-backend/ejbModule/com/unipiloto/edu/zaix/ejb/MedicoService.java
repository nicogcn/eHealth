package com.unipiloto.edu.zaix.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipiloto.edu.zaix.entities.Medico;

/**
 * Session Bean implementation class MedicoService
 */
@Stateless
@LocalBean
public class MedicoService implements MedicoServiceLocal {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public MedicoService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Medico getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Medico.class, id);
	}


}
