import java.util.ArrayList;

public class ListeGenerique <T>

{
	private ArrayList <T> liste;
	private int position;
	private int nbElements;


	public ListeGenerique (int taille)
	{
		liste = new ArrayList (taille);
	}


	public void ajout (T element)
	{
		liste.add(element);
		nbElements = nbElements + 1;
	}


	public void insert (T element, int index)
	{
		if (index >= nbElements || index < 0)
		{
			return;
		}

		liste.add(index, element);
		nbElements = nbElements + 1;
	}


	public void remplace (T element, int index)
	{
		if (index >= nbElements || index < 0)
		{
			return;
		}

		liste.set(index, element);
	}


	public void supprime (int index)
	{
		int i;
		if (index >= nbElements || index < 0)
		{
			return;
		}

		liste.remove(index);
		nbElements = nbElements - 1;
	}


	public int getTaillListe ()
	{
		return nbElements;
	}

	public T getElement(int index) throws Exception
	{
		if (nbElements == 0)
		{
			throw new Exception ("Liste est vide");
		}
		if (index > nbElements-1)
		{
			throw new Exception ("Index hors du rang");
		}
		position = index;
		return liste.get(position);
	}


	public T premier() throws Exception
	{
		if (nbElements == 0)
		{
			throw new Exception ("Liste est vide");
		}
		position = 0;
		return liste.get(0);
	}


	public T dernier() throws Exception
	{
		if (nbElements == 0)
		{
			throw new Exception ("Liste est vide");
		}
		position = nbElements - 1;
		return liste.get(position);
	}


	public T suivant() throws Exception
	{
		if (nbElements == 0)
		{
			throw new Exception ("Liste est vide");
		}

		if (position == nbElements-1)
		{
			throw new Exception ("pas d´element suivant...");
		}

		position = position + 1;
		return liste.get(position);
	}



	public T precedent() throws Exception
	{
		if (nbElements == 0)
		{
			throw new Exception ("Liste est vide");
		}

		if (position == 0)
		{
			throw new Exception ("pas d´element precedent...");
		}

		position = position - 1;
		return liste.get(position);
	}

}