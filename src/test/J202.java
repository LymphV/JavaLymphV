package test;

import java.util.*;

import LymphV.*;

import java.util.stream.Collectors;

public class J202
{
	public static void main(String[] args)
	{
		Integer[] aN = {1,2,3};
		int[] an = {1,2,3};
		
		System.out.println(new map<Integer, String>(aN){
			public String f (Integer n) {return n.toString();} 
		});
		
		HashSet<Integer> l =  new HashSet<Integer>();
		
		l.addAll(new map<Integer, Integer>(aN){
			public Integer f (Integer n) {return n;} 
		});
		
		System.out.println(Collectors.toList());
		System.out.println(l);
	}
}