package entidades;

import java.sql.Date;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import comu.ServicioHotel;
import comu.ServicioPermiso;
import comu.ServicioUsuario;

public class TesterEntidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ****** EMPLEADO ******//
/*
 		System.out.println("Ejecutando Empleado...");

		// Inicializacion del ServicioUsuario
		ServicioUsuario su = new ServicioUsuario();

		// Busca Hotel por pk para el empleado
		ServicioHotel sh = new ServicioHotel();
		Hotel hotel = sh.buscar(new Hotel(), 1);
		System.out.println("Hotel: " + hotel.getNombre() + "\nUbicacion: "
				+ hotel.getUbicacion() + "\nID: " + hotel.getIdHotel());

		// Nuevo empleado
		Usuario emp = new Usuario();
		emp.setNombre("Marcelo");
		emp.setContrasenna("m123");
		emp.setId(321456);
		emp.setIdHotel(hotel.getIdHotel());
		emp.setRol("Administrador");
		emp.setSalario(600000);
		emp.setPrecioPorHora(1000);
		emp.setHoraEntrada("09:00:00");
		emp.setHoraSalida("16:30:00");
		emp.setCorreo("marcelo@dogebarcelo.cr");
		emp.setKeywords("admin, jefe, hEspecial");
		emp.setEstado("Activo");

		// su.insertar(emp);
		// su.actualizar(emp);

		Usuario emp2 = new Usuario();
		emp2.setNombre("Rebeca");
		emp2.setContrasenna("r456");
		emp2.setId(987123);
		emp2.setIdHotel(hotel.getIdHotel());
		emp2.setRol("Recepcionista");
		emp2.setSalario(565000);
		emp2.setPrecioPorHora(1000);
		emp2.setHoraEntrada("12:00:00");
		emp2.setHoraSalida("21:00:00");
		emp2.setCorreo("rebeca@dogebarcelo.cr");
		emp2.setKeywords("recep, frontdesk, tarde, noche");
		emp2.setEstado("Activo");

		// su.insertar(emp2);
		// su.actualizar(emp2);

		// Busqueda por nombre de empleado
		Usuario findEmp = su.findNombre("Sofia");
		System.out.println("* Empleado encontrado(Nomb) *" + "\nNombre: "
				+ findEmp.getNombre() + "\nPuesto: " + findEmp.getRol()
				+ "\nHorario: " + findEmp.getHoraEntrada() + " - "
				+ findEmp.getHoraSalida() + "\nEstado: " + findEmp.getEstado()
				+ "\n*****************************");

		// Busqueda de todos los empleados
		System.out.println("**** Todos los Empleados ****");
		for (Usuario u : su.findTodos()) {
			System.out.println("Empleado: " + u.getNombre() + "\nPuesto: "
					+ u.getRol() + "\n*****************************");
		}

		// Busqueda por estado del empleado
		System.out.println("******** Por Estado *********");
		for (Usuario empEst : su.findEstado("Inactivo")) {
			System.out.println("Nombre: "
					+ empEst.getNombre() + "\nPuesto: " + empEst.getRol()
					+ "\nHorario: " + empEst.getHoraEntrada() + " - "
					+ empEst.getHoraSalida() + "\nESTADO: "
					+ empEst.getEstado() + "\n*****************************");
		}

		// Busqueda por pk
		Usuario pkFind = su.findPK(789);
		System.out.println("** Empleado encontrado(PK) **" + "\nNombre: " + pkFind.getNombre()
				+ "\nPuesto: " + pkFind.getRol() + "\nHorario: " + pkFind.getHoraEntrada() 
				+ " - "	+ pkFind.getHoraSalida() + "\nEstado: " + pkFind.getEstado()
				+ "\n*****************************");

		// Eliminar empleado
		Usuario elim = su.findPK(987123);
		// su.eliminar(elim);
		
		// Cierra la entidad
		su.closeEntityManager();
*/
		// ****** PERMISO ******//
/*
		System.out.println("Ejecutando Permiso...");
		
		// Inicializacion del ServicioPermiso
		ServicioPermiso sp = new ServicioPermiso();

		// Nuevo permiso
		Permiso permiso = new Permiso();
		PermisoPK perPK = new PermisoPK();
		perPK.setIdUsuario(890);
		perPK.setDesdeFecha("2014-08-21");
		permiso.setHastaFecha("2014-08-21");
		permiso.setTipo("Incapacidad");
		permiso.setEstado((byte) 0);
		permiso.setId(perPK);

		// sp.insertar(permiso);
		// sp.actualizar(permiso);

		// Busqueda de todos los permisos
		System.out.println("*** Todos los Permisos ***");
		for (Permiso p : sp.findTodos()){
			System.out.println("Usuario: " + p.getId().getIdUsuario()
					+ "\nFecha Inicio: " + p.getId().getDesdeFecha() + "\nFecha Termina: " + p.getHastaFecha()
					+ "\nTipo: " + p.getTipo() + "\n****************************");
		}
		
		// Busqueda por pk compuesta
		Permiso pkComp = sp.findPKComp(901, "2014-09-05");
		System.out.println("Permiso encontrado(PKComp)" + "\nUsuario: " + pkComp.getId().getIdUsuario()
				+ "\nFecha Inicio: " + pkComp.getId().getDesdeFecha() + "\nFecha Termina: "
				+ pkComp.getHastaFecha() + "\nTipo: " + pkComp.getTipo() + "\n****************************");
		
		// Busqueda por empleado
		System.out.println("*** Permisos de empleado ***");
		for (Permiso pe : sp.findXEmpleado(123)){
			System.out.println("Usuario: " + pe.getId().getIdUsuario()
					+ "\nFecha Inicio: " + pe.getId().getDesdeFecha() + "\nFecha Termina: " + pe.getHastaFecha()
					+ "\nTipo: " + pe.getTipo() + "\n****************************");
		}
		
		// Busqueda por fecha
		System.out.println("**** Permisos por fecha ****");
		for (Permiso pe : sp.findXFecha("2014-08-21")){
			System.out.println("Usuario: " + pe.getId().getIdUsuario()
					+ "\nFecha Inicio: " + pe.getId().getDesdeFecha() + "\nFecha Termina: " + pe.getHastaFecha()
					+ "\nTipo: " + pe.getTipo() + "\n****************************");
		}
		
		// Eliminar permiso
		Permiso elimPer = sp.findPKComp(147, "2014-08-21");
		// sp.eliminar(elimPer);
		
		// Cierra la entidad
		sp.closeEntityManager();
*/
	}

}
