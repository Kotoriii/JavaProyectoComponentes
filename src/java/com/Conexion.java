/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andrea
 */
public class Conexion {

    List<Usuario> listEmpleados = new ArrayList<Usuario>();
    
    Connection mCon = null;
    private static Conexion conex = null;

    String mUser = "root";
    String mPassword = "root";
    String mUrl = "jdbc:mysql://localhost:3306/mydb";
    
    public void agregarResultadoBusqueda(Usuario resultado){
        this.listEmpleados.add(resultado);
    }
    
    public void vaciarLista(){
        this.listEmpleados.clear();
    }

    public Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            mCon = DriverManager.getConnection(mUrl, mUser, mPassword);

            return mCon;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private Conexion() {
        conectar();
    }

    public static Conexion getInstancia() {
        if (conex == null) {
            conex = new Conexion();
        }
        return conex;
    }

    public Usuario buscarXId(String _id) {
        try {
            String SQL_BUSCAR = "Select * from usuarios where id ='" + _id + "';";

            Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            while (rs.next()) {

                return new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenna"),
                        rs.getString("rol"),
                        rs.getInt("salario"),
                        rs.getInt("precioPorHora"),
                        rs.getString("keywords"),
                        rs.getString("correo"),
                        rs.getString("horaEntrada"),
                        rs.getString("horaSalida"),
                        rs.getString("estado"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            desconectar();
        }
        System.out.println("El nombre no existe");
        return null;
    }
    
    public Usuario buscarPorNombre(String _nombre){
        try {
            String SQL_BUSCAR = "Select * from usuarios where nombre ='" + _nombre + "';";

            Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            while (rs.next()) {

                return new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenna"),
                        rs.getString("rol"),
                        rs.getInt("salario"),
                        rs.getInt("precioPorHora"),
                        rs.getString("keywords"),
                        rs.getString("correo"),
                        rs.getString("horaEntrada"),
                        rs.getString("horaSalida"),
                        rs.getString("estado"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            desconectar();
        }
        System.out.println("El nombre no existe");
        return null;
    }
    
    /// todos los empleados en una lista
     public List<Usuario> todosLosEmpleados(String _estado){
        try {
            if (listEmpleados != null)
                vaciarLista();
            
            String SQL_BUSCAR = "Select * from usuarios;";

            Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            
            while (rs.next()) {

                Usuario empleado = new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenna"),
                        rs.getString("rol"),
                        rs.getInt("salario"),
                        rs.getInt("precioPorHora"),
                        rs.getString("keywords"),
                        rs.getString("correo"),
                        rs.getString("horaEntrada"),
                        rs.getString("horaSalida"),
                        rs.getString("estado"));
                
                agregarResultadoBusqueda(empleado);
            }
            
            return listEmpleados;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            desconectar();
        }
        System.out.println("No hay empleados");
        return null;
    }
    
    // Busca empleados por estado y devuielve una lista de empleados
    public List<Usuario> buscarPorEstado(String _estado){
        try {
            if (listEmpleados != null)
                vaciarLista();
            
            String SQL_BUSCAR = "Select * from usuarios where estado ='" + _estado + "';";

            Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            while (rs.next()) {

                Usuario empleado = new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenna"),
                        rs.getString("rol"),
                        rs.getInt("salario"),
                        rs.getInt("precioPorHora"),
                        rs.getString("keywords"),
                        rs.getString("correo"),
                        rs.getString("horaEntrada"),
                        rs.getString("horaSalida"),
                        rs.getString("estado"));
                
                agregarResultadoBusqueda(empleado);
            }
            
            return listEmpleados;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            desconectar();
        }
        System.out.println("No hay empleados");
        return null;
    }
    
    //Devuelve una lista con todos los empleados para poder comparar con las Keywords
    public List<Usuario> mostrarEmpleados(){
        try {
            if (listEmpleados != null)
                vaciarLista();
            
            String SQL_BUSCAR = "Select * from usuarios;";

            Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            while (rs.next()) {

                Usuario empleado = new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasenna"),
                        rs.getString("rol"),
                        rs.getInt("salario"),
                        rs.getInt("precioPorHora"),
                        rs.getString("keywords"),
                        rs.getString("correo"),
                        rs.getString("horaEntrada"),
                        rs.getString("horaSalida"),
                        rs.getString("estado"));
                
                agregarResultadoBusqueda(empleado);
            }
            
            return listEmpleados;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            desconectar();
        }
        System.out.println("No hay empleados");
        return null;
    }

    /**
     * ?inverso de conectar?
     */
    public void desconectar() {

        if (!(mCon == null)) {
            try {
                mCon.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("la conexion no esta abierta en este mmomento");
        }

    }

    /**
     * Ejecuta cualquier comando que no retorne nada (que no sea un select)
     *
     * @param comando .. el comando
     * @return true si el comando fue ejecutado exitosamente
     */
    public boolean ejecutarNonQuery(String comando) {
        try {

            Statement st = conectar().createStatement();
            return st.execute(comando);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    public boolean modificar(String _tabla, String _columna, String _nuevoDato, String _where) {
        try {
            String SQL_MODIFICAR = "UPDATE " + _tabla + " SET " + _columna + "='" + _nuevoDato + "' WHERE " + _where + ";";

            Statement st = conectar().createStatement();
            return st.execute(SQL_MODIFICAR);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    /**
     * se aceptan %x o x%
     *
     * @param dato
     * @return boolean
     */
    public boolean eliminar(String tabla, String donde) {
        try {
            String SQL_DELETE = "Delete from " + tabla + " where " + donde + ";";

            Statement st = conectar().createStatement();
            return st.execute(SQL_DELETE);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    public boolean insertar(String tabla, String columna, String dato) {

        try {
            String SQL_INSERT = "INSERT INTO " + tabla + " (" + columna + ") values (" + dato + ");";
            PreparedStatement ps = conectar().prepareStatement(SQL_INSERT);
            boolean b = ps.execute(); //retorna true o false dependiendo si fue existoso o no -- ver javadoc
            return b;

        } catch (SQLException ex) {
            System.out.println("Error al insertar, la columna o la tabla no existe");
        } finally {
            desconectar();
        }
        return false;

    }

    public boolean crearNuevoUsuario(String _id, String _nombre, String _contrasenna, String _rol,
            String _salario, String _precioXHora, String _keyword, String _correo,
            String _horaEntrada, String _horaSalida) {
        try {
            String SQL_CREAR = "INSERT INTO usuarios (id, nombre, contrasenna, rol, salario, precioPorHora, keywords, correo, horaEntrada, horaSalida, estado) "
                    + "VALUES ('" + _id + "', '" + _nombre + "', '" + _contrasenna + "', '" + _rol + "', '" + _salario + "', '" + _precioXHora + "', '" + _keyword + "', '" + _correo + "', '" + _horaEntrada + "', '" + _horaSalida + "', 'Activo');";

            Statement st = conectar().createStatement();
            return st.execute(SQL_CREAR);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }
    
    public boolean crearPermiso(String _id, String _fechainicio, String _fechafinal, String _tipo, String _estado){
        try{
            String SQL_PERMISO = "INSERT INTO permisos (idUsuario, desdeFecha, hastaFecha, tipo, estado) " + "values ('" +_id + "', '" +_fechainicio + "', '" + _fechafinal + "', '" + _tipo + "', '"+ _estado+"');";
            Statement st = conectar().createStatement();
            return st.execute(SQL_PERMISO);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

}
