package framework.component;

public class CreditCommand implements ICommand {

	FinanceSystem controller;
	String amount;
	String accoutnNumber;

	public CreditCommand(FinanceSystem controller, String accoutnNumber,
			String amount) {
		this.controller = controller;
		this.amount = amount;
		this.accoutnNumber = accoutnNumber;
	}

	@Override
	public void exceute() {

		IAccount account = controller.getAccount(accoutnNumber);
		account.doCredit(Double.parseDouble(amount));

	}
}
