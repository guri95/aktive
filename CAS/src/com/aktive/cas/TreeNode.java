package com.aktive.cas;

/*Data structure to store a binary tree node
*/
public class TreeNode{

	String data;
	TreeNode left, right;
	int position;

	TreeNode(String data, int position) {
		this.data = data;
		this.left = this.right = null;
		this.position = position;
	}

	TreeNode(String data, TreeNode left, TreeNode right, int position) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.position = position;
	}
}
