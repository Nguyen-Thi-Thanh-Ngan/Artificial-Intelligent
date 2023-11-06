package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node count = frontier.poll();
			if(count.getH() == 0) {
				return count;
			}else {
				explored.add(count);
				List<Node> children = model.getSuccessors(count);
				for (Node child : children) {
					if(!frontier.contains(child) && !explored.contains(child)) {
						child.setH(count.getG()+1);
						frontier.add(child);
					}
				}
			}	
		}
		return null;	
	}
}
