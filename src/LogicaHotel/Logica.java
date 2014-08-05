package LogicaHotel;
import java.util.ArrayList;
import java.util.List;

import comu.ServicioCadena_Hotelera;
import comu.ServicioEntidad;
import entidades.Cadena_Hotelera;
import entidades.Hotel;
import entidades.Usuario;
public class Logica {
	
	ServicioEntidad<Cadena_Hotelera> ServCadena = new ServicioEntidad<Cadena_Hotelera>() {
		final long serialVersionUID = 1L;
	};
	ServicioEntidad<Hotel> ServHotel = new ServicioEntidad<Hotel>() {
		final long serialVersionUID = 1L;
	};
	public void crearcadena(){
	//inicio
			ServicioEntidad<Hotel> hotels = new ServicioEntidad<Hotel>() {
				private static final long serialVersionUID = 1L;
			};
			Cadena_Hotelera cadenanueva = new Cadena_Hotelera();
			cadenanueva.setIdCadena_Hotelera(18);
			cadenanueva.setNombre("tierno");
			List<Hotel> hoteles = new ArrayList<Hotel>();
			cadenanueva.setHotels(hoteles);
			ServCadena.insertar(cadenanueva);
		//fin
			}
	
	public void AgregarHotelaCadena(Hotel hotel, int i){
		//inicio
				ServicioCadena_Hotelera sch = new ServicioCadena_Hotelera();	
				sch.startEntityManager();
				Cadena_Hotelera CH = sch.buscar(i);
				CH.getHotels().add(hotel);
				sch.actualizar(CH);
				sch.closeEntityManager();
				}
	public void BorrarCadena(){
		//inicio
				ServicioCadena_Hotelera sch = new ServicioCadena_Hotelera();
				sch.startEntityManager();
				sch.borrar(18);
				sch.closeEntityManager();
				}
	
	
}
