package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")
@NamedQueries(value = {
		@NamedQuery(
				name="Permiso.findAll",
				query="SELECT p FROM Permiso p"),
		@NamedQuery(
				name = "Permiso.findPKComp",
				query = "SELECT p FROM Permiso p WHERE p.id.idUsuario = :idU AND p.id.desdeFecha = :desdeF"),
		@NamedQuery(
				name = "Permiso.findXEmpleado",
				query = "SELECT p FROM Permiso p WHERE p.id.idUsuario = :idU"),
		@NamedQuery(
				name = "Permiso.findXFecha",
				query = "SELECT p FROM Permiso p WHERE p.id.desdeFecha = :desdeF"),
})
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermisoPK id;

	private byte estado;

	private String hastaFecha;

	private String tipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario", insertable=false, updatable=false)
	private Usuario usuario;

	public Permiso() {
	}

	public PermisoPK getId() {
		return this.id;
	}

	public void setId(PermisoPK id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getHastaFecha() {
		return this.hastaFecha;
	}

	public void setHastaFecha(String hastaFecha) {
		this.hastaFecha = hastaFecha;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}