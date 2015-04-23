package framework.component;

public class DebitCommand implements ITransactionCommand {

	FinanceHandler controller;
	String amount;
	String accoutnNumber;

	public DebitCommand(FinanceHandler controller, String accoutnNumber) {
		this.controller = controller;
		this.accoutnNumber = accoutnNumber;
	}

	@Override
	public void exceute() {

		IAccount account = controller.getAccount(accoutnNumber);
		account.doDebit(Double.parseDouble(amount));

	}

	@Override
	public void setAmount(String amount) {
		this.amount=amount;
		
	}

}
