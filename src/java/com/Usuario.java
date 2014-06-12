/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import interfases.Observer;
import interfases.State;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrea
 */
public final class Usuario implements interfases.Subject {

    private State changeState;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private String id;
    private String nombre;
    private String contrasenna;
    private String rol;
    private int Salario;
    private int PrecioPorHora;
    private List<String> keywords;
    private String correo;
    private Time horaEntrada;
    private Time horaSalida;
    private String estado;

    public Usuario(String _id, String _nombre, String _contra, String _rol, int _salario,
            int _PrecioPorHora, String _keywords, String _correo,
            String _horaEntrada, String _horaSalida, String _estado) {

        this.id = _id;
        this.nombre = _nombre;
        this.contrasenna = _contra;
        this.rol = _rol;
        this.Salario = _salario;
        this.correo = _correo;
        this.estado = _estado;

        this.PrecioPorHora = _PrecioPorHora;
        setKeyword(_keywords);
        setHoraEntrada(_horaEntrada);
        setHoraSalida(_horaSalida);

        setChangeState(new ActiveState()); //Instancia el estado para cuando se desee cambiarlo
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public int getPrecioPorHora() {
        return PrecioPorHora;
    }

    public void setPrecioPorHora(int PrecioPorHora) {
        this.PrecioPorHora = PrecioPorHora;
    }

    public List getKeywords() {
        return keywords;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
/////////////////////////////////////

    /**
     * transforma un string de palabras separas por coma en un array
     * 
     * @param _keywords
     */
    public void setKeyword(String _keywords) {
        this.keywords = Arrays.asList(_keywords.split("\\s*,\\s*"));
    }

    // Se encarga de recorrer la lista para comparar su contenido con un string
    public boolean comparaKeyword(String _comparar) {
        for (String buscar : keywords) {
            if (buscar.equals(_comparar)) {
                return true;
            }
        }
        return false;
    }
    
    // Se encarga de convertir la lista en un string
    public String hacerStringKeywords(){
        String palabras = "";
        for (String k : keywords){
            palabras += k+",";
        }
        return palabras;
    }

    public void setHoraEntrada(String _horaEntrada) {
        String horas;
        String minutos;
        String segundos;
        if (_horaEntrada.length() == 8) {
            horas = _horaEntrada.substring(0, 2);
            minutos = _horaEntrada.substring(3, 5);
            segundos = _horaEntrada.substring(6);
            horaEntrada = new Time(Integer.parseInt(horas),
                    Integer.parseInt(minutos), Integer.parseInt(segundos));
        } else {
            System.out.println("ERROR: la hora tiene que ser de 8 digitos... formato HH:MM:SS. Clase: Usuario, metodo: horaEntada");
        }

    }

    public void setHoraSalida(String _horaSalida) {
        String horas;
        String minutos;
        String segundos;
        if (_horaSalida.length() == 8) {
            horas = _horaSalida.substring(0, 2);
            minutos = _horaSalida.substring(3, 5);
            segundos = _horaSalida.substring(6);
            horaSalida = new Time(Integer.parseInt(horas),
                    Integer.parseInt(minutos), Integer.parseInt(segundos));
        } else {
            System.out.println("ERROR: la hora tiene que ser de 8 digitos... formato HH:MM:SS . Clase: Usuario, metodo HoraSalida");
        }
    }

    //// ###################################################################
    // metodos del patron de observador
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observer.update(null);
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(this);
        }
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    //// ###################################################################
    // Metodos para cambiar el estado
    public void setChangeState(State state) {
        this.changeState = state;
    }

    public void cambiarEstado() {
        changeState.changeState(this);
    }

    //// ###################################################################
    // Se usa para mostrar el empleado despues de realizar la busqueda
    @Override
    public String toString() {
        return "<tr>" + "<td><h4>" + getId()+ "</h4></td>"
                + "<td><h4>" + getNombre() + "</h4></td>"
                + "<td><h4>" + getRol()+ "</h4></td>"
                + "<td><h4>" + getSalario()+ "</h4></td>"
                + "<td><h4>" + getEstado()+ "</h4></td>"
                + "<td>" + "<a href=" + "administracion.jsp?nombre=" + getNombre()+ ""
                + "&id=" + getId() + "" + "&puesto=" + getRol()+ ""
                + "&salario=" + getSalario()+ "" + "&pagoHora=" + getPrecioPorHora()+ ""
                + "&horaEntrada=" + getHoraEntrada()+ "" + "&horaSalida=" + getHoraSalida()+ ""
                + "&email=" + getCorreo()+ "" + "&keywords=" + hacerStringKeywords()+ ""
                + "&estado=" + getEstado()+ ">"
                + "<input type=\"button\"value=\" Modificar \" class=\"btn btn-primary\"</a>" 
                + "</td>" + "</tr>";
    }
}
