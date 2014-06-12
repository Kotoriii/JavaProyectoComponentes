/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Andrea
 */
public class ControlHorarios {

    Calendar cal;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // formato usado para las fechas de mysql
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");//formato usado para el tiempo en mysql

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

    public int cuantasHorasDeTrabajoNormales(Usuario usuario) {
        int horasTrabajoNormales = 0;
        try {
            cal = Calendar.getInstance();
            Time horaEntradaHoy = new Time(00, 00, 00);
            Time horaSalidaHoy = new Time(00, 00, 00);
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {
                horaSalidaHoy = rs.getTime("horaSalida");
                horaEntradaHoy = rs.getTime("horaEntrada");
            }

            horasTrabajoNormales = (tiempoConectadoHoyMinutos(usuario) / 60) - cuantasHorasExtra(usuario);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }
        return horasTrabajoNormales;
    }

    public int cuantasHorasExtra(Usuario usuario) {
        //le resta 8 a las horas totales que ha trabajado hoy, se presupone
        //que un dia laboral normal es de 8 horas por lo tanto el restante 
        //son las horas extra
        int horasExtra = (tiempoConectadoHoyMinutos(usuario) / 60) - 8;
        if (horasExtra < 0) {
            horasExtra = 0;
        }
        return horasExtra;
    }

    /**
     * Encuentra la diferencia en minutos entre tiempoMayor y Tiempomenor
     *
     * @param tiempoMenor el tiempo que representa la hora menor. ej 5:00:00
     * @param tiempoMayor el tiempo que representa la hora mayor. ej 10:00:00 El
     * resultado con estos parametros seria de 300 (5 * 60) //Hay que tomar en
     * cuenta que 00:00:00 es igual a 24:00:00
     * @return la diferencia en minutos
     */
    public int getDiferenciaEnMinutos(Time tiempoMayor, Time tiempoMenor) {

        long diff = tiempoMenor.getTime() - tiempoMayor.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return (int) (diffMinutes + (diffHours * 60));
    }

    public boolean llegoTarde(Usuario usuario) {
        boolean llegoTarde = false;
        try {
            cal = Calendar.getInstance();
            Time horaConexionHoy = new Time(0, 0, 0);

            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {
                horaConexionHoy = rs.getTime("horaEntrada");
            }
            /*
             * No se si hay una menjor manera de hacer esto pero lo que hace aqui
             * es que agarra las horas actuales y le resta la hora en la que se conect
             * el formato siempre es de 24 horas
             */
            if (horaConexionHoy.getHours() > usuario.getHoraEntrada().getHours()) {
                llegoTarde = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }
        return llegoTarde;
    }

    public int tiempoConectadoHoyMinutos(Usuario usuario) {
        int minutosConectado = -1;
        try {
            cal = Calendar.getInstance();
            Time horaConexionHoy = new Time(00, 00, 00);
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {
                horaConexionHoy = rs.getTime("horaEntrada");
            }
            /*
             * No se si hay una menjor manera de hacer esto pero lo que hace aqui
             * es que agarra las horas actuales y le resta la hora en la que se conect
             * el formato siempre es de 24 horas
             */

            minutosConectado = getDiferenciaEnMinutos(horaConexionHoy, new Time(cal.getTimeInMillis()));

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }
        return minutosConectado;
    }

    public int tiempoDeConectadoHoyHoras(Usuario usuario) {
        int horasConectado = -1;
        try {
            cal = Calendar.getInstance();
            Time horaConexionHoy = new Time(00, 00, 00);
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {
                horaConexionHoy = rs.getTime("horaEntrada");
            }
            /*
             * No se si hay una menjor manera de hacer esto pero lo que hace aqui
             * es que agarra las horas actuales y le resta la hora en la que se conect
             * el formato siempre es de 24 horas
             */
            SimpleDateFormat tf = new SimpleDateFormat("HH");//solo obtiene las horas
            horasConectado = Integer.parseInt(tf.format(cal.getTime())) - horaConexionHoy.getHours();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }
        return horasConectado;
    }

    public void iniciarSesionXelDia(Usuario usuario) {
        try {
            cal = Calendar.getInstance();
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (!rs.next()) {

                Conexion.getInstancia().insertar(
                        "controlhorarios",
                        "idUsuario, fecha, horaEntrada",
                        "'" + usuario.getId()
                        + "', '" + dateFormat.format(cal.getTime())
                        + "', '" + timeFormat.format(cal.getTime()) + "'");
            } else {
                System.out.println("Ya fue iniciada la sesion el dia de hoy.."
                        + "no es necesario volver a iniciarla");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }

    }

    public void cerrarSesion(Usuario usuario) {
        try {
            cal = Calendar.getInstance();
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {

                //pone la hora de cierre en la linea que corresponde a la fecha de hoy
                Conexion.getInstancia().modificar(
                        "controlhorarios",
                        "horaSalida",
                        timeFormat.format(cal.getTime()),
                        "fecha='" + dateFormat.format(cal.getTime())
                        + "' and idUsuario='" + usuario.getId() + "'");

                //inserta la cantidad de horas extra correspondiente al dia
                String InsertarHorasDelDia = "Insert into horas "
                        + "(idUsuario, fecha, HorasExtra, HorasNormales)"
                        + " values ('" + usuario.getId() + "', '" + dateFormat.format(cal.getTime()) + "', '" + cuantasHorasExtra(usuario) + "', '" + cuantasHorasDeTrabajoNormales(usuario) + "');";
                Conexion.getInstancia().ejecutarNonQuery(InsertarHorasDelDia);

            } else {
                System.out.println("La sesion aun NO ha sido iniciada por el "
                        + "usuario para el dia de hoy");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }

    }

    public boolean cerroSesionXelDia(Usuario usuario) {
        try {
            cal = Calendar.getInstance();
            String SQL_BUSCAR = "Select * from controlhorarios ch where idUsuario ='" + usuario.getId() + "' and fecha='" + dateFormat.format(cal.getTime()) + "';";

            Statement st = Conexion.getInstancia().conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            if (rs.next()) {
                if (rs.getString("horaSalida") != null) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            Conexion.getInstancia().desconectar();
        }
        return false;
    }

    public String getFecha() {
        cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}
