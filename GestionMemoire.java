import java.util.GregorianCalendar;

public class GestionMemoire
{
	public statis void main (String [] args) throws InterruptedException
	{
		double total;
		double reste;
		double pourcentage;

		for (int j = 0; j < 1000; j++)
		{
			creationTableau();
			total = Runtime.getRuntime().totalMemory();
			reste = Runtime.getRuntime().freeMemory();
			pourcentage = 100-(reste/total)*100;
			System.out.println("Creation du " + j + "ieme tableau memoire pleine a : " + pourcentage + "%");
			//Pauza na čítanie výžsledkov.....
			Thread.sleep (1000);
		}
	}

	public static void creationableau ()
	{
		Personne [] tablo;
		tablo = new Personne[1000];
		for (i = 0; i<1000;i++)
		{
			tablo[i] = new Personne("Dupont", "albert", new GregorianCalendar(1956,12,13));
		}
	}

}
