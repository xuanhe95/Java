/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


/**
 * @author Your name here.
 * 
 * For the warm up assignment, you must implement your Graph in a class
 * named CapGraph.  Here is the stub file.
 *
 */
public class CapGraph implements Graph {
	HashMap<Integer, Vertex> vertices;
	HashMap<Integer, Vertex> reversed;

	public CapGraph() {
		vertices = new HashMap<>();
		reversed = new HashMap<>();
	}
	/* (non-Javadoc)
	 * @see graph.Graph#addVertex(int)
	 */
	@Override
	public void addVertex(int num) {
		// TODO Auto-generated method stub
		if(!vertices.containsKey(num)) vertices.put(num, new Vertex(num));
		if(!reversed.containsKey(num)) reversed.put(num, new Vertex(num));
	}

	/* (non-Javadoc)
	 * @see graph.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int from, int to) {
		// TODO Auto-generated method stub
		if(!vertices.containsKey(from)) addVertex(from);
		vertices.get(from).addEdge(to);
		if(!reversed.containsKey(to)) addVertex(to);
		reversed.get(to).addEdge(from);
		
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getEgonet(int)
	 */
	@Override
	public Graph getEgonet(int center) {
		// TODO Auto-generated method stub
		Graph ret = new CapGraph();
		Vertex self = vertices.get(center);
		HashSet<Integer> set = self.getNeibhors();
		
		for(Integer neibhor : self.getNeibhors()) {
			ret.addEdge(center, neibhor);
			for(Integer n : vertices.get(neibhor).getNeibhors()) {
				if(set.contains(n)) {
					ret.addEdge(neibhor, n);
				}
			}
		}
		
		
		return ret;
	}
	
	
	/* (non-Javadoc)
	 * @see graph.Graph#getSCCs()
	 */
	
	@Override

	public List<Graph> getSCCs() {
		// TODO Auto-generated method stub
		Stack<Integer> finished = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();

		for(Vertex v : vertices.values()) {
			if(!visited.contains(v.getValue())) {
				findConnections(v, visited, finished);
			}
		}
			
		visited.clear();
		List<Graph> ret = new ArrayList<Graph>();
		
		while(!finished.isEmpty()) {
			Integer v = finished.pop();
			if(!visited.contains(v)) {
				ret.add(findReversedConnections(new CapGraph(), reversed.get(v), visited));
			}
		}
		return ret;
	}
	
	private void findConnections(Vertex v, HashSet<Integer> visited, Stack<Integer> finished) {
		visited.add(v.getValue());
		for(Integer neibhor : v.getNeibhors()) {
			if(!visited.contains(neibhor)) {
				findConnections(vertices.get(neibhor), visited, finished);
			}
		}
		finished.push(v.getValue());
	}
	
	private Graph findReversedConnections(Graph g, Vertex v, HashSet<Integer> visited) {
		visited.add(v.getValue());
		g.addVertex(v.getValue());
		for(Integer neibhor : v.getNeibhors()) {
			if(!visited.contains(neibhor)) {
				g.addEdge(v.getValue(), neibhor);
				findReversedConnections(g, reversed.get(neibhor), visited);
			}
		}
		return g;
	}
	

	/* (non-Javadoc)
	 * @see graph.Graph#exportGraph()
	 */
	@Override
	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		// TODO Auto-generated method stub
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for(Vertex v : vertices.values()) {
			map.put(v.getValue(), v.getNeibhors());
		}
		return map;
	}
	
	public HashMap<Integer, Vertex> getVertices(){
		return vertices;
	}
	
	
	public static void main (String[] args) {
		test();
	}
	
	public static void test() {
		CapGraph graph= new CapGraph();

		graph.addVertex(32);
		graph.addVertex(50);
		graph.addVertex(44);
		graph.addVertex(65);
		graph.addVertex(25);
		graph.addVertex(23);
		graph.addVertex(18);
		graph.addVertex(65);


		graph.addEdge(32, 50);
		graph.addEdge(32, 44);
		graph.addEdge(44, 50);
		graph.addEdge(25, 23);
		graph.addEdge(23, 25);
		graph.addEdge(23, 18);
		graph.addEdge(18, 23);
		graph.addEdge(25, 18);
		graph.addEdge(18, 44);
		graph.addEdge(25, 65);
		graph.addEdge(65, 23);

		Graph g = graph.getEgonet(25);

		print(g.exportGraph());
		HashMap<Integer, HashSet<Integer>> map = graph.exportGraph();
		print(map);
		

		
		
		//List<Graph> gset = graph.getSCCs();
		
		//for(Graph subg : gset) {
		//	System.out.println("=========================================");
		//	print(subg.exportGraph());
		//}
		
	}
	
	private static void print(HashMap<Integer, HashSet<Integer>> map) {
		System.out.println("=========================================");
		for(Integer v : map.keySet()) {
			System.out.println(v + "	" + map.get(v));
		}
	}

}
