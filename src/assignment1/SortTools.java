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

import java.util.Arrays;

/**
 * This is the SortTools class for assignment 1
 *
 * @author Eric
 */
public class SortTools {
    /**
     * This method tests to see if the given array is sorted.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @return true if array is sorted
     */
    public static boolean isSorted(int[] x, int n) {
        if (x == null)
            return false;
        if (n <= 0) {
            return false;
        }
        if (n > x.length) {
            return false;
        }
        if (x.length == 0) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            if (x[i - 1] > x[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds an element in array
     * @param x
     * @param n
     * @param v
     * @return
     */
    public static int find(int[] x, int n, int v) {
        if (x == null) {
            return -1;
        }
        int len = n;
        if (x.length < len) {
            len = x.length;
        }
        if (len <= 0) {
            return -1;
        }

        int upperBound = len - 1;
        int current = (upperBound + (upperBound % 2)) / 2;
        while (upperBound - current > 1) {
            if (x[current] == v) {
                return current;
            }
            if (x[current] > v) {
                // should search in lower half
                upperBound = current;
                current = (upperBound + (upperBound % 2)) / 2;
            } else {
                // should search in upper half
                int boundSum = upperBound + current;
                current = (boundSum + (boundSum % 2)) / 2;
            }
        }
        if (x[current] == v) {
            return current;
        }
        if (x[upperBound] == v) {
            return upperBound;
        }
        return -1;
    }

    /**
     * Insert an element into an array
     * @param x is the array.
     * @param n is the number of elements to be checked.
     * @param v is the value to be inserted.
     * @return
     */
    public static int[] insertGeneral(int[] x, int n, int v) {
        if (x == null)
            return new int[]{v};
        if (x.length < n) {
            n = x.length;
        }
        if (n == 0) {
            return new int[]{v};
        }

        int[] newArray = new int[n + 1];

        boolean shouldInsert = true;
        int newIndex = 0;
        boolean inserted = false;
        for (int i = 0; i < n; i++) {
            if (x[i] > v) {
                if (shouldInsert && !inserted) {
                    newArray[newIndex] = v;
                    newIndex++;
                    newArray[newIndex] = x[i];
                    inserted = true;
                } else {
                    newArray[newIndex] = x[i];
                }
            } else if (x[i] == v) {
                shouldInsert = false;
                inserted = false;
                newArray[newIndex] = x[i];
            } else {
                newArray[newIndex] = x[i];
            }

            newIndex++;
        }


        if (inserted) {
            return newArray;
        } else {
            if (shouldInsert) {
                newArray[newIndex] = v;
                return newArray;
            } else {
                return Arrays.copyOf(newArray, newArray.length - 1);
            }


        }

    }

    /**
     * Inserts v into array for the first n elements.
     * @param x is the array to be inserted.
     * @param n is the number of elements to be inserted into.
     * @param v is the value to be inserted.
     * @return the length of the inserted array.
     */
    public static int insertInPlace(int[] x, int n, int v) {
        if (n == 0) {
            if (x[0] != v) {
                x[0] = v;
                return n + 1;
            } else {
                return n;
            }
        }

        boolean shouldInsert = true;
        int dashed = v;
        boolean pop = false;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                if (shouldInsert) {
                    if (x[i] == dashed && dashed == v) {
                        return n;
                    }

                    if (x[i] < dashed) {
                        x[i + 1] = dashed;
                    } else if (x[i] >= dashed) {
                        int temp = x[i];
                        x[i] = dashed;
                        x[i + 1] = temp;
                    }

                    return n + 1;
                } else {
                    return n;
                }
            }

            if (pop) {
                int temp = x[i];
                x[i] = dashed;
                dashed = temp;
            }

            if (x[i] > dashed) {
                int temp = x[i];
                x[i] = dashed;
                if (dashed == v) {
                    shouldInsert = true;
                }
                dashed = temp;
                pop = true;
            } else if (x[i] == dashed) {
                shouldInsert = false;
            }
        }
        return n + 1;
    }

    /**
     * Sorts the first n elements of an array in a non decreasing order.
     *
     * @param x is the array to be sorted.
     * @param n is the number of elements to be sorted.
     */
    public static void insertSort(int[] x, int n) {
        if (x == null) {
            return;
        }
        int len = n;
        if (x.length < len) {
            len = x.length;
        }
        if (len <= 0) {
            return;
        }

        boolean dirty = true;
        while (dirty) {
            dirty = false;
            for (int j = 0; j < len - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                    dirty = true;
                }
            }
        }
    }
}
