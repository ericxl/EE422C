package assignment1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortToolsTest {

    @Test
    public void testIsSorted() {
        int[] first = {1, 2, 3};
        assertTrue(SortTools.isSorted(first, 3));

        int[] second = {0, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 100, 2200};
        assertTrue(SortTools.isSorted(second, second.length));

        int[] third = {1, 2, 2, 3, 3, 4, 45, 56, 2, 3, 4, 5, 3, 1};
        assertTrue(SortTools.isSorted(third, 8));

        int[] fourth = {1, 2, 2, 3, 3, 4, 45, 56, 2, 3, 4, 5, 3, 1};
        assertFalse(SortTools.isSorted(fourth, 9));

        int[] fifth = {1};
        assertTrue(SortTools.isSorted(fifth, 3));

        int[] sixth = {5, 4, 3, 2, 1};
        assertFalse(SortTools.isSorted(sixth, 3));

        int[] seventh = {1, 1, 1, 1, 1, 1, 1, 1};
        assertTrue(SortTools.isSorted(seventh, seventh.length));

        int[] eighth = {0};
        assertTrue(SortTools.isSorted(eighth, 1));
    }

    @Test(timeout = 2000)
    public void testFind() {
        int[] first = {1, 2, 3};
        assertEquals(2, SortTools.find(first, 3, 3));

        int[] second = {0, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 100, 2200};
        int secondIndex1 = SortTools.find(second, second.length, 4);
        assertTrue(secondIndex1 >= 5 && secondIndex1 <= 10);

        int secondIndex2 = SortTools.find(second, second.length, 2);
        assertTrue(secondIndex2 >= 1 && secondIndex2 <= 2);

        assertEquals(-1, SortTools.find(second, 1000, -33));
        assertEquals(15, SortTools.find(second, 16, 100));
        assertEquals(-1, SortTools.find(second, 15, 100));
        assertEquals(-1, SortTools.find(second, 0, 0));
        assertEquals(0, SortTools.find(second, 1, 0));

        int[] third = {};
        assertEquals(-1, SortTools.find(third, -3, -33));

        int[] fourth = null;
        assertEquals(-1, SortTools.find(fourth, 3, -33));

        int[] fifth = {1, 1, 1};
        int fifthIndex1 = SortTools.find(fifth, fifth.length, 1);
        assertTrue(fifthIndex1 >= 0 && fifthIndex1 <= 2);

        int[] sixth = {-53};
        assertEquals(0, SortTools.find(sixth, 4, -53));
        assertEquals(0, SortTools.find(sixth, 1, -53));
        assertEquals(-1, SortTools.find(sixth, 0, -53));
    }

    @Test(timeout = 2000)
    public void testInsertGeneral() {
        int[] a1 = {1, 2, 3};

        int[] r2 = SortTools.insertGeneral(a1, 33, 3);
        assertArrayEquals(new int[]{1, 2, 3}, r2);

        int[] r3 = SortTools.insertGeneral(a1, 3, 0);
        assertArrayEquals(new int[]{0, 1, 2, 3}, r3);

        int[] r1 = SortTools.insertGeneral(a1, 3, 2);
        assertArrayEquals(a1, r1);

        int[] r4 = SortTools.insertGeneral(a1, 3, 99);
        assertArrayEquals(new int[]{1, 2, 3, 99}, r4);

        int[] r5 = SortTools.insertGeneral(a1, 2, -33);
        assertArrayEquals(new int[]{-33, 1, 2}, r5);

        int[] a2 = {-99, -80, -1, 0, 1, 9, 88, 100, 200};
        int[] r6 = SortTools.insertGeneral(a2, a2.length, 5);
        assertArrayEquals(new int[]{-99, -80, -1, 0, 1, 5, 9, 88, 100, 200}, r6);

        int[] r7 = SortTools.insertGeneral(a2, a2.length, -133);
        assertArrayEquals(new int[]{-133, -99, -80, -1, 0, 1,9, 88, 100, 200}, r7);

        int[] r8 = SortTools.insertGeneral(a2, a2.length, 233);
        assertArrayEquals(new int[]{-99, -80, -1, 0, 1,9, 88, 100, 200, 233}, r8);

        int[] r9 = SortTools.insertGeneral(a2, a2.length, 0);
        assertArrayEquals(new int[]{-99, -80, -1, 0, 1,9, 88, 100, 200}, r9);

        int[] r10 = SortTools.insertGeneral(a2, 3, -100);
        assertArrayEquals(new int[]{-100, -99, -80, -1}, r10);

        int[] r11 = SortTools.insertGeneral(a2, 3, 300);
        assertArrayEquals(new int[]{-99, -80, -1, 300}, r11);

        int[] r12 = SortTools.insertGeneral(a2, 3, 0);
        assertArrayEquals(new int[]{-99, -80, -1, 0}, r12);

        int[] a3 = {11,22,22,22, 33};
        int[] r13 = SortTools.insertGeneral(a3, 3, 11);
        assertArrayEquals(new int[]{11,22,22}, r13);

        int[] r14 = SortTools.insertGeneral(a3, 3, 7);
        assertArrayEquals(new int[]{7,11,22,22}, r14);

        int[] r15 = SortTools.insertGeneral(a3, 3, 44);
        assertArrayEquals(new int[]{11,22, 22,44}, r15);

        int[] r16 = SortTools.insertGeneral(a3, a3.length, 44);
        assertArrayEquals(new int[]{11,22, 22,22,33, 44}, r16);

        int[] r17 = SortTools.insertGeneral(a3, a3.length, 22);
        assertArrayEquals(new int[]{11,22, 22,22,33}, r17);

        int[] r18 = SortTools.insertGeneral(a3, 1, 22);
        assertArrayEquals(new int[]{11,22}, r18);

        int[] r19 = SortTools.insertGeneral(a3, 2, 22);
        assertArrayEquals(new int[]{11,22}, r19);
    }

    @Test(timeout = 2000)
    public void testInsertInPlace() {
        int[] a9 = {1, 1, 4, 4, 0};
        int r9 = SortTools.insertInPlace(a9, 4, 3);
        assertArrayEquals(new int[]{1, 1, 3, 4, 4}, a9);
        assertEquals(5, r9);

        int[] a1 = {1, 2, 4, 0};
        int r1 = SortTools.insertInPlace(a1, 3, 7);
        assertArrayEquals(new int[]{1, 2, 4, 7}, a1);
        assertEquals(4, r1);

        int[] a2 = {1, 2, 4, 0};
        int r2 = SortTools.insertInPlace(a2, 3, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4}, a2);
        assertEquals(4, r2);

        int[] a3 = {1, 2, 4, 0};
        int r3 = SortTools.insertInPlace(a3, 3, 4);
        assertArrayEquals(new int[]{1, 2, 4, 0}, a3);
        assertEquals(3, r3);

        int[] a4 = {1, 2, 4, 0};
        int r4 = SortTools.insertInPlace(a4, 3, 2);
        assertArrayEquals(new int[]{1, 2, 4, 0}, a4);
        assertEquals(3, r4);

        int[] a5 = {1, 2, 4, 0};
        int r5 = SortTools.insertInPlace(a5, 3, -7);
        assertArrayEquals(new int[]{-7, 1, 2, 4}, a5);
        assertEquals(4, r5);

        int[] a6 = {1, 2, 4, 0};
        int r6 = SortTools.insertInPlace(a6, 2, 3);
        assertArrayEquals(new int[]{ 1, 2, 3, 0}, a6);
        assertEquals(3, r6);

        int[] a7 = {-99, -80, -1, 0, 1, 9, 88, 100, 200};
        int r7 = SortTools.insertInPlace(a7, 7, 3);
        assertArrayEquals(new int[]{-99, -80, -1, 0, 1, 3, 9, 88, 200}, a7);
        assertEquals(8, r7);

        int[] a8 = {1, 1, 4, 4, 0};
        int r8 = SortTools.insertInPlace(a8, 4, 4);
        assertArrayEquals(new int[]{1, 1, 4, 4, 0}, a8);
        assertEquals(4, r8);

        int[] a10 = {3, 0};
        int r10 = SortTools.insertInPlace(a10, 1, 4);
        assertArrayEquals(new int[]{3, 4}, a10);
        assertEquals(2, r10);

        int[] a11 = {3};
        int r11 = SortTools.insertInPlace(a11, 0, 4);
        assertArrayEquals(new int[]{4}, a11);
        assertEquals(1, r11);

        int[] a12 = {3};
        int r12 = SortTools.insertInPlace(a12, 0, 3);
        assertArrayEquals(new int[]{3}, a12);
        assertEquals(0, r12);

        int[] a13 = {1,3,5,0};
        int r13 = SortTools.insertInPlace(a13, 3, 0);
        assertArrayEquals(new int[]{0,1,3,5}, a13);
        assertEquals(4, r13);
    }

    @Test(timeout = 2000)
    public void testInsertSort() {
        int[] a1 = {1, 2, 3};
        SortTools.insertSort(a1, 3);
        assertArrayEquals(new int[]{1, 2, 3}, a1);

        int[] a2 = {2, 2, 3};
        SortTools.insertSort(a2, 3);
        assertArrayEquals(new int[]{2, 2, 3}, a2);

        int[] a3 = {3, 2, 1};
        SortTools.insertSort(a3, 3);
        assertArrayEquals(new int[]{1, 2, 3}, a3);

        int[] a4 = {5, 4, 3, 2, 1};
        SortTools.insertSort(a4, 4);
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, a4);

        int[] a5 = {};
        SortTools.insertSort(a5, 4);
        assertArrayEquals(new int[]{}, a5);

        int[] a6 = {3};
        SortTools.insertSort(a6, 4);
        assertArrayEquals(new int[]{3}, a6);

        int[] a7 = {-122, -133, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80};
        SortTools.insertSort(a7, 11);
        assertArrayEquals(new int[]{-233, -133, -122, -122, -122, -15, 50, 53, 73, 99, 299, 80}, a7);

        int[] a8 = {-122, -133, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80};
        SortTools.insertSort(a8, 3);
        assertArrayEquals(new int[]{-133, -122, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80}, a8);
    }

}
