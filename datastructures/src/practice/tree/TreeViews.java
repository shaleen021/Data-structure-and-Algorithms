package practice.tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class NodeEle {

	int data;
	int hd;
	NodeEle left, right;

	NodeEle(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Tree {
	NodeEle root;
	int maxLevel = 0;
	Map<Integer,Integer> rightViewMap = new LinkedHashMap<>();

	Tree(NodeEle node) {
		root = node;
	}
	
	String s = "Shaleen";
	

	public void bootomView() {

		int hd = 0;
		if (root == null) {
			return;
		}

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<NodeEle> queue = new LinkedList<NodeEle>();
		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			NodeEle temp = queue.remove();

			hd = temp.hd;
			map.put(hd, temp.data);

			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	public void topView() {
		int hd = 0;
		root.hd = 0;
		Queue<NodeEle> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Integer> map = new TreeMap<>();

		if (root == null) {
			return;
		}

		while (!queue.isEmpty()) {
			NodeEle temp = queue.remove();

			hd = temp.hd;
			if (map.get(hd) == null) {
				map.put(hd, temp.data);
			}

			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	public void leftViewUtil(NodeEle node, int level) {

		if (node == null)
			return;

		if (maxLevel < level) {
			System.out.print(node.data + " ");
			maxLevel = maxLevel + 1;
		}

		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);

	}

	public void leftView() {
		leftViewUtil(root, 1);
	}

	public void rightViewUtil(NodeEle node, int level) {

		if (node == null)
			return;

		rightViewMap.put(level, node.data);

		rightViewUtil(node.left, level + 1);
		rightViewUtil(node.right, level + 1);

	}

	public void rightView() {
		rightViewUtil(root, 1);
		for (Entry<Integer, Integer> entry : rightViewMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}
	
	public void traversalLNRUtil(NodeEle node) {
		if(node == null){
			return;
		}
		traversalLNRUtil(node.left);
		System.out.print(node.data + " ");
		traversalLNRUtil(node.right);
	}

	public void traversalLNR() {
		traversalLNRUtil(root);
	}
	
}

public class TreeViews {

	public static void main(String args[]) {
		NodeEle root = new NodeEle(20);
		root.left = new NodeEle(8);
		root.right = new NodeEle(22);
		root.left.left = new NodeEle(5);
		root.left.right = new NodeEle(3);
		root.right.left = new NodeEle(4);
		root.right.right = new NodeEle(25);
		root.left.right.left = new NodeEle(10);
		root.left.right.right = new NodeEle(14);
		Tree t = new Tree(root);
		System.out.println("Bottom View => ");
		t.bootomView();
		System.out.println();
		System.out.println("Top View => ");
		t.topView();
		System.out.println();
		System.out.println("Left View => ");
		t.leftView();
		System.out.println();
		System.out.println("Right View => ");
		t.rightView();
		System.out.println();
		System.out.println("LNR => ");
		t.traversalLNR();
	}

}
