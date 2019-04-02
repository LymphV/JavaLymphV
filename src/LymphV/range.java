package LymphV;

import java.util.Iterator;

public class range implements Iterable<Integer>, Iterator<Integer>
{
	private int start;
	private int stop;
	private int step;
	
	private void init (int start, int stop, int step)
	{
		assert step != 0 : "step must not be zero";
		this.start = start;
		this.stop = stop;
		this.step = step;
	}
	
	public range (int... args)
	{
		switch (args.length)
		{
		case 1:
			init(0,args[0],1);
			break;
		case 2:
			init(args[0],args[1],1);
			break;
		case 3:
			init(args[0],args[1],args[2]);
			break;
		default:
			assert false;
		}
	}
	
	public range(range r)
	{
		this(r.start,r.stop,r.step);
	}
	
	public Iterator<Integer> iterator() 
	{
		return new range(this);
	}
	
	public Integer next ()
	{
		int res = start;
		start += step;
		return res;
	}
	
	public boolean hasNext ()
	{
		return step > 0 ? start < stop : start > stop;
	}

	public String toString() {
		return "range(" + start + ", " + stop + (step == 1 ? "" : ", " + step) + ")";
	}
}
