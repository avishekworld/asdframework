package framework.component;

public class SimpleAccountTypeFactory {

	public static AccountTypeFactory getDefaultTypeFactory()
	{
		return new DefaultAccountTypeFactory();
	}
}
