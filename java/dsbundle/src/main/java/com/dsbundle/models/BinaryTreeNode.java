package com.dsbundle.models;

import com.dsbundle.util.iterators.InOrderIterator;
import com.dsbundle.util.iterators.LevelOrderIterator;
import com.dsbundle.util.iterators.PostOrderIterator;
import com.dsbundle.util.iterators.PreOrderIterator;

import java.util.Iterator;

/**
 * Model for BinaryTree Node containing left and right child.
 *
 */
public class BinaryTreeNode<T extends Comparable<T>> extends BaseNode<T> {

	private BinaryTreeNode<T> left, right;

	public BinaryTreeNode(T value) {
		super(value);
	}

	/**
	 * @return the left
	 */
	@Override
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left left
	 */
	public void setLeft(final BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	@Override
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right right
	 */
	public void setRight(final BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public Iterator<BinaryTreeNode<T>> getInOrderIterator() {
		return new InOrderIterator<BinaryTreeNode<T>>(this);
	}

	@Override
	public Iterator<BinaryTreeNode<T>> getPreOrderIterator() {
		return new PreOrderIterator<BinaryTreeNode<T>>(this);
	}

	@Override
	public Iterator<BinaryTreeNode<T>> getPostOrderIterator() {
		return new PostOrderIterator<BinaryTreeNode<T>>(this);
	}

	@Override
	public Iterator<BinaryTreeNode<T>> getLevelOrderIterator() {
		return new LevelOrderIterator<BinaryTreeNode<T>>(this);
	}

	@Override
	public String toString() {
		return super.toString() + "BinaryTreeNode [left=" + left + ", right=" + right + "]";
	}
}