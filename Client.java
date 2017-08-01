import java.util.GregorianCalendar;

public class Client extends Personne
{
	//Pozor, toto je typ klienta, nie osoby!
	private char type;

	public Client()
	{
		super();
	}

	public Client(String nom, String prenom, GregorianCalendar date_nais, char type)
	{
		super (nom, prenom, date_nais);
		this.type = type;
	}

	public char getType() {
	    return type;
	}

	public void setType(char type) {
	    this.type = type;
	}

	public void affichage (boolean francaise)
	{
		//volame rodicovsku funkciu affichage....
		super.affichage (francaise);

		if (francaise == true)
		{
			switch (type)
			{
				case 'P':
					System.out.println("type de client : Particulier");
					break;
				case 'E':
					System.out.println("type de client : Entreprise");
					break;
				case 'A':
					System.out.println("type de client : Administration");
					break;
				default:
					System.out.println("type de client : Inconnu");
					break;
			}
		}
		else
		{
		switch (type)
			{
				case 'P':
					System.out.println("type of client : Private");
					break;
				case 'E':
					System.out.println("type of client : Entreprise");
					break;
				case 'A':
					System.out.println("type of client : Administration");
					break;
				default:
					System.out.println("type of client : Non-known");
					break;
			}
		}

	}

	public boolean equals (Object obj)
	{
		Client c;
		//Kontrola ci je null alebo nie je client
		if (obj ==null || obj.getClass()!=this.getClass())
		{
			return false;
		}
		else
		{
			c=(Client)obj;
			if (c.getNom().equals(getNom()) & 
				c.getPrenom().equals(getPrenom()) & 
				c.getDate_nais().equals(getDate_nais()) & 
				c.getType()==getType())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	public int hashCode()
	{
		return this.getNom().hashCode() + this.getPrenom().hashCode() + this.getDate_nais().hashCode() + (int) this.getType();
	}
}