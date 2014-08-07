package entidades;

import comu.ServicioUsuario;

public class TesterEntidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//****** Usuario ******//
		ServicioUsuario su = new ServicioUsuario();
		su.startEntityManager();
		
		Usuario emp = new Usuario();
		emp.setNombre("Marcelo");
        emp.setContrasenna("m123");
        emp.setId(321456);
        emp.setRol("Administrador");
        emp.setSalario(565000);
        emp.setPrecioPorHora(1000);
        emp.setHoraEntrada("09:00:00");
        emp.setHoraSalida("16:30:00");
        emp.setCorreo("marcelo@dogebarcelo.cr");
        emp.setKeywords("admin, jefe, hEspecial");
        emp.setEstado("Activo");
        
        //su.insertar(emp);
        //su.actualizar(emp);
        
        Usuario emp2 = new Usuario();
		emp2.setNombre("Rebeca");
        emp2.setContrasenna("r456");
        emp2.setId(987123);
        emp2.setRol("Recepcionista");
        emp2.setSalario(565000);
        emp2.setPrecioPorHora(1000);
        emp2.setHoraEntrada("12:00:00");
        emp2.setHoraSalida("21:00:00");
        emp2.setCorreo("rebeca@dogebarcelo.cr");
        emp2.setKeywords("recep, frontdesk, tarde, noche");
        emp2.setEstado("Activo");
        
        //su.insertar(emp2);
        //su.actualizar(emp2);
        
        //Busqueda por nombre de empleado
        Usuario findEmp = su.findNombre("Marcelo");
        System.out.println("*** Info empleado ***" + "\nNombre: " + findEmp.getNombre()
        		+ "\nPuesto: " + findEmp.getRol() + "\nHorario: " + findEmp.getHoraEntrada() + " - "
        		+ findEmp.getHoraSalida() + "\nEstado: " + findEmp.getEstado());
        
        //Busqueda de todos los empleados
        for (Usuario u : su.buscarTodos(new Usuario())){
        	System.out.println("Empleado: " + u.getNombre() + "Puesto: " + u.getRol()
        			+ "\n" + "*************************" + "\n");
        }
		
        //Busqueda por estado del empleado
        for (Usuario empEst : su.findEstado("Activo")){
        System.out.println("*** Empleado ***" + "\nNombre: " + empEst.getNombre()
        		+ "\nPuesto: " + empEst.getRol() + "\nHorario: " + empEst.getHoraEntrada() + " - "
        		+ empEst.getHoraSalida() + "\nESTADO: " + empEst.getEstado() + "\n");
        }
        
        //Busqueda por pk
        Usuario pkFind = su.buscar(new Usuario(), new Integer(1));
        System.out.println("Empleado encontrado: " + pkFind.getNombre());
        
        
        
	}

}
