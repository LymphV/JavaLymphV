package LymphV;

import java.util.*;

public class UFSet
{
	private int[] a, rnk;
	private int n;
	
	public void init (int n)
	{
		this.n = n;
		a = new int[n];
		rnk = new int[n];
		for (int i = 0; i < n; ++i)
		{
			a[i] = i;
			rnk[i] = 0;
		}
	}
	
	public UFSet (int n)
	{
		init(n);
	}
	
	public int find (int x)
	{
		assert x >= 0 && x < n;
		if (a[x] == x) return x;
		return a[x] = find(a[x]);
	}
	
	public void unite (int x, int y)
	{
		x = find(x);
		y = find(y);
	    if (x == y) return;

	    if (rnk[x] < rnk[y]) a[x] = y;
	    else
	    {
	        a[y] = x;
	        if (rnk[x] == rnk[y]) ++rnk[x];
	    }
	}
	
	public boolean same (int x, int y)
	{
		return find(x) == find(y);
	}
	
	public int[][] cluster ()
	{
		List<List<Integer>> tmp = new ArrayList<List<Integer>> ();
		
		for (int i = 0; i < n; ++i) if (i == find(i))
		{
			tmp.add(new ArrayList<Integer>());
			tmp.get(tmp.size() - 1).add(i);
		}
		
		for (List<Integer> x : tmp) for (int i = 0; i < n; ++i)
			if (i != x.get(0) && find(i) == x.get(0))
				x.add(i);
		
		int[][] res = new int[tmp.size()][];
		
		for (int i = 0; i < tmp.size(); ++i)
		{
			List<Integer> x = tmp.get(i);
			res[i] = new int[x.size()];
			for (int j = 0; j < x.size(); ++j)
				res[i][j] = x.get(j);
			Arrays.sort(res[i]);
		}
		return res;
	}
}
