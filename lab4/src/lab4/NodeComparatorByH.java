package lab4;

import java.util.Comparator;

public class NodeComparatorByH implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		double h1 = o1.getH();
		double h2 = o2.getH();
		int result = Double.compare(h1, h2);
		if(result == 0) 
			return o1.getLabel().compareTo(o2.getLabel());
			else
		return result;
	}
	
}
