package framework.component;

public class PersonalNotificationRule implements NotificationRule {
	private double notifiAmount;

	public PersonalNotificationRule(double notifiAmount) {
		this.notifiAmount = notifiAmount;
	}

	public boolean ruleMatch(TransactionEntry transactionEntry) {

		if(transactionEntry.getEntryAmount()>=notifiAmount || transactionEntry.getAfterBalance()<0)

			return true;
		else
			return false;
	}
}
