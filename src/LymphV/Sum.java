package LymphV;


public class Sum
{
	public static int sum(int[] an, int start)
	{
		for (int x : an) start += x;
		return start;
	}
	public static int sum(int[] an)
	{
		return sum(an,0);
	}
	public static int sum(Iterable<Integer> ctr, int start)
	{
		for (int x : ctr) start += x;
		return start;
	}
	public static int sum(Iterable<Integer> ctr)
	{
		return sum(ctr,0);
	}
	
	public static String sum(String[] as, String start)
	{
		for (String x : as) start += x;
		return start;
	}
	public static String sum(String[] as)
	{
		return sum(as, "");
	}
	public static String sum(Iterable<String> ctr, String start)
	{
		for (String x : ctr) start += x;
		return start;
	}
	
	
	public static double sum(double[] ad, double start)
	{
		for (Double x : ad) start += x;
		return start;
	}
	public static double sum(double[] ad)
	{
		return sum(ad,0);
	}
	public static Double sum(Iterable<Double> ctr, Double start)
	{
		for (Double x : ctr) start += x;
		return start;
	}
	
	
	
}
