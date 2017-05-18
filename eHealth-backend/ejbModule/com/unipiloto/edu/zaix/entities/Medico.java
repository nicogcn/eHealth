package com.unipiloto.edu.zaix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMedico;

	private String apellido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicia;

	private String nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date termina;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="medicoBean")
	private List<Cita> citas;

	public Medico() {
	}

	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getInicia() {
		return this.inicia;
	}

	public void setInicia(Date inicia) {
		this.inicia = inicia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getTermina() {
		return this.termina;
	}

	public void setTermina(Date termina) {
		this.termina = termina;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setMedicoBean(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMedicoBean(null);

		return cita;
	}

}