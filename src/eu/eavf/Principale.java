/**
 * 
 */
package eu.eavf;


/**
 * @author vovo
 *
 */
public class Principale {

	public static void main (String[] args)
	{
		Ecran14 fenetre;
		fenetre = new Ecran14();
		
		EcouteurFenetre ef;
		ef = new EcouteurFenetre();
		fenetre.addWindowListener(ef);
		
		fenetre.setVisible(true);
	}
}
