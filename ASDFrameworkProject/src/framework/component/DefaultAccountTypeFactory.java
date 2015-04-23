package framework.component;

public class DefaultAccountTypeFactory extends AccountTypeFactory {

	@Override
	public String[] getAccountTypes() {
		return new String[] { "default" };
	}

	@Override
	public AccountType getAccountType(String typeName) {

		return new DefaultAccountType();

	}

}
