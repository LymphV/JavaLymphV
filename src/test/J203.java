package test;

import LymphV.*;
import java.util.*;

public class J203
{

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(args));
		double[][] data = { ///10 * 11
		        {276,324,159,413,292,258,311,303,175,243,320},
		        {251,287,349,344,310,454,285,451,402,307,470},
		        {192,433,290,563,479,502,221,220,320,411,232},
		        {246,232,243,281,267,310,273,315,285,327,352},
		        {291,311,502,388,330,410,352,267,603,290,292},
		        {466,158,224,178,164,203,502,320,240,278,350},
		        {258,327,432,401,361,381,301,413,402,199,421},
		        {453,365,357,452,384,420,482,228,360,316,252},
		        {158,271,410,308,283,410,201,179,430,342,185},
		        {324,406,235,520,442,520,358,343,251,282,371}
		    };


		    double[] x_avg = new double[11];
		    // compute x_avg
		    for (int i : v.range(11))
		    {
		        double sum = 0;
		        for (int j : v.range(10)) sum += data[j][i];
		        x_avg[i] = sum / 10;
		    }

		    SquareMatrixDouble r = new SquareMatrixDouble(11);
		    // compute rij
		    for (int i : v.range(11)) for (int j : v.range(11))
		    {
		        double sum_up = 0;
		        for (int k : v.range(10))
		            sum_up += Math.abs(data[k][i] - x_avg[i]) * Math.abs(data[k][j] - x_avg[j]);
		        double sum_down = -1;
		        double sum1 = 0;
		        double sum2 = 0;
		        for (int k : v.range(10))
		        {
		            sum1 += Math.pow(data[k][i] - x_avg[i], 2);
		            sum2 += Math.pow(data[k][j] - x_avg[j], 2);
		        }
		        sum_down = Math.pow(sum1, 0.5) * Math.pow(sum2, 0.5);
		        r.matrix()[i][j] = sum_up / sum_down;
		    }

		    SquareMatrixDouble sm = new SquareMatrixDouble(r);
		    System.out.println("模糊相似矩阵：");
		    System.out.println(sm);
		    System.out.println("模糊等价矩阵：");
		    System.out.println(sm = sm.transitiveClosure());

		    Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		    
		    for (int i : v.range(11)) for (int j : v.range(11))
		    	mp.put((int)(sm.matrix()[i][j]*1e5), 1);
		    
		    Stack<Double> sta = new Stack<Double>();
		    for(int x : mp.keySet()) sta.push(1.0 * x * 1e-5);

		    while (!sta.empty())
		    {
		        double x = sta.peek(); sta.pop();
		        SquareMatrixBool smt = sm.cutSet(x);
		        System.out.println("" + x + "的截集：");
		        System.out.println(smt);

		        int[][] vvi = r.cutSet(x).transitiveClosure().cluster();
		        System.out.println("此时聚类为：");
		        for (int[] v : vvi)
		        	System.out.println(Arrays.toString(v));
		        System.out.println();
		    }
	}

}
