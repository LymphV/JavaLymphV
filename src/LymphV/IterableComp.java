package LymphV;

import java.util.Comparator;
import java.util.Iterator;

public class IterableComp<T extends Comparable<T>> implements Comparator<Iterable<T>>
{	
	public int compare(Iterable<T> self, Iterable<T> value)
	{
		Iterator<T> it1 = self.iterator();
		Iterator<T> it2 = value.iterator();
		
		while(it1.hasNext() && it2.hasNext())
		{
			T t1 = it1.next(), t2 = it2.next();
			assert t1 != null && t2 != null : "each element must not be null";
			int cmp = t1.compareTo(t2);
			if (cmp > 0) return 1;
			if (cmp < 0) return -1;
		}
		if (it1.hasNext() && !it2.hasNext()) return 1;
		if (!it1.hasNext() && it2.hasNext()) return -1;
		return 0;
	}
}
