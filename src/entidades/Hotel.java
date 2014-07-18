package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idHotel;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Ubicacion")
	private String ubicacion;

	//bi-directional many-to-one association to Habitacione
	@OneToMany(mappedBy="hotel", cascade={CascadeType.ALL})
	private List<Habitacione> habitaciones;

	//bi-directional many-to-one association to Cadena_Hotelera
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="Cadena_Hotelera_idCadena_Hotelera")
	private Cadena_Hotelera cadenaHotelera;

	//bi-directional many-to-one association to Reservacion
	@OneToMany(mappedBy="hotel")
	private List<Reservacion> reservacions;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="hotel")
	private List<Servicio> servicios;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="hotel")
	private List<Usuario> usuarios;

	public Hotel() {
	}

	public int getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Habitacione> getHabitaciones() {
		return this.habitaciones;
	}

	public void setHabitaciones(List<Habitacione> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Habitacione addHabitacione(Habitacione habitacione) {
		getHabitaciones().add(habitacione);
		habitacione.setHotel(this);

		return habitacione;
	}

	public Habitacione removeHabitacione(Habitacione habitacione) {
		getHabitaciones().remove(habitacione);
		habitacione.setHotel(null);

		return habitacione;
	}

	public Cadena_Hotelera getCadenaHotelera() {
		return this.cadenaHotelera;
	}

	public void setCadenaHotelera(Cadena_Hotelera cadenaHotelera) {
		this.cadenaHotelera = cadenaHotelera;
	}

	public List<Reservacion> getReservacions() {
		return this.reservacions;
	}

	public void setReservacions(List<Reservacion> reservacions) {
		this.reservacions = reservacions;
	}

	public Reservacion addReservacion(Reservacion reservacion) {
		getReservacions().add(reservacion);
		reservacion.setHotel(this);

		return reservacion;
	}

	public Reservacion removeReservacion(Reservacion reservacion) {
		getReservacions().remove(reservacion);
		reservacion.setHotel(null);

		return reservacion;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setHotel(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setHotel(null);

		return servicio;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setHotel(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setHotel(null);

		return usuario;
	}

}