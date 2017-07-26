public class Client extends Personne
{
	private char type;

	public char getType() {
	    return type;
	}

	public void setType(char type) {
	    this.type = type;
	}

	public void affichage ()
	{
		//volame rodicovsku funkciu affichage....
		affichage (true);

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
}