package framework.component;

import java.util.HashMap;

public class PersonalAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	
	public PersonalAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData) {
		this.controller = controller;
		this.guiData = guiData;
	}

	@Override
	public void exceute() {
		
		Personal personalCustomer=new Personal(guiData);
		Account account=new Account(guiData);
		personalCustomer.addAccount(account);
		controller.addCustomer(personalCustomer);
		
	}

}
