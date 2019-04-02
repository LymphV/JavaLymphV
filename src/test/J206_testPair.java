package test;

import LymphV.Pair;
import static LymphV.v.*;

public class J206_testPair
{

	public static void main(String[] args)
	{
		Pair<Integer, String> p = pair(1,"sss");
		print(p);
		print(p.hashCode());
		print(p.equals(pair(1,"sss")));
		print(p.equals(pair(1,new String("sss"))));
	}

}
