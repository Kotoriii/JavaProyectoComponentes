package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elemento database table.
 * 
 */
@Entity
@Table(name="elemento")
@NamedQuery(name="Elemento.findAll", query="SELECT e FROM Elemento e")
public class Elemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idElemento;

	@Column(name="Descripcion_Elemento")
	private String descripcion_Elemento;

	//bi-directional many-to-one association to Habitacione
	@ManyToOne
	@JoinColumn(name="Habitaciones_idHabitaciones")
	private Habitacione habitacione;

	public Elemento() {
	}

	public int getIdElemento() {
		return this.idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public String getDescripcion_Elemento() {
		return this.descripcion_Elemento;
	}

	public void setDescripcion_Elemento(String descripcion_Elemento) {
		this.descripcion_Elemento = descripcion_Elemento;
	}

	public Habitacione getHabitacione() {
		return this.habitacione;
	}

	public void setHabitacione(Habitacione habitacione) {
		this.habitacione = habitacione;
	}

}