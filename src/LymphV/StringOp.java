package LymphV;

import static LymphV.v.range;

import java.util.Arrays;

public class StringOp
{
	/**********************
	 * python.join
	 */
	public static String join (String s, Object[] objs)
	{
		StringBuilder res = new StringBuilder();
		for (int i : range(objs.length))
		{
			if (i > 0) res.append(s);
			res.append(objectToString(objs[i]));
		}
		return res.toString(); 
	}
	
	/**********************
	 * python.join
	 */
	public static String join (String s, Iterable<?> iterable)
	{
		StringBuilder res = new StringBuilder();
		
		int i = 0;
		for (Object obj : iterable)
		{
			if (i++ > 0) res.append(s);
			res.append(objectToString(obj));
		}
		
		return res.toString();
	}
	
	/**********************
	 * python.join
	 */
	public static String join (Object[] objs, String s) {return join(s,objs);}
	
	/**********************
	 * python.join
	 */
	public static String join (Iterable<?> iterable, String s) {return join(s,iterable);}
	
	private static Class<?> classInt = new int[]{}.getClass();
	private static Class<?> classLong = new long[]{}.getClass();
	private static Class<?> classDouble = new double[]{}.getClass();
	private static Class<?> classFloat = new float[]{}.getClass();
	private static Class<?> classBool = new boolean[]{}.getClass();
	private static Class<?> classByte = new byte[]{}.getClass();
	private static Class<?> classChar = new char[]{}.getClass();
	private static Class<?> classShort = new short[]{}.getClass();
	
	/******************
	 * object to string
	 */
	private static String objectToString (Object object)
	{
		if (object == null) return "null";
		Class<?> c = object.getClass();
		if (c == classInt) return Arrays.toString((int[])object);
		if (c == classLong) return Arrays.toString((long[])object);
		if (c == classDouble) return Arrays.toString((double[])object);
		if (c == classFloat) return Arrays.toString((float[])object);
		if (c == classBool) return Arrays.toString((boolean[])object);
		if (c == classByte) return Arrays.toString((byte[])object);
		if (c == classChar) return Arrays.toString((char[])object);
		if (c == classShort) return Arrays.toString((short[])object);
		if (c.isArray()) return Arrays.deepToString((Object[])object);
		
		return object.toString();
	}
}
