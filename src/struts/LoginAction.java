/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ControlHorarios;

import comu.ServicioUsuario;
import entidades.Usuario;

/**
 */
public class LoginAction extends org.apache.struts.action.Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginForm loginForm = (LoginForm) form;

		ServicioUsuario servu = new ServicioUsuario();

		Usuario usuario = new Usuario();

		
		try {
			usuario = servu.findPK(Integer.parseInt(loginForm.getUserName()));

		} catch (Exception e) {
		
		}
		
		int cnt = 0;

		// se fija que el usuairo no ha iniciado sesion en el dia y
		// se fija que el usuario exista y que la contrasenna
		// sea correcta
		if (usuario == null && usuario.getNombre() == null) {
			cnt = 1;
		} else if (!usuario.getContrasenna().equals(loginForm.getPassword())) {
			cnt = 2;
		} else if (ControlHorarios.getInstancia().cerroSesionXelDia(usuario)) {
			cnt = 3;
		} else if (usuario.getEstado().equals("Inactivo")) {
			cnt = 4;
		}

		if (cnt == 0) {

			request.getSession().setMaxInactiveInterval(0);
			request.getSession().setAttribute("usuario", usuario);
			ControlHorarios.getInstancia().iniciarSesionXelDia(usuario);

			return mapping.findForward("paginaP");

		} else {
			return mapping.findForward("index");
		}

	}
}
