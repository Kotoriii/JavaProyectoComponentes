/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import comu.ServicioEntidad;

import entidades.Controlhorario;
import entidades.ControlhorarioPK;
import entidades.Hora;
import entidades.Usuario;

/**
 * 
 * @author Andrea
 */
public class ControlHorarios {

	Calendar cal;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // formato usado
																// para las
																// fechas de
																// mysql
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");// formato
																	// usado
																	// para el
																	// tiempo en
																	// mysql
	ServicioEntidad<entidades.Usuario> seu = new ServicioEntidad<entidades.Usuario>() {
		private static final long serialVersionUID = 1L;
	};
	ServicioEntidad<entidades.Controlhorario> sech = new ServicioEntidad<entidades.Controlhorario>() {
		private static final long serialVersionUID = 1L;
	};

	private static ControlHorarios controlh = null;

	private ControlHorarios() {
		cal = Calendar.getInstance();
	}

	public static ControlHorarios getInstancia() {
		if (controlh == null) {
			controlh = new ControlHorarios();
		}

		return controlh;
	}

	public int cuantasHorasDeTrabajoNormales(entidades.Usuario usuario) {
		int horasTrabajoNormales = 0;
		try {

			cal = Calendar.getInstance();
			Time horaEntradaHoy = new Time(00, 00, 00);
			Time horaSalidaHoy = new Time(00, 00, 00);

			seu.startEntityManager();// //

			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();
			for (Controlhorario c : (List<Controlhorario>) list) {
				horaSalidaHoy = c.getHoraSalida();
				horaEntradaHoy = c.getHoraEntrada();
			}

			seu.closeEntityManager();// //

			horasTrabajoNormales = (tiempoConectadoHoyMinutos(usuario) / 60)
					- cuantasHorasExtra(usuario);

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}
		return horasTrabajoNormales;
	}

	public int cuantasHorasExtra(entidades.Usuario usuario) {
		// le resta 8 a las horas totales que ha trabajado hoy, se presupone
		// que un dia laboral normal es de 8 horas por lo tanto el restante
		// son las horas extra

		int horasExtra = (tiempoConectadoHoyMinutos(usuario) / 60) - 8;
		if (horasExtra < 0) {
			horasExtra = 0;
		}
		return horasExtra;
	}

	/**
	 * Encuentra la diferencia en minutos entre tiempoMayor y Tiempomenor
	 * 
	 * @param tiempoMenor
	 *            el tiempo que representa la hora menor. ej 5:00:00
	 * @param tiempoMayor
	 *            el tiempo que representa la hora mayor. ej 10:00:00 El
	 *            resultado con estos parametros seria de 300 (5 * 60) //Hay que
	 *            tomar en cuenta que 00:00:00 es igual a 24:00:00
	 * @return la diferencia en minutos
	 */
	public int getDiferenciaEnMinutos(Time tiempoMayor, Time tiempoMenor) {

		long diff = tiempoMenor.getTime() - tiempoMayor.getTime();

		// long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);

		return (int) (diffMinutes + (diffHours * 60));
	}

	public boolean llegoTarde(entidades.Usuario usuario) {
		boolean llegoTarde = false;
		try {
			cal = Calendar.getInstance();
			Time horaConexionHoy = new Time(0, 0, 0);

			seu.startEntityManager();// ///

			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();
			for (Controlhorario c : (List<Controlhorario>) list) {
				horaConexionHoy = c.getHoraEntrada();
			}

			seu.closeEntityManager();// ////

			/*
			 * No se si hay una menjor manera de hacer esto pero lo que hace
			 * aqui es que agarra las horas actuales y le resta la hora en la
			 * que se conect el formato siempre es de 24 horas
			 */
			if (horaConexionHoy.getHours() > usuario.getHoraEntrada()
					.getHours()) {
				llegoTarde = true;
			}

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}
		return llegoTarde;
	}

