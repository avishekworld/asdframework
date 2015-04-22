package framework.component;

public class DefaultTypeFactory extends TypeFactory {

	@Override
	public String[] getTypes() {
		return new String[]{"default"};
	}

	@Override
	public AccountType getType(String typeName) {
		
			return new DefaultType();
		
	}


}
