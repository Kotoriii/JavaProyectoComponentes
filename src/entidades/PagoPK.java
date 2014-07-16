package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pagos database table.
 * 
 */
@Embeddable
public class PagoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUsuario;

	private String fecha;

	public PagoPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFecha() {
		return this.fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PagoPK)) {
			return false;
		}
		PagoPK castOther = (PagoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.fecha.equals(castOther.fecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.fecha.hashCode();
		
		return hash;
	}
}