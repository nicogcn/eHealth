package com.unipiloto.edu.zaix.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.unipiloto.edu.zaix.entities.Enfermedade;

/**
 * Session Bean implementation class EnfermedadService
 */
@Stateless
@LocalBean
public class EnfermedadService implements EnfermedadServiceLocal {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public EnfermedadService() {}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enfermedade> findAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Enfermedade.findAll").getResultList();
	}
}