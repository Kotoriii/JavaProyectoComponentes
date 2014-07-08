/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permiso;

/**
 *
 * @author Christian
 */
public class Incapacidad implements Permiso {
String permiso = "";
        @Override
        public String CrearPermiso() {
            return permiso = "Incapacidad";
        }
    }
