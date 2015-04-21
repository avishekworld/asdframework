package framework.component;

public class CreditCommand implements ICommand {

	FinanceHandler controller;
	String amount;
	String accoutnNumber;
	
	public CreditCommand(FinanceHandler controller,
			String accoutnNumber,String amount) {
		this.controller = controller;
		this.amount = amount;
		this.accoutnNumber=accoutnNumber;
	}

	@Override
	public void exceute() {
		
		Account account=controller.getAccount(accoutnNumber);
		account.doCredit(Double.parseDouble(amount));
		
	}
}
