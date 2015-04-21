package framework.component;

public class Email {
	public String Addres;
	public String Subject;
	public String Body;
	public Email(String addres, String subject, String body) {
		super();
		Addres = addres;
		Subject = subject;
		Body = body;
	}
	
	public String toString()
	{
		
		String string="Email To : "+Addres+"\n Subject : "+Subject+"\n Message : "+Body;
		
		return string;
	}
}
