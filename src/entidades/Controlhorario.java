package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the controlhorarios database table.
 * 
 */
@Entity
@Table(name="controlhorarios")
@NamedQuery(name="Controlhorario.findAll", query="SELECT c FROM Controlhorario c")
public class Controlhorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ControlhorarioPK id;

	private Time horaEntrada;

	private Time horaSalida;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Controlhorario() {
	}

	public ControlhorarioPK getId() {
		return this.id;
	}

	public void setId(ControlhorarioPK id) {
		this.id = id;
	}

	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}