	public int tiempoConectadoHoyMinutos(entidades.Usuario usuario) {
		int minutosConectado = -1;
		try {
			cal = Calendar.getInstance();
			Time horaConexionHoy = new Time(00, 00, 00);

			seu.startEntityManager();// ////

			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();
			for (Controlhorario c : (List<Controlhorario>) list) {
				horaConexionHoy = c.getHoraEntrada();
			}

			seu.closeEntityManager();// //

			/*
			 * No se si hay una menjor manera de hacer esto pero lo que hace
			 * aqui es que agarra las horas actuales y le resta la hora en la
			 * que se conect el formato siempre es de 24 horas
			 */

			minutosConectado = getDiferenciaEnMinutos(horaConexionHoy,
					new Time(cal.getTimeInMillis()));

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}
		return minutosConectado;
	}

	public int tiempoDeConectadoHoyHoras(Usuario usuario) {
		int horasConectado = -1;
		try {
			cal = Calendar.getInstance();

			seu.startEntityManager();// ////

			Time horaConexionHoy = new Time(00, 00, 00);
			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();
			for (Controlhorario c : (List<Controlhorario>) list) {
				horaConexionHoy = c.getHoraEntrada();
			}

			seu.closeEntityManager(); // //////

			/*
			 * No se si hay una menjor manera de hacer esto pero lo que hace
			 * aqui es que agarra las horas actuales y le resta la hora en la
			 * que se conect el formato siempre es de 24 horas
			 */
			SimpleDateFormat tf = new SimpleDateFormat("HH");// solo obtiene las
																// horas
			horasConectado = Integer.parseInt(tf.format(cal.getTime()))
					- horaConexionHoy.getHours();

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}
		return horasConectado;
	}

	public void iniciarSesionXelDia(entidades.Usuario usuario) {
		try {
			cal = Calendar.getInstance();

			seu.startEntityManager();

			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();

			seu.closeEntityManager();

			if (list.isEmpty()) {
				Controlhorario ch = new Controlhorario();

				ControlhorarioPK chpk = new ControlhorarioPK();
				chpk.setIdUsuario(usuario.getId());
				chpk.setFecha(cal.getTime());

				ch.setId(chpk);
				// ch.setUsuario(usuario);
				ch.setHoraEntrada(new Time(cal.getTime().getTime()));
				ch.setHoraSalida(null);


				sech.insertar(ch);


			} else {
				System.out.println("Ya fue iniciada la sesion el dia de hoy.."
						+ "no es necesario volver a iniciarla");
			}

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}

	}

	public void cerrarSesion(entidades.Usuario usuario) {
		try {
			cal = Calendar.getInstance();

			seu.startEntityManager();// ///

			javax.persistence.Query query = seu.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();

			seu.closeEntityManager();// ///

			// Si esto no se cumple es simplemente porque el usuario no ha
			// empezado sesion en el presente dia
			for (Controlhorario c : (List<Controlhorario>) list) {
				// agrega hora de salida
				c.setHoraSalida(new Time(cal.getTime().getTime()));
				
				sech.actualizar(c);
				
				// inserta las horas trabajadas durante el dia
				ServicioEntidad<Hora> seh = new ServicioEntidad<Hora>() {
					private static final long serialVersionUID = 1L;
				};
				Hora horasDia = new Hora();
				horasDia.setIdUsuario(usuario.getId());
				horasDia.setFecha(cal.getTime());

				horasDia.setHorasExtra(cuantasHorasExtra(usuario));
				horasDia.setHorasNormales(cuantasHorasDeTrabajoNormales(usuario));

				seh.insertar(horasDia);

			}

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}

	}

	public boolean cerroSesionXelDia(entidades.Usuario usuario) {
		try {
			ServicioEntidad<entidades.Usuario> df = new ServicioEntidad<entidades.Usuario>() {
				private static final long serialVersionUID = 1L;
			};

			cal = Calendar.getInstance();
			boolean cerro = false;
			
			df.startEntityManager();/////
			
			javax.persistence.Query query = df.getEntityManager().createQuery(
					"from " + Controlhorario.class.getSimpleName()
							+ " where idUsuario = '" + usuario.getId()
							+ "' and fecha='"
							+ dateFormat.format(cal.getTime()) + "'");
			List list = query.getResultList();
			// solo entra si hay datos en el select
			if(list.size() != 0){
				cerro = true;
			}
			df.closeEntityManager(); /////
			
			return cerro;

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
		}
		return false;
	}

	public String getFecha() {
		cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	public Date getFechaDate() {
		cal = Calendar.getInstance();
		return cal.getTime();
	}
}
