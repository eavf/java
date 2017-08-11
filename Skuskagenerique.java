import java.util.GregorianCalendar;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Skuskagenerique
{
	static ListeGenerique<Personne> liste = new ListeGenerique<Personne>(5);


	public static void main(String args[])
	{

		liste.ajout(new Client("toto3", "Prenom3", new GregorianCalendar(1922,2,15),'E'));
		liste.ajout(new Client("toto2", "Prenom2", new GregorianCalendar(1971,9,26),'E'));
		liste.ajout(new Client("toto5", "Prenom5", new GregorianCalendar(1955,2,21),'P'));
		liste.ajout(new Client("toto4", "Prenom4", new GregorianCalendar(1974,8,5),'P'));
		liste.ajout(new Client("toto1", "Prenom1", new GregorianCalendar(1942,2,7),'E'));

		try 
		{
			tri(liste);
		}
		catch (Exception g)
			{
				System.out.println(g.getMessage());
			}
		

		menu();
	}

	public static void menu ()
	{
		char choix = '\0';

		System.out.println("p - premier, < - precedent, > - suivant, d - dernier, f - fin");

		while (choix != 'f')
		{
			try
			{
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(System.in));
				choix = br.readLine().charAt(0);
				switch (choix)
				{
					case 'p':
					System.out.println("le premier " + liste.premier());
					break;
					case '<':
					System.out.println("le precedente " + liste.precedent());
					break;
					case '>':
					System.out.println("le suivante " + liste.suivant());
					break;
					case 'd':
					System.out.println("le dernier " + liste.dernier());
					break;
				}

			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		System.out.println("p - premier, < - precedent, > - suivant, d - dernier, f - fin");
		}
	}


	public static <T extends Classable> void tri (ListeGenerique<T> liste) throws Exception
	{

		int i,j;
		T c;

		for (i = 0; i < liste.getTaillListe()-1; i++)
		{
			for (j = i+1; j<liste.getTaillListe(); j++)
			{

				if (liste.getElement(j).compare(liste.getElement(i)) == Classable.INFERIEUR)
				{
					c = liste.getElement(j);
					liste.remplace(liste.getElement(i),j);
					liste.remplace(c,i);
				}
				else if (liste.getElement(j).compare(liste.getElement(i)) == Classable.ERREUR)
				{
					throw new Exception ("Erreur pendant le tri");
				}

			} 
		}
	}
}