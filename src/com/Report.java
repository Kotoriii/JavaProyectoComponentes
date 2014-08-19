package com;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JFrame;

import decorador.planilla.testDecorador;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JRViewer;

public class Report extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap hm = null;
	Connection con = null;
	String reportName;
	JasperPrint print = null;
	String path_reportes = "";

	public Report() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	/** hash map y el nombre del reporte (sin '.jasper' ) */
	public Report(HashMap map, String reportName) {
		this.hm = map;
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.reportName = reportName;

		get_path();

	}

	public Report(HashMap map, Connection con) {
		this.hm = map;
		this.con = con;
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Report Viewer");

		get_path();

	}

	private void get_path() {
		URL location = testDecorador.class.getProtectionDomain()
				.getCodeSource().getLocation();
		String p = "";
		for (String s : location.getFile().split("/")) {
			if (!s.equals(".metadata")) {
				p += s + "/";
			} else {
				break;
			}
		}
		path_reportes = p + "dogebarcelo/Reporte";
	}

	public void setReportName(String rptName) {
		this.reportName = rptName;
	}

	public JasperPrint getReporT() {
		return this.print;
	}

	public void callReport() {
		print = generateReport();
		try {

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					new FileOutputStream(path_reportes + "/" + reportName
							+ ".pdf")); // your output
			// goes here
			exporter.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void callConnectionLessReport() {
		JasperPrint jasperPrint = generateEmptyDataSourceReport();
		JRViewer viewer = new JRViewer(jasperPrint);
		Container c = getContentPane();
		c.add(viewer);
		this.setVisible(true);
	}

	public void closeReport() {
		// jasperViewer.setVisible(false);
	}

	/** this method will call the report from data source */
	public JasperPrint generateReport() {
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
				jasperPrint = JasperFillManager.fillReport(path_reportes + "/"
						+ reportName + ".jasper", hm, con);
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

	/** call this method when your report has an empty data source */
	public JasperPrint generateEmptyDataSourceReport() {
		try {
			JasperPrint jasperPrint = null;
			if (hm == null) {
				hm = new HashMap();
			}
			try {
				jasperPrint = JasperFillManager.fillReport(reportName
						+ ".jasper", hm, new JREmptyDataSource());
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
