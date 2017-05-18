package com.unipiloto.edu.zaix.ejb;

import javax.ejb.Local;

import com.unipiloto.edu.zaix.entities.Consultorio;

@Local
public interface ConsultorioServiceLocal {
	
	Consultorio getById(int id);	

}
