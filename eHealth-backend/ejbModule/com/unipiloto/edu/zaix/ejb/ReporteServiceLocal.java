package com.unipiloto.edu.zaix.ejb;

import javax.ejb.Local;

import com.unipiloto.edu.zaix.entities.Reporte;

@Local
public interface ReporteServiceLocal {	
	void addReporte(Reporte reporteInstance);
}