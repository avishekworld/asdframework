package framework.component;

public class CompanyNotificationRule implements NotificationRule {

	@Override
	public boolean ruleMatch(Entry entry) {
		return false;
	}
}
