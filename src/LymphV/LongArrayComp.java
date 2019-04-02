package LymphV;

import java.util.Comparator;

public class LongArrayComp implements Comparator<long[]>
{
	public int compare(long[] self, long[] value)
	{
		int i = 0;
		for (; i < self.length && i < value.length; ++i)
		{
			if (self[i] > value[i]) return 1;
			if (self[i] < value[i]) return -1;
		}
		if (i < self.length && i == value.length) return 1;
		if (i == self.length && i < value.length) return -1;
		return 0;
	}
}
