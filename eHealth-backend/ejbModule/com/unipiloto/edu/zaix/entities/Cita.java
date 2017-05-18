package com.unipiloto.edu.zaix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCita;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date solicitada;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to Consultorio
	@ManyToOne
	@JoinColumn(name="consultorio")
	private Consultorio consultorioBean;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="medico")
	private Medico medicoBean;

	public Cita() {
	}

	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getSolicitada() {
		return this.solicitada;
	}

	public void setSolicitada(Date solicitada) {
		this.solicitada = solicitada;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public Consultorio getConsultorioBean() {
		return this.consultorioBean;
	}

	public void setConsultorioBean(Consultorio consultorioBean) {
		this.consultorioBean = consultorioBean;
	}

	public Medico getMedicoBean() {
		return this.medicoBean;
	}

	public void setMedicoBean(Medico medicoBean) {
		this.medicoBean = medicoBean;
	}

}