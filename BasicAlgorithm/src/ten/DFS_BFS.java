package ten;

import java.util.LinkedList;
import java.util.Queue;

enum State {

    Unvisited,Visiting,Visited;

}
class Node {

    public Node[] child;
    public int childCount;
    private String vertex;
    public State state;

    public Node(String vertex)
    {
        this.vertex = vertex;
    }

    public Node(String vertex, int childlen)
    {
        this.vertex = vertex;
        childCount = 0;
        child = new Node[childlen];
    }

    public void addChildNode(Node adj)
    {
        adj.state = State.Unvisited;
        if(childCount < 30)
        {
            this.child[childCount] = adj;
            childCount++;
        }
    }

    public Node[] getChild()
    {
        return child;
    }

    public String getVertex()
    {
        return vertex;
    }

}
public class DFS_BFS {

	static Node createGraph() {

		Node[] temp = new Node[8];
        temp[0] = new Node("A", 3);
        temp[1] = new Node("B", 3);
        temp[2] = new Node("C", 1);
        temp[3] = new Node("D", 1);
        temp[4] = new Node("E", 1);
        temp[5] = new Node("F", 1);

        temp[0].addChildNode(temp[1]);
        temp[0].addChildNode(temp[2]);
        temp[0].addChildNode(temp[3]);

        temp[1].addChildNode(temp[0]);
        temp[1].addChildNode(temp[4]);
        temp[1].addChildNode(temp[5]);

        temp[2].addChildNode(temp[0]);
        temp[3].addChildNode(temp[0]);
        temp[4].addChildNode(temp[1]);
        temp[5].addChildNode(temp[1]);
        return temp[0];

	}

	static void dfs(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.getVertex() + "\t");
		root.state = State.Visited;
		for (Node n : root.getChild()) {
			if (n.state == State.Unvisited) {
				dfs(n);
			}
		}
	}
	static void bfs(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		root.state = State.Visited;
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node r = queue.remove();
			System.out.print(r.getVertex() + "\t");
			for (Node n : r.getChild()) {
				if (n.state == State.Unvisited) {
					queue.add(n);
					n.state = State.Visited;
				}
			}
		}
		return;
	} 
	public static void main(String[] args) {
		Node root = createGraph();
		dfs(root);
		System.out.println();
		Node root1 = createGraph();
		bfs(root1);
	}
}
