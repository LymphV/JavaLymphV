package LymphV;

import java.util.Objects;

public class Pair<First, Second>
{
	public First first;
	public Second second;
	
	public Pair (First first, Second second)
	{
		this.first = first;
		this.second = second;
	}

	public int hashCode()
	{
		return Objects.hash(first, second);
	}

	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Pair<?,?> other = (Pair<?,?>) obj;
		return Objects.equals(first, other.first) && Objects.equals(second, other.second);
	}

	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}
}
