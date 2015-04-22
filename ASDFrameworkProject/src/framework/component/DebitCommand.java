package framework.component;

public class DebitCommand implements ICommand {

	FinanceHandler controller;
	String amount;
	String accoutnNumber;

	public DebitCommand(FinanceHandler controller, String accoutnNumber,
			String amount) {
		this.controller = controller;
		this.amount = amount;
		this.accoutnNumber = accoutnNumber;
	}

	@Override
	public void exceute() {

		IAccount account = controller.getAccount(accoutnNumber);
		account.doDebit(Double.parseDouble(amount));

	}

}
