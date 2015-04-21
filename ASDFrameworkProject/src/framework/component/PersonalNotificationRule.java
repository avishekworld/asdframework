package framework.component;


public class PersonalNotificationRule implements NotificationRule
{
	public double notifiAmount;
	
	public PersonalNotificationRule(double notifiAmount) {
		this.notifiAmount=notifiAmount;
	}
	
	public boolean ruleMatch(Entry entry) {
		
		if(entry.getEntryAmount()>=notifiAmount)
			return true;
		
		else return false;
	}
}
