package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node count = frontier.poll();
			if(count.getLabel().equals(goal)) {
				return count;
			}else {
				List<Edge> children = count.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					if(!explored.contains(end) && !frontier.contains(end)) {
						frontier.add(end);
						end.setParent(count);
						end.setG(count.getG() + child.getWeight());
					}else if(frontier.contains(end)) {
						
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
