package com.unipiloto.edu.zaix.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


/**
 * The persistent class for the reporte database table.
 * 
 */
@XmlRootElement(name="Reporte")
@Entity
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReporte;

	private Double agudezaVisual;

	private byte emergencia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private Double frecuencia;

	private Double glucosa;

	private Double latitud;

	private Double longitud;

	private Double presion;

	private Double temperatura;

	//bi-directional many-to-one association to Paciente
	
	@ManyToOne
	@JoinColumn(name="Paciente")
	private Paciente pacienteBean;

	public Reporte() {
	}

	@XmlElement
	public int getIdReporte() {
		return this.idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	@XmlElement
	public Double getAgudezaVisual() {
		return this.agudezaVisual;
	}

	public void setAgudezaVisual(double agudezaVisual) {
		this.agudezaVisual = agudezaVisual;
	}

	@XmlElement
	public byte getEmergencia() {
		return this.emergencia;
	}

	public void setEmergencia(byte emergencia) {
		this.emergencia = emergencia;
	}

	@XmlElement
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@XmlElement
	public Double getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	@XmlElement
	public Double getGlucosa() {
		return this.glucosa;
	}

	public void setGlucosa(double glucosa) {
		this.glucosa = glucosa;
	}

	@XmlElement
	public Double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@XmlElement
	public Double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@XmlElement
	public Double getPresion() {
		return this.presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}

	@XmlElement
	public Double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@XmlElement
	public Paciente getPacienteBean() {
		return this.pacienteBean;
	}

	public void setPacienteBean(Paciente pacienteBean) {
		this.pacienteBean = pacienteBean;
	}

}