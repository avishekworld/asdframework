package framework.component;

public interface ICustomer {
	
	public void addAccount(IAccount account);

	public void removeAccount(IAccount account);

	public void sendEmail(Email email);

	public String getCustomerType();
	
	public NotificationRule getNotificationRule();
	
	public void update(ITransactionEntry transactionEntry);
	
	public String getName();
	
	public String getCity();
	
	public String getCustomerId();
	
	public IAccount getLastAddedAccount();
	
	
}
