package entidades;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PagoPK id;

	private int cantidad;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idUsuario", insertable=false, updatable=false)
	private Usuario usuario;

	public Pago() {
	}

	public PagoPK getId() {
		return this.id;
	}

	public void setId(PagoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}