package test;

import java.util.Arrays;

import static LymphV.StringOp.*;

public class J204_testStringOp
{

	public static void main(String[] args)
	{
		String[] ss = {"12", "3", "54"};
		System.out.println(join("",ss));
		System.out.println(join(" ",ss));
		System.out.println(join(" ", Arrays.asList(ss)));
	}

}
