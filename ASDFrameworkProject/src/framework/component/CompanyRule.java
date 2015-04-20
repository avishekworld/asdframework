package framework.component;

public class CompanyRule implements NotificationRule {

	@Override
	public boolean ruleMatch(Entry entry) {
		return false;
	}
}
