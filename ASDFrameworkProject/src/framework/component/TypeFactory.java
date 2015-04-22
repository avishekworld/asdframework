package framework.component;

public abstract class TypeFactory {
	
	public abstract String[] getTypes();
	
	public abstract AccountType getType(String typeName);

}
