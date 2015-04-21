package framework.component;

import java.util.HashMap;

public class DebitCommand implements ICommand {

	FinanceHandler controller;
	String amount;
	String accoutnNumber;
	
	public DebitCommand(FinanceHandler controller,
			String accoutnNumber,String amount) {
		this.controller = controller;
		this.amount = amount;
		this.accoutnNumber=accoutnNumber;
	}

	@Override
	public void exceute() {
		
		Account account=controller.getAccount(accoutnNumber);
		account.doDebit(Double.parseDouble(amount));
		
	}

}
