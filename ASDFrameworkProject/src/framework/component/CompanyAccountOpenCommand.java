package framework.component;

import java.util.HashMap;

public class CompanyAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	AccountType accountType;
	
	public CompanyAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData, AccountType accountType) {
		this.controller = controller;
		this.guiData = guiData;
		this.accountType=accountType;
	}

	@Override
	public void exceute() {
		
		CompanyCustomer companyCustomer=new CompanyCustomer(guiData);
		IAccount account=new Account(guiData,accountType);
		companyCustomer.addAccount(account);
		controller.addCustomer(companyCustomer);
		
	}

}
