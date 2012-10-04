package client.event.admin;

import java.awt.Desktop;
import java.io.File;

public class CallFileHelp {
	public CallFileHelp() {
		try {
			File pdfFile = new File("lib/help/admin.pdf");
			if (pdfFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
				} else {
					System.out.println("Awt Desktop is not supported!");
				}

			} else {
				System.out.println("File is not exists!");
			}

			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
