/**
 * @NamedQuerys(value= {
 * 	@NamedQuery(
 * 		name ewr
 * 			Select d from usuario d where d.nombre like :nombreParam order by id 
 * 			   )
 * }
 * TypedQuery<usuario> q = em.createNamedQuery ("erw", Usuario.class);
 * q.setParameter(parametro1, parametro2);
 * return query.getResultList  ( o query.getSingleResult()  )
 * 
 * */

package entidades;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQueries(value = {
		@NamedQuery(
				name="Usuario.findAll", 
				query="SELECT u FROM Usuario u"),
		@NamedQuery(
				name = "Usuario.findNombre",
				query = "SELECT u FROM Usuario u WHERE u.nombre = :nombrePar"),
		@NamedQuery(
				name = "Usuario.findEstado",
				query = "SELECT u FROM Usuario u WHERE u.estado = :estadoPar")	
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contrasenna;

	private String correo;

	private String estado;

	private Time horaEntrada;

	private Time horaSalida;
	
	private int idHotel;

	@Lob
	private String keywords;

	private String nombre;

	private int precioPorHora;

	private String rol;

	private int salario;

	// bi-directional many-to-one association to Controlhorario
	@OneToMany(mappedBy = "usuario")
	private List<Controlhorario> controlhorarios;

	// bi-directional one-to-one association to Hora
	@OneToOne(mappedBy = "usuario")
	private Hora hora;

	// bi-directional many-to-one association to Pago
	@OneToMany(mappedBy = "usuario")
	private List<Pago> pagos;

	// bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy = "usuario")
	private List<Permiso> permisos;

	// bi-directional many-to-one association to Shiftreport
	@OneToMany(mappedBy = "usuario")
	private List<Shiftreport> shiftreports;

	// bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name = "idHotel", insertable = false, updatable = false)
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

	public void setHoraEntrada(String horaEntrada) {
		String horas;
        String minutos;
        String segundos;
        if (horaEntrada.length() == 8) {
            horas = horaEntrada.substring(0, 2);
            minutos = horaEntrada.substring(3, 5);
            segundos = horaEntrada.substring(6);
            this.horaEntrada = new Time(Integer.parseInt(horas),
                    Integer.parseInt(minutos), Integer.parseInt(segundos));
        } else {
            System.out.println("ERROR: la hora tiene que ser de 8 digitos... formato HH:MM:SS. Clase: Usuario, metodo: horaEntada");
        }
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		String horas;
        String minutos;
        String segundos;
        if (horaSalida.length() == 8) {
            horas = horaSalida.substring(0, 2);
            minutos = horaSalida.substring(3, 5);
            segundos =horaSalida.substring(6);
            this.horaSalida = new Time(Integer.parseInt(horas),
                    Integer.parseInt(minutos), Integer.parseInt(segundos));
        } else {
            System.out.println("ERROR: la hora tiene que ser de 8 digitos... formato HH:MM:SS . Clase: Usuario, metodo HoraSalida");
        }
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * transforma un string de palabras separas por coma en un array
	 * 
	 */
	public List<String> getKeyword() {
		return Arrays.asList(this.keywords.split("\\s*,\\s*"));
	}

	// Se encarga de recorrer la lista para comparar su contenido con un string
	public boolean comparaKeyword(String _comparar) {
		for (String buscar : getKeyword()) {
			if (buscar.equals(_comparar)) {
				return true;
			}
		}
		return false;
	}

	// Se encarga de convertir la lista en un string
	public String hacerStringKeywords() {
		return getKeywords();
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

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
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

	@Override
	public String toString() {
		return "<tr>" + "<td><h4>"
				+ getId()
				+ "</h4></td>"
				+ "<td><h4>"
				+ getNombre()
				+ "</h4></td>"
				+ "<td><h4>"
				+ getRol()
				+ "</h4></td>"
				+ "<td><h4>"
				+ getSalario()
				+ "</h4></td>"
				+ "<td><h4>"
				+ getEstado()
				+ "</h4></td>"
				+ "<td>"
				+ "<a href="
				+ "administracion.jsp?nombre="
				+ getNombre()
				+ ""
				+ "&id="
				+ getId()
				+ ""
				+ "&puesto="
				+ getRol()
				+ ""
				+ "&salario="
				+ getSalario()
				+ ""
				+ "&pagoHora="
				+ getPrecioPorHora()
				+ ""
				+ "&horaEntrada="
				+ getHoraEntrada()
				+ ""
				+ "&horaSalida="
				+ getHoraSalida()
				+ ""
				+ "&email="
				+ getCorreo()
				+ ""
				+ "&keywords="
				+ hacerStringKeywords()
				+ ""
				+ "&estado="
				+ getEstado()
				+ ">"
				+ "<input type=\"button\"value=\" Modificar \" class=\"btn btn-primary\"</a>"
				+ "</td>" + "</tr>";
	}

}