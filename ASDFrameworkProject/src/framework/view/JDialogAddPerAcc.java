package framework.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import framework.component.PersonalAccountOpenCommand;
import framework.component.PersonalCustomer;
import framework.component.SimpleAccountTypeFactory;

public class JDialogAddPerAcc extends JDialogAddAccount {

	protected JTextField JTextField_BD;
	JLabel JLabel6;

	protected SymAction personalAccActionListner = new SymAction();

	public JDialogAddPerAcc(AGui myframe) {
		super(myframe);

		JTextField_BD = new JTextField();
		//JTextField_BD.setText("10/11/1988");
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84, 204, 156, 20);

		JLabel6 = new JLabel();
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 204, 96, 24);

		JButton_OK.addActionListener(personalAccActionListner);
		JButton_Cancel.addActionListener(personalAccActionListner);

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	public void getCommonInputData() {

		super.getCommonInputData();

		guiData.put(PersonalCustomer.BIRTH_DATE_FIELD, JTextField_BD.getText());
	}
	

	public static boolean isDateValid(String date) {
		String DATE_FORMAT = "mm/dd/yyyy";
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

		getCommonInputData();

		boolean allInputOK = inputValidate(new ArrayList<String>(
				guiData.values()));

		if (allInputOK) {

			if (isDateValid(guiData.get(PersonalCustomer.BIRTH_DATE_FIELD)) == false) {

				JOptionPane
						.showMessageDialog(null, "Insert date as mm/dd/yyyy");

				return;
			}

			String type = SimpleAccountTypeFactory.getDefaultTypeFactory()
					.getAccountTypes()[0];

			command = new PersonalAccountOpenCommand(
					parentframe.getController(), guiData, SimpleAccountTypeFactory
							.getDefaultTypeFactory().getAccountType(type));
			command.exceute();

			parentframe.modelUpdated();

			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Please Input All Data");
		}
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}

}
