package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cadena_Hotelera database table.
 * 
 */
@Entity
@NamedQuery(name="Cadena_Hotelera.findAll", query="SELECT c FROM Cadena_Hotelera c")
public class Cadena_Hotelera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCadena_Hotelera;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="cadenaHotelera")
	private List<Hotel> hotels;

	public Cadena_Hotelera() {
	}

	public int getIdCadena_Hotelera() {
		return this.idCadena_Hotelera;
	}

	public void setIdCadena_Hotelera(int idCadena_Hotelera) {
		this.idCadena_Hotelera = idCadena_Hotelera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setCadenaHotelera(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setCadenaHotelera(null);

		return hotel;
	}

}