public class ManStr
{
	public static void main(String args[])
	{
		long duree;
		String lievre = "ASDF";
		String tortue = "ASDF";
		long debut, fin;
		debut = System.currentTimeMillis();

		for (int i = 0; i<= 10000; i++)
			{
				tortue = tortue + " " + i;
			}
		fin = System.currentTimeMillis();
		duree = fin - debut;
		System.out.println("Duree pour la tortue : " + duree + "ms");

		debut = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i<= 10000; i++)
			{
				sb.append(" ");
				sb.append(i);
			}

		lievre= sb.toString();
		fin = System.currentTimeMillis();
		duree = fin-debut;
		System.out.println("duree pour le lievre : " + duree + "ms");

		if (lievre.equals(tortue))
			{
				System.out.println("Les deux chaines sont identiques ");
			}
	
	}
}
