package com.unipiloto.edu.zaix.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;


/**
 * The persistent class for the enfermedades database table.
 * 
 */
@XmlRootElement(name="Enfermedad")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Table(name="enfermedades")
@NamedQuery(name="Enfermedade.findAll", query="SELECT e FROM Enfermedade e")
public class Enfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnfermedad;

	private String nombre;

	//bi-directional many-to-one association to Paciente	
	@OneToMany(mappedBy="enfermedade", fetch=FetchType.EAGER)
	private List<Paciente> pacientes;

	public Enfermedade() {
	}

	@XmlElement
	public int getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	@XmlElement
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlTransient
	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setEnfermedade(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setEnfermedade(null);

		return paciente;
	}

}