package framework.component;

public interface ICustomer {
	
	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public void sendEmail(Email email);

	public String getKindOfAccount();
	
	public NotificationRule getNotificationRule();
	
	public void update(TransactionEntry transactionEntry);
	
	public String getName();
	
	public String getCity();
	
	public String getCustomerId();
	
	public IAccount getLastAddedAccount();
	
	
}
