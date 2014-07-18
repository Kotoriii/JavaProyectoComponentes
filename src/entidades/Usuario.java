package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contrasenna;

	private String correo;

	private String estado;

	private Time horaEntrada;

	private Time horaSalida;

	@Lob
	private String keywords;

	private String nombre;

	private int precioPorHora;

	private String rol;

	private int salario;

	//bi-directional many-to-one association to Controlhorario
	@OneToMany(mappedBy="usuario")
	private List<Controlhorario> controlhorarios;

	//bi-directional one-to-one association to Hora
	@OneToOne(mappedBy="usuario")
	private Hora hora;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="usuario")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="usuario")
	private List<Permiso> permisos;

	//bi-directional many-to-one association to Shiftreport
	@OneToMany(mappedBy="usuario")
	private List<Shiftreport> shiftreports;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idHotel")
	private Hotel hotel;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasenna() {
		return this.contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioPorHora() {
		return this.precioPorHora;
	}

	public void setPrecioPorHora(int precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public List<Controlhorario> getControlhorarios() {
		return this.controlhorarios;
	}

	public void setControlhorarios(List<Controlhorario> controlhorarios) {
		this.controlhorarios = controlhorarios;
	}

	public Controlhorario addControlhorario(Controlhorario controlhorario) {
		getControlhorarios().add(controlhorario);
		controlhorario.setUsuario(this);

		return controlhorario;
	}

	public Controlhorario removeControlhorario(Controlhorario controlhorario) {
		getControlhorarios().remove(controlhorario);
		controlhorario.setUsuario(null);

		return controlhorario;
	}

	public Hora getHora() {
		return this.hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setUsuario(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setUsuario(null);

		return pago;
	}

	public List<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Permiso addPermiso(Permiso permiso) {
		getPermisos().add(permiso);
		permiso.setUsuario(this);

		return permiso;
	}

	public Permiso removePermiso(Permiso permiso) {
		getPermisos().remove(permiso);
		permiso.setUsuario(null);

		return permiso;
	}

	public List<Shiftreport> getShiftreports() {
		return this.shiftreports;
	}

	public void setShiftreports(List<Shiftreport> shiftreports) {
		this.shiftreports = shiftreports;
	}

	public Shiftreport addShiftreport(Shiftreport shiftreport) {
		getShiftreports().add(shiftreport);
		shiftreport.setUsuario(this);

		return shiftreport;
	}

	public Shiftreport removeShiftreport(Shiftreport shiftreport) {
		getShiftreports().remove(shiftreport);
		shiftreport.setUsuario(null);

		return shiftreport;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}