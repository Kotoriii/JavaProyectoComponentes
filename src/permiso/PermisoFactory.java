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
public class PermisoFactory {

      public String getPermiso(String tipoPermiso) {
            if (tipoPermiso == null) {
                return null;
            }
            if (tipoPermiso.equalsIgnoreCase("Vacaciones")) {
                return new Vacaciones().CrearPermiso();
            } else if (tipoPermiso.equalsIgnoreCase("Incapacidad")) {
                return new Incapacidad().CrearPermiso();
            } else if (tipoPermiso.equalsIgnoreCase("Ausencia")) {
                return new Ausencia().CrearPermiso();
            } else if (tipoPermiso.equalsIgnoreCase("Otros")) {
                return new Otros().CrearPermiso();
            }
            else{
            return null;
            }
        }

    }

