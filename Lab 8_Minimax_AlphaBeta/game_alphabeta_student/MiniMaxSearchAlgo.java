package game_alphabeta_student;

import java.util.Collections;
import java.util.List;
import java.lang.*;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node, int alpha, int beta) {
		int v = Integer.MIN_VALUE;
		List<Node> children = node.getChildren();
		for(Node child : children) {
			v = Math.max(v, minValue(child, alpha, beta));
			if(v > beta) {
				return v;
			}
			alpha = Math.max(alpha, v);
			return v;
		}
		return Integer.MIN_VALUE;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node, int alpha, int beta) {
		int v = Integer.MAX_VALUE;
		List<Node> children = node.getChildren();
		for(Node child : children) {
			v = Math.min(v, maxValue(child, alpha, beta));
			if(v < alpha) {
				return v;
			}
			beta = Math.min(beta, v);
			return v;
		}
		return Integer.MAX_VALUE;
	}
}
