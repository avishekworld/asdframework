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
		// TODO Auto-generated method stub
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
			} else {
				System.out
						.println("Sorry could not create \"Reports\" directory");
			}
		}

		for (Entry e : inputListOfEntry) {
			writeEntryOnFile(e);
		}

	}

	protected void writeEntryOnFile(Entry entry) {
		try (PrintWriter out = new PrintWriter(output)) {
			out.println(entry.toString());
			out.close();
		}
	}
	/*
	 * public static void main(String[] args) throws IOException { TxtReport tR
	 * = new TxtReport("Readme"); Entry entry = new CreditEntry(100, 10, "sda");
	 * tR.writeEntryOnFile(entry); }
	 */
}
