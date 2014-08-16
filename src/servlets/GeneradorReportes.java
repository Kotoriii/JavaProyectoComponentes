package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

import com.Report;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import com.Conexion;

/**
 * Servlet implementation class GeneradorReportes
 */
@WebServlet(description = "genera reportes", urlPatterns = { "/GeneradorReportes" })
public class GeneradorReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneradorReportes() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		ServletOutputStream out = response.getOutputStream();
		Connection cn = Conexion.getInstancia().getSqlCon();
		HashMap parameterMap = new HashMap();
		*/
		//JasperPrint print = generateReport(cn, parameterMap, "Estados_Usuarios");
		/*

		try {

			 * RequestDispatcher view = request
			 * .getRequestDispatcher("Reportes.jsp");
			 */

			// File filePath = new File(getServletContext().getRealPath(
			// "ReportFormat/DemoReport.jrxml"));
			/*
			File savePath = new File(getServletContext().getRealPath(
					"WEB-INF/GeneratedReports/userDetail.pdf"));
			String path = savePath.toString();

			try {
				response.setContentType("application/pdf");
				response.setHeader("content-dispostion", "attachment;");
				ServletContext ctx = getServletContext();
				InputStream is = ctx
						.getResourceAsStream("WEB-INF/GeneratedReports/userDetail.pdf");

				int read = 0;
				byte[] bytes = new byte[1024];

				OutputStream os = response.getOutputStream();
				while ((read = is.read(bytes)) != -1) {
					os.write(bytes, 0, read);
				}
				os.flush();
				os.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		*/
	}
	
	public JasperPrint generateReport(Connection con, HashMap hm, String reportName) {
		try {
			if (con == null) {
				try {
					con = Conexion.getInstancia().getSqlCon();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			JasperPrint jasperPrint = null;
			if (hm == null) {
				hm = new HashMap();
			}
			try {
				/**
				 * You can also test this line if you want to display report
				 * from any absolute path other than the project root path
				 */
				jasperPrint = JasperFillManager.fillReport(reportName
						+ ".jasper", hm, con);
				// jasperPrint = JasperFillManager.fillReport(reportName +
				// ".jasper", hm, con);
			} catch (JRException e) {
				e.printStackTrace();
			}
			return jasperPrint;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
}
