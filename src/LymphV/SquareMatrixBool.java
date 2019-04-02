package LymphV;

import java.util.Arrays;

public class SquareMatrixBool
{
	protected boolean[][] matrix;
	protected int n;
	
	public SquareMatrixBool (int n)
	{
		this.n = n;
		matrix= new boolean[n][n];
	}
	
	public SquareMatrixBool ()
	{
		n = 0;
		matrix = null;
	}
	
	public SquareMatrixBool (SquareMatrixBool other)
	{
		n = other.n;
		matrix = new boolean[n][n];
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
			matrix[i][j] = other.matrix[i][j];
	}
	
	public boolean[][] matrix ()
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
		SquareMatrixBool other = (SquareMatrixBool) obj;
		if (n != other.n) return false;
		if (!Arrays.deepEquals(matrix, other.matrix)) return false;
		return true;
	}
	
	public SquareMatrixBool mul(SquareMatrixBool other)
	{
		if (n != other.n) return new SquareMatrixBool();
		SquareMatrixBool res = new SquareMatrixBool(n);
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
		{
			boolean x = res.matrix[i][j];
			for (int k = 0; k < n; ++k)
				x |= matrix[i][k] && other.matrix[k][j];
			res.matrix[i][j] = x;
		}
		return res;
	}
	
	public SquareMatrixBool transitiveClosure ()
	{
		SquareMatrixBool res = new SquareMatrixBool(this);
		for (int i = 1; i < n; i <<= 1)
		{
			SquareMatrixBool sm = res.mul(res);
			if (sm.equals(res)) return sm;
			res = sm;
		}
		return res;
	}
	
	public int[][] cluster ()
	{
		UFSet ufset = new UFSet(n);
		for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
			if (matrix[i][j]) ufset.unite(i, j);
		return ufset.cluster();
	}

	public String toString()
	{
		String res = "";
		for (boolean[] x : matrix)
		{
			for (boolean y : x)
				res += "" + (y ? 1 : 0) + " ";
			res += "\n";
		}
			
		return res;
	}
}
