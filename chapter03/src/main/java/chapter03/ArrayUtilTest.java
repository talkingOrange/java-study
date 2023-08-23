package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {
	public static void main(String[] args) {
		int[] a = {10,20,30,40};
		// == int[] a = new int[]{10,20,30,40};
		
		double[] d = ArrayUtil.intToDouble(a);
		
		for(int i =0; i<d.length; i++) {
			System.out.println(d[i]);
		}
		
		System.out.println(Arrays.toString(d));
		
		//int[] b = doubleToInt(new double[] {10.0, 20.0, 30.0});
		
		//ArrayUtil.concat(new int[] {1,2,3}, new int[] {4,5,6});
		//System.out.println();
		
	}

	
}
