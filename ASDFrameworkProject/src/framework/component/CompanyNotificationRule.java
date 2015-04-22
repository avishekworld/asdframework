package framework.component;

public class CompanyNotificationRule implements NotificationRule {

	@Override
	public boolean ruleMatch(TransactionEntry transactionEntry) {
		return true;
	}
}
