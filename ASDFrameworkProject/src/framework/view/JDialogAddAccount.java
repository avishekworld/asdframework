package framework.view;

/*
 A basic implementation of the JDialog class.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import framework.component.Account;
import framework.component.Customer;
import framework.component.ICommand;

public class JDialogAddAccount extends javax.swing.JDialog {
	protected AGui parentframe;
	protected ICommand command;
	protected HashMap<String, String> guiData;

	public JDialogAddAccount(AGui myframe) {
		super(myframe);
		parentframe = myframe;

		guiData = new HashMap<String, String>();
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 400);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 84, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 108, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 132, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 156, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 180, 48, 24);

		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 228, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 84, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 132, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 156, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 108, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 180, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84, 228, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 264, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 264, 84, 24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84, 60, 156, 20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 60, 48, 24);
		// }}

		setDefaulFormtData();
	}

	// {{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	protected javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	protected javax.swing.JLabel JLabel8 = new javax.swing.JLabel();

	// }}

	public void setDefaulFormtData() {

		JTextField_NAME.setText("Dummy Name");
		JTextField_STR.setText("1000 north ");
		JTextField_CT.setText("Fairfield");
		JTextField_ZIP.setText("52557");
		JTextField_ST.setText("Iowa");
		JTextField_EM.setText("name@email.com");

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
	
	public boolean inputValidate(List<String> allInput)
	{
		boolean isInputsOk=true;
		
		for(String input:allInput)
		{
			if(input.equals(""))
			{
				isInputsOk=false;
			}
		}
		
		return isInputsOk;
	}

	public void getCommonInputData() {
		guiData.put(Account.ACC_NUM_FIELD, JTextField_ACNR.getText());
		guiData.put(Customer.NAME_FIELD, JTextField_NAME.getText());
		guiData.put(Customer.STREET_FIELD, JTextField_STR.getText());
		guiData.put(Customer.CITY_FIELD, JTextField_CT.getText());
		guiData.put(Customer.ZIP_FIELD, JTextField_ZIP.getText());
		guiData.put(Customer.STATE_FIELD, JTextField_ST.getText());
		guiData.put(Customer.EMAIL_FIELD, JTextField_EM.getText());
	}

}
