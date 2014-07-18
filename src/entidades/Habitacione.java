package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the habitaciones database table.
 * 
 */
@Entity
@Table(name="habitaciones")
@NamedQuery(name="Habitacione.findAll", query="SELECT h FROM Habitacione h")
public class Habitacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idHabitaciones;

	//bi-directional many-to-one association to Elemento
	@OneToMany(mappedBy="habitacione")
	private List<Elemento> elementos;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="Hotel_idHotel")
	private Hotel hotel;

	//bi-directional many-to-one association to ServicioExtra
	@OneToMany(mappedBy="habitacione")
	private List<ServicioExtra> servicioExtras;

	public Habitacione() {
	}

	public int getIdHabitaciones() {
		return this.idHabitaciones;
	}

	public void setIdHabitaciones(int idHabitaciones) {
		this.idHabitaciones = idHabitaciones;
	}

	public List<Elemento> getElementos() {
		return this.elementos;
	}

	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}

	public Elemento addElemento(Elemento elemento) {
		getElementos().add(elemento);
		elemento.setHabitacione(this);

		return elemento;
	}

	public Elemento removeElemento(Elemento elemento) {
		getElementos().remove(elemento);
		elemento.setHabitacione(null);

		return elemento;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<ServicioExtra> getServicioExtras() {
		return this.servicioExtras;
	}

	public void setServicioExtras(List<ServicioExtra> servicioExtras) {
		this.servicioExtras = servicioExtras;
	}

	public ServicioExtra addServicioExtra(ServicioExtra servicioExtra) {
		getServicioExtras().add(servicioExtra);
		servicioExtra.setHabitacione(this);

		return servicioExtra;
	}

	public ServicioExtra removeServicioExtra(ServicioExtra servicioExtra) {
		getServicioExtras().remove(servicioExtra);
		servicioExtra.setHabitacione(null);

		return servicioExtra;
	}

}