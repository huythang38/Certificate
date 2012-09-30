package client.gui.admin;

import java.awt.CardLayout;

import javax.swing.JPanel;

import client.gui.admin.nav_panel.AccountChangeStatusPanel;
import client.gui.admin.nav_panel.AccountResetPassword;
import client.gui.admin.nav_panel.HomePanel;

@SuppressWarnings("serial")
public class NavContentPanel extends JPanel {
	public CardLayout cardLayout;
	
	public NavContentPanel() {
		setLayout(new CardLayout());

		// tab home
		{
			HomePanel contentHome = new HomePanel();
			add(contentHome, "home");

			JPanel contentHelp = new JPanel();
			add(contentHelp, "help");

			JPanel contentAbout = new JPanel();
			add(contentAbout, "about");
		}

		// tab Student
		{
			JPanel contentViewInfoStudent = new JPanel();
			add(contentViewInfoStudent, "viewInfoStudent");

			JPanel contentCreateStudent = new JPanel();
			add(contentCreateStudent, "createStudent");

			JPanel contentUpdateStudent = new JPanel();
			add(contentUpdateStudent, "updateStudent");

			JPanel contentInputMark = new JPanel();
			add(contentInputMark, "inputMark");

			JPanel contentEnterPayment = new JPanel();
			add(contentEnterPayment, "enterPayment");
		}

		// tab Account
		{
			AccountChangeStatusPanel contentChangeStatus = new AccountChangeStatusPanel();
			add(contentChangeStatus, "changeStatus");

//			JPanel contentChangeRole = new JPanel();
//			add(contentChangeRole, "changeRole");

			AccountResetPassword contentResetPass = new AccountResetPassword();
			add(contentResetPass, "resetPass");
		}

		// tab Other
		{
			JPanel contentCreateClass = new JPanel();
			add(contentCreateClass, "createClass");

			JPanel contentChangeClass = new JPanel();
			add(contentChangeClass, "changeClass");

			JPanel contentCreateCourse = new JPanel();
			add(contentCreateCourse, "createCourse");

			JPanel contentChangeCourse = new JPanel();
			add(contentChangeCourse, "changeCourse");

			JPanel contentCreateTuition = new JPanel();
			add(contentCreateTuition, "createTuition");

			JPanel contentChangeTuition = new JPanel();
			add(contentChangeTuition, "changeTuition");

			JPanel contentCreateSubject = new JPanel();
			add(contentCreateSubject, "createSubject");

			JPanel contentChangeSubject = new JPanel();
			add(contentChangeSubject, "changeSubject");
		}
		
		//tab report
		{
			JPanel contentGenerateCertificate = new JPanel();
			add(contentGenerateCertificate, "generateCertificate");
		}
		
		cardLayout = (CardLayout) (this.getLayout());
		showContent("home");
	}
	
	public void showContent(String index){
		cardLayout.show(this, index);
	}
}
