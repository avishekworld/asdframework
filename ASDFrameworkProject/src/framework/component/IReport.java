package framework.component;

import java.util.List;

public interface IReport {
	public void Generate(String accountNumber, List<ITransactionEntry> inputListOfEntry);
	public void setAccount(IAccount account);
}
