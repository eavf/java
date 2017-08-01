import java.util.GregorianCalendar;
import java.util.Arrays;

public class Skuskaclient
{
	public static void main(String args[])
	{
		Client c, d;

		c = new Client("Frano", "Vladimir", new GregorianCalendar(1971,9,26), 'P');
		c.affichage(true);

		Commande cmd1, cmd2;

		//Vytvorenie a inicializovanie objednávky
		cmd1 = new Commande();
		cmd2 = new Commande();
		cmd1.setLeClient(c);
		System.out.println("Hash code objednávky je : " + cmd1.hashCode());
		System.out.println("Hash code klienta je : " + cmd1.getLeClient().hashCode());
		System.out.println("Hash code položiek je : " + cmd1.getLesLignes().hashCode());

		//Teraz kopirujeme
		try
		{
			cmd2 = (Commande)cmd1.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Hash code kópie objednávky je : " + cmd2.hashCode());
		System.out.println("Hash code kópie klienta je : " + cmd2.getLeClient().hashCode());
		System.out.println("Hash code kópie položiek je : " + cmd2.getLesLignes().hashCode());

		System.out.println("Teraz ideme porovnávať");
		d = new Client("Frano", "Vladimir", new GregorianCalendar(1971,9,26), 'P');

		if (c.equals(d))
		{
			System.out.println("Rovnajú sa");
			System.out.println("Hash code c : " + c.hashCode());
			System.out.println("Hash code d : " + d.hashCode());
			System.out.println("Hash code c.nom : " + c.getNom().hashCode());
			System.out.println("Hash code d.nom : " + d.getNom().hashCode());
		}

		else
		{
			System.out.println("Nerovnajú sa");
			System.out.println("Hash code c : " + c.hashCode());
			System.out.println("Hash code d : " + d.hashCode());
			System.out.println("Hash code c.nom : " + c.getNom().hashCode());
			System.out.println("Hash code d.nom : " + d.getNom().hashCode());
		}

		System.out.println("Skuska to string : \r\n");
		System.out.println(c);

		System.out.println("Skuska trier : \r\n");
		Personne [] tab;
		tab = new Personne [5];

		tab[0] = new Personne("toto3", "Prenom3", new GregorianCalendar(1922,2,15));
		tab[1] = new Personne("toto2", "Prenom2", new GregorianCalendar(1971,9,26));
		tab[2] = new Personne("toto5", "Prenom5", new GregorianCalendar(1955,2,21));
		tab[3] = new Personne("toto4", "Prenom4", new GregorianCalendar(1974,8,5));
		tab[4] = new Personne("toto1", "Prenom1", new GregorianCalendar(1942,2,7));

		Personne[] tabtrie;
		int [] hhh;
		hhh = new int [];
		tabtrie = (Personne[])tri(tab);

		for (int i = 0; i<tabtrie.lenght; i++)
		{
			System.out.println(tabtrie[i]);
		}

	}

}