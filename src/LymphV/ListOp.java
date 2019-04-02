package LymphV;

import java.util.*;

public class ListOp
{
	public static <T> List<T> mul (int times, List<T> list)
	{
		List<T> res = new ArrayList<T> ();
		for (int i = 0; i < times; ++i)
			res.addAll(list);
		return res;
	}
	
	public static <T> List<T> mul (List<T> list, int times)
	{
		return mul(times,list);
	}
	
	public static <T> List<T> add (List<T> list, List<T> other)
	{
		List<T> res = new ArrayList<T> ();
		res.addAll(list);
		res.addAll(other);
		return res;
	}
}
