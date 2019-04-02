package LymphV;

public class SquareMatrixDouble
{
	protected static final double EPS = 1e-8;
	protected double[][] matrix;
	protected int n;
	
	public SquareMatrixDouble (int n)
	{
		this.n = n;
		matrix= new double[n][n];
	}
	
	public SquareMatrixDouble ()
	{
		n = 0;
		matrix = null;
	}
	
	public SquareMatrixDouble (SquareMatrixDouble other)
	{
		n = other.n;
		matrix = new double[n][n];
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
			matrix[i][j] = other.matrix[i][j];
	}
		
	public double[][] matrix ()
	{
		return matrix;
	}
	
	public int size ()
	{
		return n;
	}
	
	public boolean valid ()
	{
		return n > 0;
	}

	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		SquareMatrixDouble other = (SquareMatrixDouble) obj;
		if (n != other.n) return false;
		
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
			if (Math.abs(matrix[i][j] - other.matrix[i][j]) > EPS)
				return false;
		return true;
	}
	
	public SquareMatrixDouble mul(SquareMatrixDouble other)
	{
		if (n != other.n) return new SquareMatrixDouble();
		SquareMatrixDouble res = new SquareMatrixDouble(n);
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
		{
			double x = res.matrix[i][j];
			for (int k = 0; k < n; ++k)
				x = Math.max(x, Math.min(matrix[i][k], other.matrix[k][j]));
			res.matrix[i][j] = x;
		}
		return res;
	}
	
	public SquareMatrixDouble transitiveClosure ()
	{
		SquareMatrixDouble res = new SquareMatrixDouble(this);
		for (int i = 1; i < n; i <<= 1)
		{
			SquareMatrixDouble sm = res.mul(res);
			if (sm.equals(res)) return sm;
			res = sm;
		}
		return res;
	}
	
	public SquareMatrixBool cutSet (double lambda)
	{
	    SquareMatrixBool res = new SquareMatrixBool(n);
	    for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
	        res.matrix[i][j] = matrix[i][j] > lambda - EPS ? true : false;
	    return res;
	}

	public String toString()
	{
		String res = "";
		for (double[] x : matrix)
		{
			for (double y : x)
				res += "" + String.format("%.5f", y) + " ";
			res += "\n";
		}
			
		return res;
	}
}
