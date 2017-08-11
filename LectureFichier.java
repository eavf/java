import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

public class LectureFichier
{
	public static void main (String args[])
	{
		try
		{
			lireFichier("bilan.txt");
		}
		catch (CaMarchePasException e)
		{
			FileWriter log;
			BufferedWriter br;
			try
			{
				log = new FileWriter("historique.txt", true);
				br = new BufferedWriter(log);
				br.write("\r\n----->" + new GregorianCalendar().getTime()+"<-----\r\n");
				br.write("erreur : " + e.getMessage() + "\r\n");
				for (int i  = 0; i<e.getStackTrace().length; i++)
				{
					br.write(" dans le fichier " + e.getStackTrace()[i].getFileName());
					br.write(" a la ligne " + e.getStackTrace()[i].getLineNumber());
					br.write(" dans la methode " + e.getStackTrace()[i].getMethodName());
					br.write(" de la classe " + e.getStackTrace()[i].getClassName());
				}
				br.close();
				log.close();
			}

			catch (IOException ex)
			{
				System.out.println("erreur dans l´application...");
			}
		}
	}


	public static void lireFichier (String nom) throws CaMarchePasException
	{
		FileInputStream fichier = null;
		BufferedReader br = null;
		String ligne = null;

		try
		{
			fichier = new FileInputStream(nom);
			br = new BufferedReader(new InputStreamReader (fichier));
			ligne = br.readLine();
			while (ligne != null)
			{
				System.out.println(ligne);
				ligne = br.readLine();
			}
		}
		catch (FileNotFoundException e)
		{
			throw new CaMarchePasException ("Le fichier n´existe pas ...", e);
		}
		catch (IOException e)
		{
			throw new CaMarchePasException ("L´erreur de lecture de fichier ...", e);
		}
	}
}

