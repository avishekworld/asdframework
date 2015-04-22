package framework.component;

import java.util.HashMap;

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

		Personal personalCustomer = new Personal(guiData);
		Account account = new Account(guiData,accountType);
		personalCustomer.addAccount(account);
		controller.addCustomer(personalCustomer);

	}

}
