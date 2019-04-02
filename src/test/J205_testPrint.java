package test;

import static LymphV.v.*;

import java.util.*;

import LymphV.IterableComp;
public class J205_testPrint
{

	public static void main(String[] args)
	{
		int[] a = {1,2,3};
		print(a);
		Integer[] b = {1,2,3};
		print(b);
		print("dfdf");
		print(null);
		print(null,null);
		System.out.println("" + null);
		print(Arrays.deepToString(new int[][] {a,{1,2,3}}));
		print(Arrays.deepToString(b));
		print(new int[][] {a,{1,2,3}});
		f(b);
		f((Object) b);
		List<List<Long>> l = Arrays.asList
		(
			Arrays.asList(1l, 2l, 3l, -1l),
			Arrays.asList(0l, 2l, 7l, 4l)
		);
		l.sort(new IterableComp<Long>());
		print(l);
		l.sort(new IterableComp<Long>().reversed());
		print(l);
		
		
		l.get(0).sort(getComparator(1l));
		print(l);
		l.get(0).sort(getComparator(1l).reversed());
		print(l);
		
		String s = " dkfjdf ";
		s.trim();
		print(s);
		
		Map<String,Integer> mp = new HashMap<String,Integer> ();
		mp.put("a", 1);
		print(mp);
		mp.put("a", 2);
		print(mp);
		List<Long> list = new ArrayList<Long>();
		list.add(1l);
		list.add(2l);
		
		print(list.size());
		print(list);
		list.remove(list.size() - 1);
		print(list);
		
		
		
		
//		List<Integer> l = new ArrayList<Integer>();
	}

	public static void f (Object...objects)
	{
		print("a");
	}
	
	public static void f (Object obj)
	{
		print("b");
	}
}
