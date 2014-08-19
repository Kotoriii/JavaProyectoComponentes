package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shiftreports database table.
 * 
 */
@Entity
@Table(name="shiftreports")
@NamedQuery(name="Shiftreport.findAll", query="SELECT s FROM Shiftreport s")
public class Shiftreport implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShiftreportPK id;

	private String reporte;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario", insertable=false, updatable=false)
	private Usuario usuario;

	public Shiftreport() {
	}

	public ShiftreportPK getId() {
		return this.id;
	}

	public void setId(ShiftreportPK id) {
		this.id = id;
	}

	public String getReporte() {
		return this.reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}