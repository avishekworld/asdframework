package framework.component;

public class SimpleTypeFactory {

	public static AccountTypeFactory getDefaultTypeFactory()
	{
		return new DefaultAccountTypeFactory();
	}
}
