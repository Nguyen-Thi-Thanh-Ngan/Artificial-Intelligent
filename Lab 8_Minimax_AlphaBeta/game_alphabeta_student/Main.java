package game_alphabeta_student;

public class Main {
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E", 3);
		Node f = new Node("F", 12);
		Node g = new Node("G", 8);
		Node h = new Node("H", 2);
		Node i = new Node("I", 4);
		Node j = new Node("J", 6);
		Node k = new Node("K", 14);
		Node l = new Node("L", 5);
		Node m = new Node("M", 2);
		
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		c.addChild(h);
		c.addChild(i);
		c.addChild(j);
		d.addChild(k);
		d.addChild(l);
		d.addChild(m);
		
		ISearchAlgo minimax = new MiniMaxSearchAlgo();
		minimax.execute(a);
		
		ISearchAlgo alphabeta = new AlphaBetaSearchAlgo();
		alphabeta.execute(a);
		
		
	}
}
