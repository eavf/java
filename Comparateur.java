//toto interface musí byť implementované triedami pre ktoré 
//je rátané s usporiaduvávaním inštancií 
//jedná sa o všeovecnejší interface ako Classable.

public interface Comparateur 
{
	//táto metóda môže byť volaná na porovnanie dvoch objektov dodaných ako parameter
	//metóda vráti celé číslo, ktorého hodnota závisí na nasledujúcich pravidlách:

	//1 - ak aktuálna o1 je väčšia ako o2
	//0 - ak sú zhodné
	//-1 - ak o1 je menšia ako o2  
	//-99 - ak porovnanie je nemožné

	int compare (Object o1, Object o2);

	public static final int INFERIEUR = -1;
	public static final int EGAL = 0;
	public static final int SUPERIEUR = 1;
	public static final int ERREUR = -99;

}