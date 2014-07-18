package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the horas database table.
 * 
 */
@Entity
@Table(name="horas")
@NamedQuery(name="Hora.findAll", query="SELECT h FROM Hora h")
public class Hora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuario;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="HorasExtra")
	private int horasExtra;

	@Column(name="HorasNormales")
	private int horasNormales;

	//bi-directional one-to-one association to Usuario
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Hora() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	public int getHorasNormales() {
		return this.horasNormales;
	}

	public void setHorasNormales(int horasNormales) {
		this.horasNormales = horasNormales;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}