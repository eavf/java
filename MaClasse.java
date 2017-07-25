public class MaClasse
{
	public static void main(String args[])
	{
		for (int i = 0; i<args.length; i++)
		{
		System.out.println("Argument " + i + " = " + args[i]);
		}

	int somme;
	somme = (Integer.parseInt(args[3])) + (Integer.parseInt(args[4]));
	System.out.println("Argument 3 + Argument 4 = " + somme);
	}
}
