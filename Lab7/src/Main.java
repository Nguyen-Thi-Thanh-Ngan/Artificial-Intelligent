
public class Main {
	public static void main(String[] args) {
		Queen queen = new Queen(8, 8);
		int n = 8;
		Queen[] state = new Queen[n];
		Node node = new Node(state);
		System.out.println(node);
	}
}
