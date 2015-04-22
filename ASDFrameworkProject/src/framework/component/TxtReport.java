package framework.component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TxtReport implements IReport {
	File file;
	String dirPath = "Reports";
	BufferedWriter output;

	public TxtReport() throws IOException {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void Generate(String accountNumber, List<Entry> inputListOfEntry) {
		
		createFile(accountNumber);
		
		PrintWriter out = new PrintWriter(output);
		
		out.println("[ Date \t\t Befor Balance \t Issuer Name \t Account Type \t Amount \t New Amount ]");
		
		for (Entry entry: inputListOfEntry) {
			
			out.println(entry.toString());
		}
		
		out.close();
	}
	
	void createFile(String accountNumber)
	{
		File file = new File(dirPath);
		if (file.exists()) {
			// System.out.println("File Exists");
			file = new File(dirPath + "/" + accountNumber + ".txt");
			System.out.println("Report Created @ " + file.getAbsolutePath());
			try {
				output = new BufferedWriter(new FileWriter(file, true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			boolean wasDirecotyMade = file.mkdirs();
			if (wasDirecotyMade) {
				System.out.println("Direcoty Created @ "
						+ file.getAbsolutePath());
				try {
					file = new File(dirPath + "/" + accountNumber + ".txt");
					output = new BufferedWriter(new FileWriter(file, true));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out
						.println("Sorry could not create \"Reports\" directory");
			}
		}

		
	}

	/*
	 * public static void main(String[] args) throws IOException { TxtReport tR
	 * = new TxtReport("Readme"); Entry entry = new CreditEntry(100, 10, "sda");
	 * tR.writeEntryOnFile(entry); }
	 */
}
