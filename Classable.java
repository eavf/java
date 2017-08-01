//toto interface musí byť implementované triedami pre ktoré 
//je rátané s usporiaduvávaním inštancií 

public interface Classable 
{
	//táto metóda môže byť volaná na porovnanie aktuálnej inštancie 
	//s tou, ktorá bola daná ako parameter
	//metóda vráti celé číslo, ktorého hodnota závisí na nasledujúcich pravidlách:

	//1 - ak aktuálna inštancia je väčšia ako tá, daná ako parameter
	//0 - ak sú zhodné
	//-1 - ak aktuálna inštancia je menšia ako tá, daná ako parameter  
	//-99 - ak porovnanie je nemožné

	int compare (Object o);

	public static final int INFERIEUR = -1;
	public static final int EGAL = 0;
	public static final int SUPERIEUR = 1;
	public static final int ERREUR = -99;

	public static Classable[] tri (Classable tablo[])
	{
		//Classable [] - týmto vyžadujeme aby objekt predaný ako parameter implementoval Classable interface.....
		//Funa tri má za úlohu vrátiť tablo v zoradenom formáte.
		//tablo je vlastne pole inštancií objektov implementujúcich Classable.....
		int i,j,k;
		Classable c;

		for (i = 0; i < 4; i++)
		{
			for (j = i+1; j<4; j++)
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
}