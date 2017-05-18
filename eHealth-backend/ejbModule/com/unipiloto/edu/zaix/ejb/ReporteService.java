package com.unipiloto.edu.zaix.ejb;

import java.util.Calendar;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.unipiloto.edu.zaix.entities.Reporte;

/**
 * Session Bean implementation class ReporteService
 */
@Stateless
@LocalBean
public class ReporteService implements ReporteServiceLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ReporteService() {}
	@Override
	public void addReporte(Reporte reporteInstance) {
		reporteInstance.setFecha(Calendar.getInstance().getTime());
		em.persist(reporteInstance);		
	}
}