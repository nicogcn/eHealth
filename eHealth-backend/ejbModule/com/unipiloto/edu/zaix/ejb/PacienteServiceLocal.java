package com.unipiloto.edu.zaix.ejb;

import java.util.List;
import javax.ejb.Local;
import com.unipiloto.edu.zaix.entities.Paciente;
import com.unipiloto.edu.zaix.entities.Reporte;

@Local
public interface PacienteServiceLocal {

	void addPaciente(Paciente pacienteInstance);

	void editPaciente(Paciente pacienteInstance);

	Paciente deletePaciente(int id);

	Paciente findById(int id);

	List<Paciente> findAllPacientes();

	List<Reporte> reportesOfPaciente(int id);
}