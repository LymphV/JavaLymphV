package LymphV;

import java.util.*;


public abstract class map<T1, T2> extends ArrayList<T2>
{	
	public map (Iterable<T1> ctr)
	{
		for (T1 x : ctr) this.add(f(x));
	}
	public map (T1[] a)
	{
		for (T1 x : a) this.add(f(x));
	}
	
	protected abstract T2 f (T1 t);
}
