/**
 * 
 */
package eu.eavf;

/**
 * @author vovo
 *
 */

/**************** une horloge originale  *************************/

import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Ecran13 extends JFrame

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pano;
	JProgressBar pgbHeure,pgbMinutes,pgbSeconde,pgbDefil;
	
	public Ecran13()
	{
		setTitle("horloge");
		setBounds(0,0,300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// creation des composants
		pgbHeure =new JProgressBar();
		pgbMinutes=new JProgressBar();
		pgbSeconde=new JProgressBar();
		pgbDefil=new JProgressBar();
		pgbHeure.setMinimum(0);
		pgbHeure.setMaximum(23);
		pgbMinutes.setMinimum(0);
		pgbMinutes.setMaximum(59);
		pgbSeconde.setMinimum(0);
		pgbSeconde.setMaximum(59);
		pgbHeure.setString("heure");
		pgbHeure.setStringPainted(true);
		pgbMinutes.setString("minute");
		pgbMinutes.setStringPainted(true);
		pgbSeconde.setString("seconde");
		pgbSeconde.setStringPainted(true);
		pgbDefil.setString("le temps passe");
		pgbDefil.setStringPainted(true);
		pgbDefil.setIndeterminate(true);
		pano=new JPanel();
		pano.add(pgbHeure);
		pano.add(pgbMinutes);
		pano.add(pgbSeconde);
		pano.add(pgbDefil);
		getContentPane().add(pano);
		Thread th;
		th=new Thread()
		{
			public void run()
			{
				while (true)
				{
					GregorianCalendar d;
					d=new GregorianCalendar();
					pgbHeure.setValue(d.get(GregorianCalendar.HOUR));
					pgbMinutes.setValue(d.get(GregorianCalendar.MINUTE));
	pgbSeconde.setValue(d.get(GregorianCalendar.SECOND));
	try 
{
		sleep(500);
	} 
catch (InterruptedException e) 
	{
	}
}
}};
th.start();
}
}


