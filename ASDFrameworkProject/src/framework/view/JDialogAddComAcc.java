package framework.view;

import javax.swing.JLabel;
import javax.swing.JTextField;

import framework.component.Company;
import framework.component.CompanyAccountOpenCommand;
import framework.component.SimpleTypeFactory;

public class JDialogAddComAcc extends JDialogAddAccount {

	protected JTextField JTextField_NoOfEmp = new JTextField();
	JLabel JLabel6 = new JLabel();
	protected SymAction mySymAction = new SymAction();

	public JDialogAddComAcc(AGui myframe) {
		super(myframe);

		JTextField_NoOfEmp = new JTextField();

		// JTextField_NoOfEmp.setText("8");
		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(84, 204, 156, 20);

		JLabel6.setText("Total employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 204, 96, 24);

		JButton_OK.addActionListener(mySymAction);
		JButton_Cancel.addActionListener(mySymAction);

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

		guiData.put(Company.NO_OF_EMPLOYEE_FIELD, JTextField_NoOfEmp.getText());
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		getCommonInputData();

		String type = SimpleTypeFactory.getDefaultTypeFactory().getTypes()[0];

		command = new CompanyAccountOpenCommand(parentframe.getController(),
				guiData, SimpleTypeFactory.getDefaultTypeFactory()
						.getType(type));
		command.exceute();

		parentframe.modelUpdated();

		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}

}
