




public abstract class Customer implements ICustomer, IObserver
{
	protected Object Name;
	protected Object Street;
	protected Object City;
	protected Object State;
	protected Object Zip;
	protected Object Email;
	private Object customerId;
	private ArrayList<Account> accountList;
	public Object NotificationRule;
	public void addAccount(Object Account)
	{
	
	}
	
	public void removeAccount(Object Account)
	{
	
	}
	
	public void sendEmail(Object String)
	{
	
	}
	
	public void update(Object Entry)
	{
	
	}
	
	public void addAccount(Object Account);
	
	public void removeAccount(Object Account);
	
	public void sendEmail(Object String);
	
	public void update(Object Entry);
}
