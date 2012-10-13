package client.gui.admin;

import java.awt.CardLayout;

import javax.swing.JPanel;

import client.gui.admin.nav_panel.About;
import client.gui.admin.nav_panel.AccountChangeStatusPanel;
import client.gui.admin.nav_panel.AccountResetPassword;
import client.gui.admin.nav_panel.Certificate;
import client.gui.admin.nav_panel.CreateStudent;
import client.gui.admin.nav_panel.EnterPayment;
import client.gui.admin.nav_panel.HomePanel;
import client.gui.admin.nav_panel.InputMark;
import client.gui.admin.nav_panel.ManageCandidate;
import client.gui.admin.nav_panel.ManageClass;
import client.gui.admin.nav_panel.ManageCourse;
import client.gui.admin.nav_panel.ManageSubject;
import client.gui.admin.nav_panel.ManageTuition;
import client.gui.admin.nav_panel.UpdateStudent;
import client.gui.admin.nav_panel.ViewStudent;

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
			ViewStudent contentViewInfoStudent = new ViewStudent();
			add(contentViewInfoStudent, "viewInfoStudent");

			CreateStudent contentCreateStudent = new CreateStudent();
			add(contentCreateStudent, "createStudent");

			UpdateStudent contentUpdateStudent = new UpdateStudent();
			add(contentUpdateStudent, "updateStudent");

			InputMark contentInputMark = new InputMark();
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
			ManageClass contentManageClass = new ManageClass();
			add(contentManageClass, "manageClass");

			ManageCourse contentChangeCourse = new ManageCourse();
			add(contentChangeCourse, "manageCourse");

			ManageTuition contentManageTuition = new ManageTuition();
			add(contentManageTuition, "manageTuition");

			ManageCandidate contentManageCandidate = new ManageCandidate();
			add(contentManageCandidate, "manageCandidate");

			ManageSubject contentManageSubject = new ManageSubject();
			add(contentManageSubject, "manageSubject");
		}
		
		//tab report
		{
			Certificate contentGenerateCertificate = new Certificate();
			add(contentGenerateCertificate, "generateCertificate");
		}
		
		cardLayout = (CardLayout) (this.getLayout());
		showContent("home");
	}
	
	public void showContent(String index){
		cardLayout.show(this, index);
	}
}
