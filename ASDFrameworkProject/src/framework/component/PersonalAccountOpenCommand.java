package framework.component;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class PersonalAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	AccountType accountType;

	public PersonalAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData,AccountType accountType) {
		this.controller = controller;
		this.guiData = guiData;
		this.accountType=accountType;
	}

	@Override
	public void exceute() {

		if(controller.getAccount(guiData.get(Account.ACC_NUM_FIELD))==null)
		{
			ICustomer personalCustomer = new PersonalCustomer(guiData);
			Account account = new Account(guiData,accountType);
			personalCustomer.addAccount(account);
			controller.addCustomer(personalCustomer);
			
			//JOptionPane.showMessageDialog(null, "Account "+guiData.get(Account.ACC_NUM_FIELD)+" created");
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Account "+guiData.get(Account.ACC_NUM_FIELD)+" already Exits");
		}

	}

}
