package framework.component;

public abstract class AccountTypeFactory {

	public abstract String[] getAccountTypes();

	public abstract AccountType getAccountType(String typeName);

}
