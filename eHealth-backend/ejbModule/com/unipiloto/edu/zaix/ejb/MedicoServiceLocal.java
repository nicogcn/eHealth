package com.unipiloto.edu.zaix.ejb;

import javax.ejb.Local;

import com.unipiloto.edu.zaix.entities.Medico;

@Local
public interface MedicoServiceLocal {
	
	Medico getById(int id);	

}
