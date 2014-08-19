package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the servicio_extra database table.
 * 
 */
@Entity
@Table(name="servicio_extra")
@NamedQuery(name="ServicioExtra.findAll", query="SELECT s FROM ServicioExtra s")
public class ServicioExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idServicio_Extra;

	@Column(name="Costo")
	private int costo;

	@Column(name="Descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Horario")
	private Date horario;

	//bi-directional many-to-one association to Habitacione
	@ManyToOne//(cascade = {CascadeType.ALL})
	@JoinColumn(name="Habitaciones_idHabitaciones"/*, insertable=false, updatable=false*/)
	private Habitacione habitacione;

	public ServicioExtra() {
	}

	public int getIdServicio_Extra() {
		return this.idServicio_Extra;
	}

	public void setIdServicio_Extra(int idServicio_Extra) {
		this.idServicio_Extra = idServicio_Extra;
	}

	public int getCosto() {
		return this.costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Habitacione getHabitacione() {
		return this.habitacione;
	}

	public void setHabitacione(Habitacione habitacione) {
		this.habitacione = habitacione;
	}

}