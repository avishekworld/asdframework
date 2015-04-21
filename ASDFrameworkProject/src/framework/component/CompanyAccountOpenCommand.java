package framework.component;

import java.util.HashMap;

public class CompanyAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	Type accountType;
	
	public CompanyAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData, Type type) {
		this.controller = controller;
		this.guiData = guiData;
		accountType=type;
	}

	@Override
	public void exceute() {
		
		Company companyCustomer=new Company(guiData);
		Account account=new Account(guiData,accountType);
		companyCustomer.addAccount(account);
		controller.addCustomer(companyCustomer);
		
	}

}
