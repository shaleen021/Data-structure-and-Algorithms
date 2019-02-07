package practice.tree;

class TreeNode {
	char data;
	TreeNode left, right;

	TreeNode(char item) {
		data = item;
		left = right = null;
	}
}

public class TreeFromPreAndInOrderTraversal {

	TreeNode root;
	int preIndex = 0;

	void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	int search(char arr[], int strt, int end, char value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	TreeNode buildTree(char in[], char pre[], int inStrt, int inEnd) {
		if (inStrt > inEnd) {
			return null;
		}

		TreeNode tNode = new TreeNode(pre[preIndex++]);

		if (inStrt == inEnd) {
			return tNode;
		}
		
		int index = search(in, inStrt, inEnd, tNode.data);
		
		tNode.left = buildTree(in, pre, inStrt, index-1);
		tNode.right = buildTree(in, pre, index+1, inEnd);

		return tNode;
	}
	
	 static int findMinimumDepth(TreeNode node){
		if(node == null)
			return 0;
		if(node.left == null && node.right == null){
			return 1;
		}
		
		if(node.left == null){
			return findMinimumDepth(node.right) + 1;
		}
		
		if(node.right == null) {
			return findMinimumDepth(node.left) + 1;
		}
		
		return Math.min(findMinimumDepth(node.left), findMinimumDepth(node.right)) + 1;
	}

	public static void main(String args[]) {
		TreeFromPreAndInOrderTraversal tree = new TreeFromPreAndInOrderTraversal();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		TreeNode root = tree.buildTree(in, pre, 0, len - 1);

		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
		
		System.out.println("Minimum height of a tree " + findMinimumDepth(root));
	}
}
