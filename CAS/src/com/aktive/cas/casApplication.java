package com.aktive.cas;

import java.util.Stack;

public class casApplication {
	static TreeNode parent;

	public static void main(String[] args) {
		// write your expression in posTTraversal way
		// String[] postfix = {"2a","b","+","c","d","e","+","*","*" };

		String[] postfix = { "2a", "b", "+", "c", "d", "e", "+", "-", "-" };
		TreeNode root = construct(postfix);

		System.out.print("PostOrderTraversal Expression: ");
		postorder(root);
		System.out.println();
		diplayPositionOfTreeNode(root);
		System.out.print("\nInOrderTraversal Expression: ");
		inorder(root);

		System.out.print("\nEvaluated Expression: ");
		invertTree(root);
		inorder(root);

		System.out.println("\nMoved Expression: ");
		
		move(root, 6);
		move(root, 2);		
	}

	/*
	 * Construct an expression tree from the given postOrder expression
	 */
	public static TreeNode construct(String[] postfix) {
		if (postfix == null || postfix.length == 0) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		int count = 0;
		for (String c : postfix) {

			if (isOperator(c)) {
				TreeNode firsNode = s.pop();
				TreeNode secondNode = s.pop();

				TreeNode node = new TreeNode(c, secondNode, firsNode, count);

				s.add(node);
			} else {
				s.add(new TreeNode(c, count));
			}
			count++;
		}

		return s.peek();
	}
	
	private static void diplayPositionOfTreeNode(TreeNode root) {
		if (root == null)
			return;
		
		System.out.println("Position visual: {value, position}...");
		diplayPositionOfTreeNodeHelper(root);
	}
	private static void diplayPositionOfTreeNodeHelper(TreeNode root) {
		if (root == null)
			return;

		diplayPositionOfTreeNodeHelper(root.left);
		diplayPositionOfTreeNodeHelper(root.right);
		System.out.print("{" +root.data + ", "+root.position + "}, ");

	}

	private static void move(TreeNode root, int position) {
		if (root == null)
			return;

		getParentTreeNode(root, position);
		TreeNode leftTemp = parent.left;
		parent.left = parent.right;
		parent.right = leftTemp;
		
		System.out.println("parentPosition: " + parent.position+" leftNodePosition: "+parent.left.position+ " rightNodePosition: "+parent.right.position);
		inorder(root);System.out.println();
	}

	private static void getParentTreeNode(TreeNode root, int i) {
		if (root == null)
			return;

		if (root.left != null && root.left.position == i) {
			parent = root;
			return;
		}

		if (root.right != null && root.right.position == i) {
			parent = root;
			return;
		}
		getParentTreeNode(root.left, i);
		getParentTreeNode(root.right, i);
	}
	/*
	 * Invert the Tree
	 */
	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public static boolean isOperator(String c) {
		return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
	}

	/*
	 * Display PostOrder expression for an expression tree
	 */
	public static void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data);
	}

	/*
	 * Print the InOrder expression for an expression tree
	 */
	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (isOperator(root.data)) {
			System.out.print("(");
		}

		inorder(root.right);
		System.out.print(root.data);
		inorder(root.left);

		if (isOperator(root.data)) {
			System.out.print(")");
		}
	}
}