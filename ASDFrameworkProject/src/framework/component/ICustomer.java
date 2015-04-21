package framework.component;

public interface ICustomer {
	public void addAccount(Account account);

	public void removeAccount(Account account);

	public void sendEmail(Email email);

	public String getCustomerType();
}
