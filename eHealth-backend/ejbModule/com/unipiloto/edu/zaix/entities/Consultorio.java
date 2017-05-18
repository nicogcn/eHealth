package com.unipiloto.edu.zaix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consultorios database table.
 * 
 */
@Entity
@Table(name="consultorios")
@NamedQuery(name="Consultorio.findAll", query="SELECT c FROM Consultorio c")
public class Consultorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idConsultorio;

	private int consultorio;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="consultorioBean")
	private List<Cita> citas;

	public Consultorio() {
	}

	public int getIdConsultorio() {
		return this.idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getConsultorio() {
		return this.consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setConsultorioBean(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setConsultorioBean(null);

		return cita;
	}

}