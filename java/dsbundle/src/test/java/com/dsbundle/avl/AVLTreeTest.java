package com.dsbundle.avl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dsbundle.binarytree.Fruit;
import com.dsbundle.models.AVLNode;
import com.dsbundle.models.BinaryTreeNode;

public class AVLTreeTest {
	private static AVLTree<Integer> avlTree;

	@BeforeClass
	public static void createTree() {
		avlTree = new AVLTree<Integer>();
		/*
		 * The constructed AVL Tree would be 9 / \ 1 10 / \ \ 0 5 11 / / \ -1 2 6
		 */
		avlTree.insert(9);
		avlTree.insert(5);
		avlTree.insert(10);
		avlTree.insert(0);
		avlTree.insert(6);
		avlTree.insert(11);
		avlTree.insert(-1);
		avlTree.insert(1);
		avlTree.insert(2);
	}

	@Test
	public void insert() {
		avlTree.insert(20);
		List<Integer> values = avlTree.preOrderTraversal(avlTree.getRoot());
		Assert.assertEquals(values, Arrays.asList(new Integer[] { 9, 1, 0, -1, 5, 2, 6, 11, 10, 20 }));
	}

	@Test
	public void delete() {
		avlTree.deleteNode(avlTree.getRoot(), new AVLNode<Integer>(20));
		List<Integer> values = avlTree.preOrderTraversal(avlTree.getRoot());
		Assert.assertEquals(values, Arrays.asList(new Integer[] { 9, 1, 0, -1, 5, 2, 6, 10, 11 }));
	}

	@Test
	public void search() {
		avlTree.insert(20);
		List<Integer> values = avlTree.preOrderTraversal(avlTree.getRoot());
		avlTree.insertAll(Arrays.asList(new Integer[] { 9, 1, 0, -1, 5, 2, 6, 11, 10, 20 }));
		System.out.println(avlTree.getRoot());
		AVLNode<Integer> result = avlTree.search(new AVLNode<Integer>(1));
		Assert.assertNotNull(result);
		result = avlTree.search(new AVLNode<Integer>(111));
		Assert.assertNull(result);
	}

	@Test
	public void searchTest() {
		AVLTree<Fruit> tree = new AVLTree<Fruit>();
		tree.setRoot(new AVLNode<Fruit>(new Fruit("Apple", 12F)));
		tree.getRoot().setLeft(new AVLNode<>(new Fruit("Mango", 10.5F)));
		tree.getRoot().setRight(new AVLNode<>(new Fruit("Banana", 20F)));
		tree.getRoot().getLeft().setLeft(new AVLNode<>(new Fruit("Orange", 7F)));
		AVLNode<Fruit> test = tree.search(new AVLNode<Fruit>(new Fruit("Orange", 7F)));
		Assert.assertEquals("Orange", test.getValue().getName());
		test = tree.search(new AVLNode<Fruit>(new Fruit("Mango", 10.5F)));
		Assert.assertEquals("Mango", test.getValue().getName());
		test = tree.search(new AVLNode<Fruit>(new Fruit("Apple", 9F)));
		Assert.assertNull(test);
	}

}
