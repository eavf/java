import java.util.GregorianCalendar;

public class GestionMemoire
{
	public static void main (String [] args) throws InterruptedException
	{
		double total;
		double reste;
		double pourcentage;
		Personne c,d;

		System.out.println("Ahoj");

		//Skuska tiredy Personne
		//c = new Personne("Frano", "VLADIMIR", new GregorianCalendar(1971,9,26));
		//d = new Personne();
		//c.affichage(true);
		//d.affichage(true);

		for (int j = 0; j < 1000; j++)
		{
			creationTableau();
			total = Runtime.getRuntime().totalMemory();
			reste = Runtime.getRuntime().freeMemory();
			pourcentage = 100-(reste/total)*100;
			System.out.println("Creation du " + j + "ieme tableau memoire pleine a : " + pourcentage + "%");
			//Pauza na čítanie výžsledkov.....
			Thread.sleep (100);
		}
	}

	public static void creationTableau ()
	{
		Personne [] tablo = new Personne[1000];
		for (int i = 0; i<1000;i++)
		{
			//System.out.println(" : " + i);
			tablo[i] = new Personne("Dupont", "albert", new GregorianCalendar(1956,12,13));
		}
	}

}
