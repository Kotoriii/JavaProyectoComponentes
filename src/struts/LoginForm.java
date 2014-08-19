/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ControlHorarios;

import comu.ServicioUsuario;
import entidades.Usuario;  

public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	/**
     *
     */
	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		ServicioUsuario servu = new ServicioUsuario();

		Usuario usuario = new Usuario();
		int error = 0;
		int sdf = 0;
		try {
			usuario = servu.findPK(Integer.parseInt(userName));

		} catch (Exception e) {
			error = 1;
			sdf = 1;
		}

		// se fija que el usuairo no ha iniciado sesion en el dia y
		// se fija que el usuario exista y que la contrasenna
		// sea correcta
		if (sdf != 1) {
			if (!usuario.equals(null) && !usuario.getNombre().equals(null)) {
				//errors.add("userName", new ActionMessage("error.nonExiste"));
				error = 1;
			} else if (!usuario.getContrasenna().equals(password)) {
				//errors.add("userName", new ActionMessage("error.ContraInc"));
				error = 2;
			} else if (ControlHorarios.getInstancia()
					.cerroSesionXelDia(usuario)) {
				//errors.add("userName", new ActionMessage("error.yaCerroSesion"));
				error = 3;
			} else if (usuario.getEstado().equals("Inactivo")) {
				//errors.add("userName", new ActionMessage("error.UsuInactivo"));
				error = 4;
			}
		}
		request.getSession().setAttribute("errr", error);
		return errors;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		System.out.println("Inside getter " + userName);
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		System.out.println("Inside setter " + userName);
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
