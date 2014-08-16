package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import com.Conexion;



/**
 * Servlet implementation class GenerarReportes
 */

public class GenerarReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("application/pdf");
        ServletOutputStream out = response.getOutputStream();
        Conexion cn = Conexion.getInstancia();
        String empactivos = request.getParameter("empleadosactivos");
		
        if("empleadosactivos".equals(empactivos)){
        try {
        	String jasper = "dobebarcelo/Empleados_Estado.jasper";
        	
        	
            //JasperReport empleadosactivos = (JasperReport) JRLoader.loadObjectFromFile(getServletContext().getRealPath("dogebarcelo/Empleados_Estado.jasper"));

            Map<String,Object> reporteactivos = new HashMap<String, Object>();
            
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, reporteactivos, (Connection) cn);

            
            //JRPdfExporter exporter = new JRPdfExporter();
            
            JasperExportManager.exportReportToPdf(jasperPrint);

            /*exporter.setExporterInput(SimpleExporterInput.getInstance((List<JasperPrint>) jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("dogebarcelo/asad.pdf"));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);

            exporter.exportReport();*/

			response.sendRedirect("Reportes.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
            out.close();
        }
        }
	}

   
            
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
