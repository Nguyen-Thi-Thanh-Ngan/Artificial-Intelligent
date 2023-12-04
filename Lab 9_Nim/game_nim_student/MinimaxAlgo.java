package game_nim_student;

import java.util.ArrayList;
import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int v = Integer.MIN_VALUE;
		if(node.isTerminal()) {
			return v;
		}else {
			for (Node child : node.getSuccessors()) {
				v = Math.max(v, minValue(child));
			}
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int v = Integer.MAX_VALUE;
		if(node.isTerminal()) {
			return v;
		}else {
			for (Node child : node.getSuccessors()) {
				v = Math.min(v, maxValue(child));
			}
		}
		return v;
	}
}
