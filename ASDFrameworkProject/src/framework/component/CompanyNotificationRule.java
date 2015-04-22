package framework.component;

public class CompanyNotificationRule implements NotificationRule {

	@Override
	public boolean ruleMatch(ITransactionEntry transactionEntry) {
		return true;
	}
}
