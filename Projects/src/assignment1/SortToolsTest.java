package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortToolsTest {

	@Test
	public void testIsSorted() {
		int[] first = { 1, 2, 3 };
		assertTrue(SortTools.isSorted(first, 3));

		int[] second = { 0, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 100, 2200 };
		assertTrue(SortTools.isSorted(second, second.length));

		int[] third = { 1, 2, 2, 3, 3, 4, 45, 56, 2, 3, 4, 5, 3, 1 };
		assertTrue(SortTools.isSorted(third, 8));

		int[] fourth = { 1, 2, 2, 3, 3, 4, 45, 56, 2, 3, 4, 5, 3, 1 };
		assertFalse(SortTools.isSorted(fourth, 9));

		int[] fifth = { 1 };
		assertTrue(SortTools.isSorted(fifth, 3));

		int[] sixth = { 5, 4, 3, 2, 1 };
		assertFalse(SortTools.isSorted(sixth, 3));

		int[] seventh = { 1, 1, 1, 1, 1, 1, 1, 1 };
		assertTrue(SortTools.isSorted(seventh, seventh.length));

		int[] eighth = { 0 };
		assertTrue(SortTools.isSorted(eighth, 1));
	}

	@Test // (timeout = 2000)
	public void testFind() {
		int[] first = { 1, 2, 3 };
		assertEquals(2, SortTools.find(first, 3, 3));

		int[] second = { 0, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 100, 2200 };
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

		int[] fifth = { 1, 1, 1 };
		int fifthIndex1 = SortTools.find(fifth, fifth.length, 1);
		assertTrue(fifthIndex1 >= 0 && fifthIndex1 <= 2);

		int[] sixth = { -53 };
		assertEquals(0, SortTools.find(sixth, 4, -53));
		assertEquals(0, SortTools.find(sixth, 1, -53));
		assertEquals(-1, SortTools.find(sixth, 0, -53));
	}

	@Test
	public void testInsertGeneral() {
		int[] a1 = { 1, 2, 3 };
		int[] r1 = SortTools.insertGeneral(a1, 3, 2);
		assertArrayEquals(a1, r1);

		int[] r2 = SortTools.insertGeneral(a1, 3, 4);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, r2);

		int[] r3 = SortTools.insertGeneral(a1, 3, 0);
		assertArrayEquals(new int[] { 0, 1, 2, 3 }, r3);

		int[] r4 = SortTools.insertGeneral(a1, 2, 99);
		assertArrayEquals(new int[] { 1, 2, 99 }, r4);

		int[] r5 = SortTools.insertGeneral(a1, 2, -33);
		assertArrayEquals(new int[] { -33, 1, 2 }, r5);
	}

	@Test
	public void testInsertInPlace() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSort() {
		int[] a1 = { 1, 2, 3 };
		SortTools.insertSort(a1, 3);
		assertArrayEquals(new int[] { 1, 2, 3 }, a1);

		int[] a2 = { 2, 2, 3 };
		SortTools.insertSort(a2, 3);
		assertArrayEquals(new int[] { 2, 2, 3 }, a2);

		int[] a3 = { 3, 2, 1 };
		SortTools.insertSort(a3, 3);
		assertArrayEquals(new int[] { 1, 2, 3 }, a3);

		int[] a4 = { 5, 4, 3, 2, 1 };
		SortTools.insertSort(a4, 4);
		assertArrayEquals(new int[] { 2, 3, 4, 5, 1 }, a4);

		int[] a5 = {};
		SortTools.insertSort(a5, 4);
		assertArrayEquals(new int[] {}, a5);

		int[] a6 = { 3 };
		SortTools.insertSort(a6, 4);
		assertArrayEquals(new int[] { 3 }, a6);

		int[] a7 = { -122, -133, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80 };
		SortTools.insertSort(a7, 11);
		assertArrayEquals(new int[] { -233, -133, -122, -122, -122, -15, 50, 53, 73, 99, 299, 80 }, a7);
		
		int[] a8 = { -122, -133, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80 };
		SortTools.insertSort(a8, 3);
		assertArrayEquals(new int[] { -133, -122, 99, -122, -122, 73, 53, -15, 299, -233, 50, 80 }, a8);
	}

}
