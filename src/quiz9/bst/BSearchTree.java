/* 
 * EE422C Quiz 9 submission by
 * Xiaoyong Liang
 * Wed 3pm
 * XL5423
 */

package quiz9.bst;

/**
 * <p>
 * In this quiz, you are asked to implement Binary Search Tree using iteration.
 * Recursion is not allowed for any methods in this quiz.
 * </p>
 * <p>
 * Replacing TODO with your implementation for add and find methods. Don't
 * change any other things, including package, class, or method declaration.
 * Your submission should not have any generic warnings.
 * </p>
 * <p>
 * remove() is not required, yet if you can finish remove() methods, we give you
 * 3 extra points.
 * </p>
 * <p>
 * Include your name in file header. Zip your quiz9 folder and name it as quiz9_
 * <EID>.zip.
 * </p>
 */
public class BSearchTree<E extends Comparable<E>> {

	private BSTNode<E> root;

	public BSearchTree() {
		this.root = null;
	}

	/**
	 * BST insert method
	 * 
	 * @param root
	 *            BST root node
	 * @param value
	 *            the inserted value, allow duplicate values.
	 * @return BST root node
	 */
	public BSTNode<E> add(E value) {
		BSTNode<E> current = root;
		if (current == null){
			root = new BSTNode<E>(value, null, null);
			return root;
		}
		while (true){
			if(current.data.compareTo(value) > 0){
				if(current.left == null){
					BSTNode<E> newNode = new BSTNode<E>(value, null, null);
					current.left = newNode;
					break;
				}else{
					current = current.left;
				}

			} else {
				if(current.right == null){
					BSTNode<E> newNode = new BSTNode<E>(value, null, null);
					current.right = newNode;
					break;
				}else{
					current = current.right;
				}
			}
		}
		return root;
	}

	/**
	 * Find method in BST
	 * 
	 * @param root
	 *            BST root
	 * @param value
	 *            searched value
	 * @return true if the value is found in the BST
	 */
	public boolean find(E value) {
		BSTNode<E> current = root;
		if (current == null){
			return false;
		}
		while (true){
			if(current == null){
				return false;
			}
			if(current.data.equals(value)){
				return true;
			}

			if(current.data.compareTo(value) > 0){
				current = current.left;
			} else if (current.data.compareTo(value) < 0){
				current = current.right;
			}
		}
	}

	/**
	 * BST remove method
	 * 
	 * @param root
	 *            BST root node
	 * @param value
	 * @return tree root
	 */
	public BSTNode<E> remove(BSTNode<E> root, E value) {
		// TODO You don't need to implement this method. Yet you will get 3
		// extra points if you successfully implement it in iteration.
		return root;
	}

	public BSTNode<E> getRoot() {
		return root;
	}
	
	
}
