package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the permisos database table.
 * 
 */
@Embeddable
public class PermisoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUsuario;

	@Temporal(TemporalType.DATE)
	private java.util.Date desdeFecha;

	public PermisoPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public java.util.Date getDesdeFecha() {
		return this.desdeFecha;
	}
	public void setDesdeFecha(java.util.Date desdeFecha) {
		this.desdeFecha = desdeFecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PermisoPK)) {
			return false;
		}
		PermisoPK castOther = (PermisoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.desdeFecha.equals(castOther.desdeFecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.desdeFecha.hashCode();
		
		return hash;
	}
}