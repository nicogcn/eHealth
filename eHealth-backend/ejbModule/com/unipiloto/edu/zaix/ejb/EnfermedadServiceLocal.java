package com.unipiloto.edu.zaix.ejb;

import java.util.List;
import javax.ejb.Local;
import com.unipiloto.edu.zaix.entities.Enfermedade;;

@Local
public interface EnfermedadServiceLocal {	
	List<Enfermedade> findAll();
}