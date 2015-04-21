package framework.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;





import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import framework.component.Account;
import framework.component.Customer;
import framework.component.FinanceHandler;
import framework.component.TxtReport;


public class DefaultGui extends AGui {
	String accountnr, clientName, street, city, zip, state, accountType,
			clientType, amountDeposit;
	boolean newaccount;

	SymAction lSymAction;
	DefaultTableModel model;
	JButton JButton_PerAC;
	JButton JButton_CompAC;
	JButton JButton_Deposit;
	JButton JButton_Withdraw;
	JButton JButton_Addinterest;
	JButton JButton_GenerateReport;

	public DefaultGui(String title, FinanceHandler controller) {
		super(title, controller);

	}

	public void generateCreationButtons() {
		lSymAction = new SymAction();

		JButton_PerAC = new JButton("Add personal account");
		JButton_PerAC.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));
		JButton_CompAC = new JButton("Add company account");
		JButton_CompAC.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));
		
		JButton_GenerateReport = new JButton("Generate Report");
		JButton_GenerateReport.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));

		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_GenerateReport.addActionListener(lSymAction);

		creationButtonPanel.add(JButton_PerAC);
		creationButtonPanel.add(JButton_CompAC);
		creationButtonPanel.add(JButton_GenerateReport);

	}

	public void generateOperationButtons() {

		JButton_Deposit = new JButton("Deposit");
		JButton_Deposit.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));
		JButton_Withdraw = new JButton("Withdraw");
		JButton_Withdraw.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));

		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);

		operationButtonPanel.add(JButton_Deposit);
		operationButtonPanel.add(Box.createVerticalStrut(V_GAP));
		operationButtonPanel.add(JButton_Withdraw);
		operationButtonPanel.add(Box.createVerticalStrut(V_GAP));

	}

	public DefaultTableModel getTableModel() {
		model = new DefaultTableModel();

		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Amount");

		return model;
	}

	public void getTableData() {
		// System.out.println("Come here 2");
		/*
		 * HashMap<String, Account> accountList =
		 * controller.getModel().getAllAcounts();
		 */



		}



	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_GenerateReport)
				JButtonGenerateReport_actionPerformed(event);

		}
	}

	
	public void modelUpdated()
	{
		
		model.setRowCount(0);
		
		List<Account> allAccounts=controller.getAllAccount();
		
		for(Account account:allAccounts)
		{
			Object[] rawData=new Object[5];
			rawData[0] = account.getAccountNumber();
			rawData[1] = account.getOwner().getName();
			rawData[2] = account.getOwner().getCity();
			rawData[3] = account.getOwner().getKindOfAccount();
			rawData[4] = account.getAccountBalance();
	        model.addRow(rawData);
		}
	}
	

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {

		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 400);
		pac.show();



	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 400);
		pac.show();

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		

		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		
        if (selection >=0){
            String accountNumber = (String)model.getValueAt(selection, 0);
            
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accountNumber);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
        }
    		

		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        
        if (selection >=0){
            String accountNumber = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accountNumber);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
        }
		   

	}
	
	void JButtonGenerateReport_actionPerformed(java.awt.event.ActionEvent event)
	{
	    Date startDate=new Date("04/20/2015");
	    
		try {
			getController().generateReport(startDate, new Date(), new TxtReport());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		   

	}




}
