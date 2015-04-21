package framework.component;

import java.util.HashMap;

public class CompanyAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	
	public CompanyAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData) {
		this.controller = controller;
		this.guiData = guiData;
	}

	@Override
	public void exceute() {
		
		Company companyCustomer=new Company(guiData);
		Account account=new Account(guiData);
		companyCustomer.addAccount(account);
		controller.addCustomer(companyCustomer);
		
	}

}
