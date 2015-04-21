package framework.component;


public class PersonalNotificationRule implements NotificationRule
{
	public Object amountLimit;
	public boolean ruleMatch(Entry entry) {
		return false;
	}
}
