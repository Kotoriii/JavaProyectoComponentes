package decorador.planilla;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ControlHorarios;

import comu.ServicioCadena_Hotelera;
import comu.ServicioEntidad;
import comu.Servicio_ControlHorario;
import entidades.Cadena_Hotelera;
import entidades.Controlhorario;
import entidades.ControlhorarioPK;
import entidades.Hotel;
import entidades.Usuario;
import LogicaHotel.Logica;

;

/**
 * 
 * @author Deiver Kiel
 */
public class testDecorador {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		test_Control_Horarios();
		// ServicioEntidad<Usuario> su = new ServicioEntidad<Usuario>() {
		// final long serialVersionUID = 1L;

		// };
		/*
		 * Logica l = new Logica(); ServicioCadena_Hotelera
		 * ServicioCadena_Hotelera = new ServicioCadena_Hotelera() { private
		 * static final long serialVersionUID = 1L; }; Cadena_Hotelera
		 * cadenanueva = new Cadena_Hotelera();
		 * cadenanueva.setIdCadena_Hotelera(20);
		 * cadenanueva.setNombre("Campeonizar"); cadenanueva.setHotels(new
		 * ArrayList<Hotel>());
		 * 
		 * Hotel hotel = new Hotel(); hotel.setCadenaHotelera(cadenanueva);
		 * hotel.setIdHotel(11); hotel.setNombre("Campeon2");
		 * hotel.setUbicacion("San Jose");
		 * 
		 * cadenanueva.getHotels().add(hotel);
		 * 
		 * ServicioCadena_Hotelera.insertar(cadenanueva);
		 * 
		 * 
		 * //Cadena_Hotelera cadenanueva2 = ServicioCadena_Hotelera.buscar(14);
		 * ServicioCadena_Hotelera.borrar(18);
		 * //System.out.print(""+cadenanueva2.getNombre());
		 * ServicioCadena_Hotelera.closeEntityManager();
		 * //ServicioCadena_Hotelera.borrar(10); // l.AgregarHotelaCadena();
		 */
		/*
		 * //inicio ServicioEntidad<Hotel> hotels = new ServicioEntidad<Hotel>()
		 * { private static final long serialVersionUID = 1L; }; Cadena_Hotelera
		 * cadenanueva = new Cadena_Hotelera();
		 * cadenanueva.setIdCadena_Hotelera(17);
		 * cadenanueva.setNombre("tierno");
		 * 
		 * List<Hotel> hoteles = new ArrayList<Hotel>(); Hotel hotel = new
		 * Hotel(); hotel.setCadenaHotelera(cadenanueva); hotel.setIdHotel(8);
		 * hotel.setNombre("Tambores"); hotel.setUbicacion("Limon");
		 * 
		 * hotels.insertar(hotel); //fin
		 */

		// inicio
		/*
		 * ServicioEntidad<Hotel> hotels2 = new ServicioEntidad<Hotel>() {
		 * private static final long serialVersionUID = 1L; };
		 * ServicioCadena_Hotelera ServicioCadena_Hotelera = new
		 * ServicioCadena_Hotelera() { private static final long
		 * serialVersionUID = 1L; };
		 * 
		 * 
		 * Cadena_Hotelera cadenanueva2 = ServicioCadena_Hotelera.buscar(14);
		 * 
		 * System.out.print(""+cadenanueva2.getNombre()); List<Hotel> hoteles2 =
		 * cadenanueva2.getHotels(); Hotel hotel2 = new Hotel();
		 * hotel2.setCadenaHotelera(cadenanueva2); hotel2.setIdHotel(9);
		 * hotel2.setNombre("crayon"); hotel2.setUbicacion("Puntarenas");
		 * 
		 * cadenanueva2.addHotel(hotel2);
		 * ServicioCadena_Hotelera.actualizar(cadenanueva2);
		 */

		// ServicioCadena_Hotelera.closeEntityManager();
		// cadenanueva2 = ServicioCadena_Hotelera(, 1);

		/*
		 * List<Hotel> hoteles2 = cadenanueva2.getHotels(); Hotel hotel2 = new
		 * Hotel(); hotel2.setCadenaHotelera(cadenanueva2);
		 * hotel2.setIdHotel(9); hotel2.setNombre("crayon");
		 * hotel2.setUbicacion("Puntarenas");
		 * 
		 * hotels2.insertar(hotel2); //fin
		 */

		/*
		 * cadena2.startEntityManager(); Cadena_Hotelera cadenanueva= new
		 * Cadena_Hotelera(); Hotel hotel = new Hotel();
		 * hotel.setCadenaHotelera(cadenanueva); hotel.setIdHotel(1);
		 * hotel.setNombre("Tambor"); hotel.setUbicacion("Puntarenas");
		 * cadenanueva= cadena2.buscar(cadenanueva, 1);
		 * cadenanueva.addHotel(hotel); cadena2.actualizar(cadenanueva);
		 * cadena2.closeEntityManager();
		 */

		/*
		 * su.startEntityManager(); Usuario usuario = new Usuario(); usuario =
		 * su.buscar(usuario, 1); su.closeEntityManager();
		 * System.out.println(usuario.getNombre());
		 * 
		 * ControlHorarios p = ControlHorarios.getInstancia();
		 * p.iniciarSesionXelDia(usuario);
		 * 
		 * /* Salario salario1 = new Base();
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(450));
		 * 
		 * salario1 = new Bono(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(500));
		 * 
		 * salario1 = new Bono(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(5));
		 * 
		 * salario1 = new Extra(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(0.5));
		 * 
		 * salario1 = new Viaticos(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(300.06));
		 * 
		 * salario1 = new CCSS(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(0));
		 * 
		 * salario1 = new Prestamo(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(600));
		 * 
		 * salario1 = new Seguro(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(250));
		 */
	}

	public static void test_Control_Horarios() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Servicio_ControlHorario serv = new Servicio_ControlHorario();

		Controlhorario control;

		ControlhorarioPK controlPK = new ControlhorarioPK();

		controlPK.setFecha("2014-07-18");
		controlPK.setIdUsuario(1);

		control = serv.buscar_x_id(controlPK);

		System.out.println("El id del usuario es: "
				+ control.getId().getIdUsuario());
		System.out.println("El dia " + control.getId().getFecha()
				+ " el usuario entro a las " + control.getHoraEntrada()
				+ " y salio a las " + control.getHoraSalida());

	}
}
