package quiz2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eric on 9/14/16.
 */
public class SelectionSortTest {
    @Test
    public void test1(){
        int[]x = {0};
        SelectionSort.sort(x);
        assertArrayEquals(new int[]{0}, x);
    }

    @Test
    public void test2(){
        int[] testSet = {0, 1,2,3};
        SelectionSort.sort(testSet);
        assertArrayEquals(new int[] {0,1,2,3}, testSet);
    }

    @Test
    public void test3(){
        int[] testSet = {5,6,3,4,2,1};
        SelectionSort.sort(testSet);
        assertArrayEquals(new int[] {1,2,3,4,5,6}, testSet);
    }

    @Test
    public void test4(){
        int[] testSet = {5,6,3,4,2,1};
        SelectionSort.sort(testSet);
        assertArrayEquals(new int[] {1,2,3,4,5,6}, testSet);
    }
}