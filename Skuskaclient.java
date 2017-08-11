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

		System.out.println("\r\nSkuska trier : \r\n");
		Personne [] tab;
		tab = new Client [5];

		tab[0] = new Client("toto3", "Prenom3", new GregorianCalendar(1922,2,15),'E');
		tab[1] = new Client("toto2", "Prenom2", new GregorianCalendar(1971,9,26),'E');
		tab[2] = new Client("toto5", "Prenom5", new GregorianCalendar(1955,2,21),'P');
		tab[3] = new Client("toto4", "Prenom4", new GregorianCalendar(1974,8,5),'P');
		tab[4] = new Client("toto1", "Prenom1", new GregorianCalendar(1942,2,7),'E');

		Client[] tabtrie;
		tabtrie = (Client[]) tri(tab);
		
		System.out.println("dlzka tabtrie :" + tabtrie.length + " \r\n");

		for (int i = 0; i<tabtrie.length; i++)
		{
			System.out.println("Index prvku : " + i);
			System.out.println(tabtrie[i] + "\r\n");
		}


		Client[] tabtrie1;
		tabtrie1 = (Client[]) tri1(tab,
			//vytvorenie inštancie triedy implem,entujúcej interface Comparateur
			new Comparateur()
			//kéod triedy
			{
				//na zaklade požiadavky interface definicia metódy compare
				public int compare (Object o1, Object o2)
				{
					Personne p1, p2;
					if (o1 instanceof Personne & o2 instanceof Personne)
					{
						p1 = (Personne) o1;
						p2 = (Personne) o2;
					}
					else
					{
						return Classable.ERREUR;
					}
					if (p1.getNom().compareTo(p2.getNom())<0)
					{
						return Classable.INFERIEUR;
					}
					if (p1.getNom().compareTo(p2.getNom())>0)
					{
						return Classable.SUPERIEUR;
					}
					return Classable.EGAL;
				}
			}
			);
		
		System.out.println("Teraz Comparateur\r\n");
		System.out.println("dlzka tabtrie :" + tabtrie1.length + " \r\n");

		for (int i = 0; i<tabtrie1.length; i++)
		{
			System.out.println("Index prvku : " + i);
			System.out.println(tabtrie1[i] + "\r\n");
		}
	}

	public static Classable[] tri (Classable tablo[])
	{
		//Classable [] - týmto vyžadujeme aby objekt predaný ako parameter implementoval Classable interface.....
		//Funa tri má za úlohu vrátiť tablo v zoradenom formáte.
		//tablo je vlastne pole inštancií objektov implementujúcich Classable.....
		int i,j;
		Classable c;

		for (i = 0; i < tablo.length; i++)
		{
			for (j = i+1; j<tablo.length; j++)
			{
				if (tablo[j].compare(tablo[i]) == Classable.INFERIEUR)
				{
					c = tablo[j];
					tablo[j] = tablo[i];
					tablo[i] = c;
				}
				else if (tablo[j].compare(tablo[i]) == Classable.ERREUR)
				{
					return null;
				}

			} 
		}
	return tablo;
	} 


	public static Object[] tri1 (Object tablo[], Comparateur trieur)
	{
		//Classable [] - týmto vyžadujeme aby objekt predaný ako parameter implementoval Classable interface.....
		//Funa tri má za úlohu vrátiť tablo v zoradenom formáte.
		//tablo je vlastne pole inštancií objektov implementujúcich Classable.....
		int i,j;
		Object c;
		Object[] tabloTri;
		tabloTri = Arrays.copyOf(tablo, tablo.length);

		for (i = 0; i < tabloTri.length; i++)
		{
			for (j = i+1; j<tabloTri.length; j++)
			{
				//používa metódu compare objektu, ktorý mu bol predaný 
				//ako parameter na porovnávanie obsahu dvoch polí tabuľky
				if (trieur.compare(tabloTri[j],tabloTri[i]) == Comparateur.INFERIEUR)
				{
					c = tabloTri[j];
					tabloTri[j] = tabloTri[i];
					tabloTri[i] = c;
				}
				else if (trieur.compare(tabloTri[j],tabloTri[i]) == Comparateur.ERREUR)
				{
					return null;
				}

			} 
		}
	return tabloTri;
	} 
}