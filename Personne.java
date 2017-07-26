
import java.util.GregorianCalendar;

public class Personne {

	private String nom = "nouveaunom";
	private String prenom = "nouveauprenom";
	private GregorianCalendar date_nais = new GregorianCalendar(1900,01,01);
	/*Cislo osoby*/
	private int numero;	
	/*Pocet osob v instanciach triedy*/
	private static int numInstance = initCompteur (); 

	public Personne ()
	{
		nom = "";
		prenom = "";
		date_nais = null;
		/*Vytvorenie novej osoby = zvysenie poctu osob*/
		numInstance++;
		/*priradenie noveho cisla osobe*/
		numero = numInstance;
		//System.out.println("Ahoj from personne.....");
	}

	public Personne (String n, String p, GregorianCalendar d)
	{
		nom = n;
		prenom = p;
		date_nais = d;
		/*Vytvorenie novej osoby = zvysenie poctu osob*/
		numInstance++;
		/*priradenie noveho cisla osobe*/
		numero = numInstance;
		//System.out.println("Ahoj from personne.....");
	}

	/*Metoda na inicializaciu poctu instancii*/
	private static int initCompteur ()
	{
		int cpt = 0;
		//System.out.println("Ahoj from personne/initcompteur.....");
		while (cpt<1000)
		{
			cpt = (int) (10000*Math.random());
			//System.out.println("cislo je : " + cpt);
		}
		return cpt;
	}

	/*Metoda na vratenie celkoveho poctu osob.....*/
	public static int getNbInstances ()
	{
		return numInstance;
	}

	/*Metoda na vratenie cisla aktualnej osoby*/
	public int getNumero ()
	{
		return numero;
	}


	public void setNumero(int numero)
	{
	    this.numero = numero;
	}

	public long calculAge ()
	{
		long age;
		date_nais = new GregorianCalendar (1963,11,29);
		age = new GregorianCalendar().getTimeInMillis()-date_nais.getTimeInMillis();
		age = age/1000/60/60/24/365;
		return age;
	}

	@Deprecated
	public void affichage ()
	{
		System.out.println("nom : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("age : " + calculAge());
	}


	public void affichage (boolean francais)
	{			/*Pr9klad na pretazenie funkcie affichage*/
		if (francais)
		{
			System.out.println("nom : " + nom);
			System.out.println("prenom : " + prenom);
			System.out.println("age : " + calculAge());
		}
		else
		{
			System.out.println("Surame : " + nom);
			System.out.println("Given name : " + prenom);
			System.out.println("Age : " + calculAge());
		}
	}

	public String getNom() {
	    return nom;
	}

	public void setNom(String nom) {
	    this.nom = nom.toUpperCase();
	}

	public GregorianCalendar getDate_nais() {
		return date_nais;
	}

	public void setDate_nais(GregorianCalendar date_nais) {
		this.date_nais = date_nais;
	}

	public String getPrenom() {
	    return prenom;
	}

	public void setPrenom(String prenom) {
	    this.prenom = prenom.toLowerCase();
	}

	@Override
	protected void finalize() throws Throwable
	{
		System.out.print("\u2020");
		super.finalize();
	}

}