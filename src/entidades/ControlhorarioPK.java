package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the controlhorarios database table.
 * 
 */
@Embeddable
public class ControlhorarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUsuario;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	public ControlhorarioPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ControlhorarioPK)) {
			return false;
		}
		ControlhorarioPK castOther = (ControlhorarioPK)other;
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