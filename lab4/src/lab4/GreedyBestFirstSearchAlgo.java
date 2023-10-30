package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByH());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node count = frontier.poll();
			if(count.getLabel().equals(goal)) {
				return count;
			}else {
				explored.add(count);
				List<Edge> children = count.getChildren();
				for (Edge child : children) {
					Node end  = child.getEnd();
					if(!explored.contains(end) && !frontier.contains(end)) {
						frontier.add(end);
						end.setParent(count);
						end.setG(count.getG() + child.getWeight());
					}
				}
			}	
		}
		
		return null;
		
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
