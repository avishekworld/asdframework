package framework.component;

import javax.swing.JOptionPane;



public class PopServer
{
	public static void sendEmail(Email email)
	{
		JOptionPane.showMessageDialog(null, email);
		//System.out.println(email);
	}
}
