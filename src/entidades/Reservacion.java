package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the reservacion database table.
 * 
 */
@Entity
@Table(name="reservacion")
@NamedQuery(name="Reservacion.findAll", query="SELECT r FROM Reservacion r")
public class Reservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idReservacion;

	@Column(name="Costo")
	private int costo;

	@Column(name="Fecha_Llegada")
	private String fecha_Llegada;

	@Column(name="Fecha_Reserva")
	private String fecha_Reserva;

	@Column(name="Fecha_Salida")
	private String fecha_Salida;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="reservacion")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="Cliente_idCliente", insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="Hotel_idHotel", insertable=false, updatable=false)
	private Hotel hotel;

	public Reservacion() {
	}

	public int getIdReservacion() {
		return this.idReservacion;
	}

	public void setIdReservacion(int idReservacion) {
		this.idReservacion = idReservacion;
	}

	public int getCosto() {
		return this.costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getFecha_Llegada() {
		return this.fecha_Llegada;
	}

	public void setFecha_Llegada(String fecha_Llegada) {
		this.fecha_Llegada = fecha_Llegada;
	}

	public String getFecha_Reserva() {
		return this.fecha_Reserva;
	}

	public void setFecha_Reserva(String fecha_Reserva) {
		this.fecha_Reserva = fecha_Reserva;
	}

	public String getFecha_Salida() {
		return this.fecha_Salida;
	}

	public void setFecha_Salida(String fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setReservacion(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setReservacion(null);

		return factura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}