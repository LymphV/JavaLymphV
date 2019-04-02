package test;

import static LymphV.Sum.*;
import java.util.ArrayList;
import java.util.List;

import LymphV.*;

public class J201 
{
	public static void main(String[] args) 
	{
		System.out.println("hello world");
        int[] a = new int[]{1,2,3,4,5};

        System.out.println(sum(a));

        List<Integer> l = new ArrayList<Integer>();
        for (int x : new int[]{1,2,3,4}) l.add(x);
        System.out.println(sum(l));
                
        System.out.println(sum(new double[] {1,2,3,4}));
        
        System.out.println(new range(10));
        
        for (int x : new range(10,0,-1)) System.out.println(x);
        for (int x : new range(10)) System.out.println(x);
	}
}
