package LymphV;

import java.util.Comparator;

public class v
{
	public static final int LymphVersion = 20190329;
	
	/*****************************
	 * python.range
	 * @param >=1 && <=3 ints
	 * @return a iterable range
	 */
	public static range range (int... args)
	{
		return new range(args);
	}
	
	/**********************
	 * python.print
	 * @param things to print
	 */
	public static void print (Object... objects)
	{
		if (objects == null) 
		{
			System.out.println("null");
			return;
		}
		System.out.println(StringOp.join(" ", objects));
	}
	
	/*public static void print (Object object)
	{
		System.out.println(object);
	}*/
	
	public static<First,Second> Pair<First,Second> pair(First fst, Second snd)
	{
		return new Pair<First,Second>(fst,snd);
	}
	
	public static <T extends Comparable<T>> Comparator<Iterable<T>> getComparator (Iterable<T> iterable)
	{
		return new IterableComp<T> ();
	}
	
	public static <T extends Comparable<T>> Comparator<T> getComparator (T t)
	{
		return new Comparator<T> ()
		{
			public int compare(T self, T value)
			{
				return self.compareTo(value);
			}
		};	
	}
}
