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
 * The persistent class for the paciente database table.
 * 
 */
@XmlRootElement(name="Paciente")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPaciente;

	private String apellido;

	private int documento;

	private String nombre;

	private int telefono;

	//bi-directional many-to-one association to Enfermedade
	
	@ManyToOne
	@JoinColumn(name="Enfermedad")
	private Enfermedade enfermedade;

	//bi-directional many-to-one association to Reporte
	
	@OneToMany(mappedBy="pacienteBean", fetch=FetchType.EAGER)
	private List<Reporte> reportes;

	public Paciente() {
	}

	@XmlElement
	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@XmlElement
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@XmlElement
	public int getDocumento() {
		return this.documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	@XmlElement
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@XmlElement
	public Enfermedade getEnfermedade() {
		return this.enfermedade;
	}

	public void setEnfermedade(Enfermedade enfermedade) {
		this.enfermedade = enfermedade;
	}

	@XmlTransient
	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setPacienteBean(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setPacienteBean(null);

		return reporte;
	}

}