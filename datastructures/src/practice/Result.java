package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Result {

	/*
	 * Complete the 'maximumGroups' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY predators as parameter.
	 */

	public static int maximumGroups(List<Integer> predators) {
		Map<Integer, List<Integer>> hm = new HashMap<>();
		for (int i = 0; i < predators.size(); i++) {
			if (hm.containsKey(predators.get(i))) {
				hm.get(predators.get(i)).add(i);
			} else {
				hm.put(predators.get(i), new ArrayList<>(Arrays.asList(i)));
			}
		}
		Map<Integer, List<Integer>> output = new HashMap<>();
		List<Integer> minusOneIndex = hm.get(-1);
		Stack<levelNode> st = new Stack();

		int level = 0;
		for (Integer a : minusOneIndex) {

			levelNode node = new levelNode();
			node.data = a;
			node.level = 0;
			st.push(node);

		}
		while (!st.isEmpty()) {
			levelNode node = st.pop();
			if (output.containsKey(node.level)) {
				output.get(node.level).add(node.data);
			} else {
				output.put(node.level, new ArrayList<>(Arrays.asList(node.data)));
			}
			List<Integer> childs = hm.get(node.data);
			for (Integer a : childs) {
				levelNode node1 = new levelNode();
				node1.data = a;
				node1.level = node.level + 1;
				st.push(node1);

			}

		}
		return output.keySet().size();

	}
}

class levelNode {
	public int data;
	public int level;
}