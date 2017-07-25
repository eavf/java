import java.io.IOException;

public class Slucky
{
	static boolean stop;

	public static void main(String args[])
	{
		new Thread ()			/*Tento thread bezi nezavysle do bloku while dole. 
								Jeho jedina uloha je citat stdin ci nieco uzivatel nezadal*/
		{
			public void run()
			{
				int c;
				try
				{
					c = System.in.read();
					stop = true;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}.start();

		long compteur = 0;
		while (true)
		{
			compteur++;
			if (compteur%2==0)
				continue;
			if (stop)
				break;
			System.out.println(compteur);
		}
	}
}
