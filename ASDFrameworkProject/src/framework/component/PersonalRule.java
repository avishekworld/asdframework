package framework.component;


public class PersonalRule implements NotificationRule
{
	public Object amountLimit;
	public boolean ruleMatch(Entry entry) {
		return false;
	}
}
