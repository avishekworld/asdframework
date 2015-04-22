package framework.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import framework.component.CompanyAccountOpenCommand;
import framework.component.CompanyCustomer;
import framework.component.PersonalCustomer;
import framework.component.PersonalAccountOpenCommand;
import framework.component.SimpleTypeFactory;

public class JDialogAddPerAcc extends JDialogAddAccount {

	protected JTextField JTextField_BD;
	JLabel JLabel6 = new javax.swing.JLabel();

	protected SymAction mySymAction = new SymAction();

	public JDialogAddPerAcc(AGui myframe) {
		super(myframe);

		JTextField_BD = new JTextField();
		JTextField_BD.setText("10/11/1988");
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84, 204, 156, 20);

		JLabel6.setText("Birthdate");
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
		
		guiData.put(PersonalCustomer.BIRTH_DATE_FIELD, JTextField_BD.getText());
	}
	
	

	public static boolean isDateValid(String date) 
	{
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
		
		boolean allInputOK=inputValidate(new ArrayList<String>(guiData.values()));

		if(allInputOK){
			
			if(isDateValid(guiData.get(PersonalCustomer.BIRTH_DATE_FIELD))==false)
			{
			
			    JOptionPane.showMessageDialog(null, "Insert date as mm/dd/yyyy");
			  
			    return;
			}

			String type = SimpleTypeFactory.getDefaultTypeFactory().getTypes()[0];

			command = new PersonalAccountOpenCommand(parentframe.getController(),
					guiData, SimpleTypeFactory.getDefaultTypeFactory()
							.getType(type));
			command.exceute();

			parentframe.modelUpdated();

			dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Please Input All Data");
		}
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}

}
