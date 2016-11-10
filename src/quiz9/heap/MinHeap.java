/* 
 * EE422C Quiz 9 submission by
 * Xiaoyong Liang
 * Wed 3pm
 * XL5423
 */
package quiz9.heap;

public class MinHeap {
	int size;
	int[] queue = new int[100];// we assume the heap will have no more
								// than 100 elements.

	/**
	 * Inserts the specified element into this MinHeap.
	 */
	public void add(int value) {
		assert value != 0;

		queue[size] = value;
		heapifyUp(size++);
	}

	private void heapifyUp(int i) {
		int parent = (i - 1) / 2;
		while (i > 0 && queue[i] < queue[parent]) {
			int temp = queue[parent];
			queue[parent] = queue[i];
			queue[i] = temp;
			i = parent;
			parent = (i - 1) / 2;
		}
	}

	public void heapSort(int[] arr) {
		for (int i = 0; i < arr.length; i ++){
			if(i != 0) {
				int index = i;
				while (arr[index] < arr[(index - 1) /2] && index > 0){
					int temp = arr[index];
					arr[index] = arr[(index-1)/2];
					arr[(index - 1)/2] = temp;
					index = (index -1) /2;
				}
			}
		}
	}

	public void remove(int o) {
		// TODO you are not required to implement this method using iteration.
		// But you will get 5 points bonus if you implement it successfully.
	}
}
