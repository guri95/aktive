package com.aktive.cas;

import java.util.Stack;

public class ControlExpression {
	/*
	 * Construct an expression tree from the given postOrder expression
	 */
	private TreeNode parent;

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode constructTree(String[] postfix) {
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

	void diplayPositionOfTreeNode(TreeNode root) {
		if (root == null)
			return;

		System.out.println("Position visual: {value, position}...");
		diplayPositionOfTreeNodeHelper(root);
		System.out.println();
	}

	private void diplayPositionOfTreeNodeHelper(TreeNode root) {
		if (root == null)
			return;

		diplayPositionOfTreeNodeHelper(root.left);
		diplayPositionOfTreeNodeHelper(root.right);
		System.out.print("{" + root.data + ", " + root.position + "}, ");

	}

	public void move(TreeNode root, int position) {
		if (position > root.position || position < 0) {
			System.err.println("Position range should be [0, " + root.position + "]\nInvalid position: " + position);
			return;
		}
		System.out.println("\nMoved Expression at position: " + position);

		if (root == null)
			return;

		getParentTreeNode(root, position);
		TreeNode leftTemp = parent.left;
		parent.left = parent.right;
		parent.right = leftTemp;

		System.out.println("parentPosition: " + parent.position + " leftChidPosition: " + parent.left.position
				+ " rightChildPosition: " + parent.right.position);
		inorderString(root);
		System.out.println();
	}

	private void getParentTreeNode(TreeNode root, int i) {
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

	public void invertTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print("\nEvaluated Expression: ");
		invertTreeHelper(root);
		inorderString(root);
	}

	private TreeNode invertTreeHelper(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = invertTreeHelper(root.left);
		TreeNode right = invertTreeHelper(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public boolean isOperator(String c) {
		return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
	}

	/*
	 * Display PostOrder expression for an expression tree
	 */
	public void postorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print("PostOrderTraversal Expression: ");
		postorderHelper(root);
		System.out.println("\n");
	}

	public void postorderHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		postorderHelper(root.left);
		postorderHelper(root.right);
		System.out.print(root.data);
	}

	/*
	 * Print the InOrder expression for an expression tree
	 */
	public void inorderString(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print("InOrderTraversal Expression: ");

		inorderHelper(root);
		System.out.println();
	}

	public void inorderHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		if (isOperator(root.data)) {
			System.out.print("(");
		}

		inorderHelper(root.right);
		System.out.print(root.data);
		inorderHelper(root.left);

		if (isOperator(root.data)) {
			System.out.print(")");
		}
	}
}
