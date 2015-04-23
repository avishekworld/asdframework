package framework.component;

public class CreditCommand implements ITransactionCommand {

	FinanceSystem controller;
	String amount;
	String accoutnNumber;


	public CreditCommand(FinanceSystem controller, String accoutnNumber) {

		this.controller = controller;
		this.accoutnNumber = accoutnNumber;
	}

	@Override
	public void exceute() {

		IAccount account = controller.getAccount(accoutnNumber);
		account.doCredit(Double.parseDouble(amount));

	}
	
	@Override
	public void setAmount(String amount) {
		this.amount=amount;
		
	}
}
