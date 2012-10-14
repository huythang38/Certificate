package client.report;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import client.gui.admin.nav_panel.Preview;

public class ExportCertificate {

	public static BufferedImage pageImage;
	public static String name = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ExportCertificate(String fullName, String DOB, String centre,
			String grade) {
		String day = null, month = null, year = null, date;
		name = fullName.replaceAll(" ", "");

		day = JOptionPane.showInputDialog(new JFrame(), "Enter day:", "");
		month = JOptionPane.showInputDialog(new JFrame(), "Enter month:", "");
		year = JOptionPane.showInputDialog(new JFrame(), "Enter year:", "");

		try {
			Map map = new HashMap();
			map.put("fullName", fullName);
			map.put("DOB", DOB);
			map.put("day", day);
			map.put("month", month);
			map.put("year", year);
			map.put("centre", centre);
			map.put("grade", grade);

			date = day + "/" + month + "/" + year;
			map.put("date", date);
			JasperPrint jasperPrint = (JasperPrint) JasperFillManager
					.fillReport("lib/iReport/report/certificate.jasper", map);

			int pageIndex = 0;
			pageImage = new BufferedImage(jasperPrint.getPageWidth() + 1,
					jasperPrint.getPageHeight() + 1, BufferedImage.TYPE_INT_RGB);

			JRGraphics2DExporter exporter = new JRGraphics2DExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D,
					pageImage.getGraphics());
			exporter.setParameter(JRExporterParameter.PAGE_INDEX, new Integer(
					pageIndex));
			exporter.exportReport();

			new Preview(pageImage);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void save() {

		String urlExport = null;
		{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle("Save to...");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				urlExport = chooser.getSelectedFile().toString();
				try {
					OutputStream out = new FileOutputStream(urlExport + "\\"
							+ name + ".jpeg");
					try {
						ImageIO.write(pageImage, "jpeg", out);
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
