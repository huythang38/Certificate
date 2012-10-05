package client.gui.admin;

import java.awt.CardLayout;

import javax.swing.JPanel;

import client.gui.admin.nav_panel.About;
import client.gui.admin.nav_panel.AccountChangeStatusPanel;
import client.gui.admin.nav_panel.AccountResetPassword;
import client.gui.admin.nav_panel.EnterPayment;
import client.gui.admin.nav_panel.HomePanel;
import client.gui.admin.nav_panel.ManageCandidate;
import client.gui.admin.nav_panel.ManageCourse;
import client.gui.admin.nav_panel.ManageTuition;

@SuppressWarnings("serial")
public class NavContentPanel extends JPanel {
	public CardLayout cardLayout;
	
	public NavContentPanel() {
		setLayout(new CardLayout());
		// tab home
		{
			HomePanel contentHome = new HomePanel();
			add(contentHome, "home");

			About contentAbout = new About();
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

			EnterPayment contentEnterPayment = new EnterPayment();
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

			ManageCourse contentChangeCourse = new ManageCourse();
			add(contentChangeCourse, "manageCourse");

			ManageTuition contentManageTuition = new ManageTuition();
			add(contentManageTuition, "manageTuition");

			ManageCandidate contentManageCandidate = new ManageCandidate();
			add(contentManageCandidate, "manageCandidate");

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
