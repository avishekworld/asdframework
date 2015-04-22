package framework.component;

import java.util.Date;

public interface ITransactionEntry {
	

	public double getPreviousBalance();

	public double getNewBalance();

	public Date getDate();

	public String getEntryType();


	public double getEntryAmount();

}
