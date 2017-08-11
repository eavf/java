import java.applet.Applet;
import java.awt.Graphics;


public class TestApplet extends Applet
{
	private String message;
	


	public void destroy()
	{
		message = getMessage() + "methode destroy \r\n";
	}

	public void init()
	{
		message = getMessage() + "methode init \r\n";
	}

	public void start()
	{
		message = getMessage() + "methode start \r\n";
	}

	public void stop()
	{
		message = getMessage() + "methode stop \r\n";
	}

	public void paint(Graphics g)
	{
		message = getMessage() + "methode paint \r\n";
		g.drawString(getMessage(), 10, 20);
	}

	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}
}