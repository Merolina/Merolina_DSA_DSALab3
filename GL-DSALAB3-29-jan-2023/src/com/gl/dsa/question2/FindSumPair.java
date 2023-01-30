package com.gl.dsa.question2;

import java.util.*;

public class FindSumPair {
	static class Node {
		int data;
		Node leftNode, rightNode;

	}

	static Node createNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.leftNode = null;
		newNode.rightNode = null;
		return newNode;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return createNode(key);
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	private boolean findPairUtil(Node root, int targetSum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findPairUtil(root.leftNode, targetSum, set))
			return true;

		int diff = targetSum - root.data;
		if (set.contains(diff)) {
			System.out.println("Pair is found (" + diff + "," + root.data + ")");
			return true;
		} else
			set.add(root.data);
		return findPairUtil(root.rightNode, targetSum, set);
	}

	public void findPairWithGivenSum(Node root, int targetSum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, targetSum, set))
			System.out.println("The Pairs do not exists.......");
	}

	public static void main(String[] args) {
		Node root = null;
		FindSumPair findPS = new FindSumPair();
		root = findPS.insert(root, 40);
		root = findPS.insert(root, 20);
		root = findPS.insert(root, 60);
		root = findPS.insert(root, 10);
		root = findPS.insert(root, 30);
		root = findPS.insert(root, 50);
		root = findPS.insert(root, 70);
		int targetSum = 130;
		System.out.println("The target sum is " + targetSum);
		findPS.findPairWithGivenSum(root, targetSum);

	}

}
