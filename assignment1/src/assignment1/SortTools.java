// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Xiaoyong Liang
 * XL5432
 * 16445
 * Fall 2016
 */
package assignment1;

public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		if(x == null) return false;
		int len = n;
		if(x.length < len)
		{
			len = x.length;
		}
		if(len <= 1)
		{
			return true;
		}
		for (int i = 1; i < len; i++){
			if(x[i-1] > x[i])
			{
				return false;
			}
		}
		return true;
	}

	public static int find(int[]x, int n, int v){
		return 1;
	}

	public static int[] insertGeneral(int[]x, int n, int v) {
		return null;
	}
  
	public static int insertInPlace(int[] x, int n, int v) {
		return 1;
	}

	public static void insertSort(int[] x, int n) {

	}

}
