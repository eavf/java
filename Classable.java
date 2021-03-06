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

}