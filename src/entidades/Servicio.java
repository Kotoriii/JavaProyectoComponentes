package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idServicios;

	@Column(name="Costo")
	private int costo;

	@Column(name="Descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Horario")
	private Date horario;

	//bi-directional many-to-many association to Cliente
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
		name="cliente_has_servicios"
		, joinColumns={
			@JoinColumn(name="Servicios_idServicios")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Cliente_idCliente")
			}
		)
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="Hotel_idHotel")
	private Hotel hotel;

	public Servicio() {
	}

	public int getIdServicios() {
		return this.idServicios;
	}

	public void setIdServicios(int idServicios) {
		this.idServicios = idServicios;
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

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}