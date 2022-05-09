package com.aktive.cas;

public class casApplication {
	static ControlExpression controlExpression = new ControlExpression();

	public static void main(String[] args) {
		// write your expression in posTTraversal way
		// String[] postfix = {"2a","b","+","c","d","e","+","*","*" };

		String[] postfix = { "2a", "b", "+", "c", "d", "e", "+", "-", "-" };
		TreeNode root = controlExpression.constructTree(postfix);

		controlExpression.postorder(root);
		controlExpression.diplayPositionOfTreeNode(root);
		controlExpression.inorderString(root);

		controlExpression.invertTree(root);

		controlExpression.move(root, 6);
		controlExpression.move(root, 2);
		controlExpression.move(root, 7);
		controlExpression.move(root, 9);
		controlExpression.move(root, -1);

	}
}