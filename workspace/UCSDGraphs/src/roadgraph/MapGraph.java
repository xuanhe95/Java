/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which reprsents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
package roadgraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

import geography.GeographicPoint;
import geography.RoadSegment;
import util.GraphLoader;

/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which represents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
public class MapGraph {
	//TODO: Add your member variables here in WEEK 3
	Set<Vertex> vertices;
	HashMap<GeographicPoint, Vertex> locMap;
	
	/** 
	 * Create a new empty MapGraph 
	 */
	public MapGraph()
	{
		// TODO: Implement in this constructor in WEEK 3
		vertices = new HashSet<Vertex>();
		locMap = new HashMap<GeographicPoint, Vertex>();
	}
	
	/**
	 * Get the number of vertices (road intersections) in the graph
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices()
	{
		//TODO: Implement this method in WEEK 3
		return vertices.size();
	}
	
	/**
	 * Return the intersections, which are the vertices in this graph.
	 * @return The vertices in this graph as GeographicPoints
	 */
	public Set<GeographicPoint> getVertices()
	{
		//TODO: Implement this method in WEEK 3
		return locMap.keySet();
	}
	
	/**
	 * Get the number of road segments in the graph
	 * @return The number of edges in the graph.
	 */
	public int getNumEdges()
	{
		//TODO: Implement this method in WEEK 3
		int total = 0;
		for ( Vertex vertex : vertices) {
			total += vertex.getEdges().size();
		} 
		return total;
	}

	/** Add a node corresponding to an intersection at a Geographic Point
	 * If the location is already in the graph or null, this method does 
	 * not change the graph.
	 * @param location  The location of the intersection
	 * @return true if a node was added, false if it was not (the node
	 * was already in the graph, or the parameter is null).
	 */
	public boolean addVertex(GeographicPoint location)
	{
		// TODO: Implement this method in WEEK 3
		Vertex vertex = new Vertex(location);
		locMap.put(location, vertex);
		return vertices.add(vertex);
	}
	

	
	/**
	 * Adds a directed edge to the graph from pt1 to pt2.  
	 * Precondition: Both GeographicPoints have already been added to the graph
	 * @param from The starting point of the edge
	 * @param to The ending point of the edge
	 * @param roadName The name of the road
	 * @param roadType The type of the road
	 * @param length The length of the road, in km
	 * @throws IllegalArgumentException If the points have not already been
	 *   added as nodes to the graph, if any of the arguments is null,
	 *   or if the length is less than 0.
	 */
	public void addEdge(GeographicPoint from, GeographicPoint to, String roadName,
			String roadType, double length) throws IllegalArgumentException {
		//TODO: Implement this method in WEEK 3
		// throw error if argument equals null
		if ( (!locMap.containsKey(from) && !locMap.containsKey(to) ) ||
				roadName == null || roadType == null || length < 0 ) {
			throw new IllegalArgumentException("Road type is wrong!");
		}
		
		for (Vertex vertex : vertices) {
			if ( vertex.getLocation().equals(from) ) {
				Edge road = new Edge(from, to, roadName, roadType, length);
				vertex.addEdge(road);
			}
		}
	}
	

	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return bfs(start, goal, temp);
	}
	
	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, 
			 					     GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 3
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());

		HashSet<GeographicPoint> checked = new HashSet<GeographicPoint>();
		HashMap<GeographicPoint, GeographicPoint> parents = new HashMap<GeographicPoint, GeographicPoint>();
		Queue<GeographicPoint> queue = new LinkedList<GeographicPoint>();
		
		queue.offer(start);
		while ( !queue.isEmpty()) {
			GeographicPoint curPoint = queue.poll();
			for (Edge road : locMap.get(curPoint).getEdges()) {	//get edges from the vertex
				GeographicPoint nextPoint = road.getOtherPoint(curPoint);
				if ( nextPoint.equals(goal) ) {
					parents.put( nextPoint, curPoint );	//DON'T FOGET THIS LAST POINT!!!
					return buildPath( start, goal, parents ); //if find the goal, build path
				}
				if ( checked.contains(nextPoint) ) {	//continue if checked
					continue;
				}
				nodeSearched.accept( nextPoint );
				checked.add( nextPoint );	//add to checked points
				parents.put( nextPoint, curPoint );	//record next point's parent
				queue.offer( nextPoint );
			}
		}
		return null;
	}
	
	//helper method to build the path
	private List<GeographicPoint> buildPath(GeographicPoint start, GeographicPoint goal, HashMap<GeographicPoint, GeographicPoint> parents){
		List<GeographicPoint> path = new ArrayList<GeographicPoint>();
		GeographicPoint curPoint = goal;
		while ( !curPoint.equals(start) ) {
			path.add(0, curPoint);
			curPoint = parents.get(curPoint);
		}
		path.add(0, start);
		resetDistanceAndPriority();	//every time call priority search will reset all distance and priority values in vertices

		return path;
	}
	
	private void resetDistanceAndPriority() {
		for (Vertex vertex : vertices) {
			vertex.setPriority(1/0.0);
			vertex.setDistance(0.0);
		}
	}

	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
		// You do not need to change this method.
        Consumer<GeographicPoint> temp = (x) -> {};
        return dijkstra(start, goal, temp);
	}
	
	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, 
										  GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 4
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		return prioritySearch(start, goal, nodeSearched, "DIJKSTRA");
	}
	
	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return aStarSearch(start, goal, temp);
	}
	
	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, 
											 GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		// TODO: Implement this method in WEEK 4
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		return prioritySearch(start, goal, nodeSearched, "ASTAR" );
	}
	
	//main method to conduct Dijkstra and A* search
	private List<GeographicPoint> prioritySearch(GeographicPoint start, GeographicPoint goal,
												Consumer<GeographicPoint> nodeSearched, String searchType){
		
		HashSet<GeographicPoint> checked = new HashSet<GeographicPoint>();
		HashMap<GeographicPoint, GeographicPoint> parents = new HashMap<GeographicPoint, GeographicPoint>();
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		Vertex curVertex = locMap.get(start);
		queue.offer(curVertex);
		while ( !queue.isEmpty()) {
			curVertex = queue.poll();
			GeographicPoint curPoint = curVertex.getLocation();
			System.out.println( searchType + "	" + curVertex.getLocation() );
			nodeSearched.accept(curPoint);	//show points on the map

			if ( !checked.contains(curPoint) ) {
				if ( curPoint.equals(goal) ) {
					return buildPath(start, goal, parents); //if find the goal, build path
				}
				checked.add( curPoint );	//add to checked points
				for (Edge road : curVertex.getEdges()) {	//get edges from the vertex
					GeographicPoint nextPoint = road.getOtherPoint(curPoint);
					if( !checked.contains( nextPoint )) {
						Vertex nextVertex = locMap.get(nextPoint);
						double distance = getPriority(curVertex, nextPoint);
						double priority;
						
						switch( searchType ) {
							case "DIJKSTRA":
								priority = getPriority(curVertex, nextPoint);
								break;
							case "ASTAR":
								priority = getPriority(curVertex, nextPoint, goal);
								break;
							case "ROADTYPE":
								priority = getPriority(curVertex, nextPoint, road);
								break;
							default:
								priority = getPriority(curVertex, nextPoint);
						}

						if ( priority < nextVertex.getPriority() ) {
							nodeSearched.accept(nextPoint);
							nextVertex.setPriority( priority );
							nextVertex.setDistance( distance );
							parents.put( nextPoint, curPoint );	//record next point's parent
							queue.offer( nextVertex );	//offer next vertex
						}
					}
				}
			}
		}
		return null;
	}
	
	private double getPriority (Vertex from, GeographicPoint to) {	//for Dijkstra method
		return from.getDistance() + from.getDistanceTo(to);
	}
	
	private double getPriority (Vertex from, GeographicPoint to, GeographicPoint goal) {
		double weight = from.getDistance() + from.getDistanceTo(to);	//calculate new distance
		double heuristicWeight = to.distance(goal);	//calculate heuristic distance
		return weight + heuristicWeight;
	}

	private double getPriority (Vertex from, GeographicPoint to, Edge road) {
		double weight = from.getDistanceTo(to);
		switch ( road.getType() ) {	//different weight based on road types
			case "primary":
				weight *= 0.7;
			case "secondary":
				weight *= 0.8;
			case "tertiary":
				weight *= 0.9;
			case "city street":
				weight *= 1.0;
			case "residential":
				weight *= 1.2;
			default:
				weight *= 2.0;
		}
		return from.getDistance() + weight;
	}
	
	
	public List<GeographicPoint> roadTypeSearch(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return roadTypeSearch(start, goal, temp);
	}
	
	public List<GeographicPoint> roadTypeSearch(GeographicPoint start, 
			 GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		return prioritySearch( start, goal, nodeSearched, "ROADTYPE" );
	}
	
	public static void main(String[] args)
	{
		System.out.print("Making a new map...");
		MapGraph firstMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", firstMap);
		System.out.println("DONE.");
		
		// You can use this method for testing.  
		
		
		/* Here are some test cases you should try before you attempt 
		 * the Week 3 End of Week Quiz, EVEN IF you score 100% on the 
		 * programming assignment.
		 */
		
		MapGraph simpleTestMap = new MapGraph();
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", simpleTestMap);
		
		GeographicPoint testStart = new GeographicPoint(1.0, 1.0);
		GeographicPoint testEnd = new GeographicPoint(8.0, -1.0);
		
		System.out.println("Test 1 using simpletest: Dijkstra should be 9 and AStar should be 5");
		List<GeographicPoint> testroute = simpleTestMap.dijkstra(testStart,testEnd);
		List<GeographicPoint> testroute2 = simpleTestMap.aStarSearch(testStart,testEnd);
		List<GeographicPoint> testroute3 = simpleTestMap.roadTypeSearch(testStart, testEnd);
		
		MapGraph testMap = new MapGraph();
		GraphLoader.loadRoadMap("data/maps/utc.map", testMap);
		
		// A very simple test using real data
		testStart = new GeographicPoint(32.869423, -117.220917);
		testEnd = new GeographicPoint(32.869255, -117.216927);
		System.out.println("Test 2 using utc: Dijkstra should be 13 and AStar should be 5");
		testroute = testMap.dijkstra(testStart,testEnd);
		testroute2 = testMap.aStarSearch(testStart,testEnd);
		testroute3 = testMap.roadTypeSearch(testStart, testEnd);
		
		
		// A slightly more complex test using real data
		testStart = new GeographicPoint(32.8674388, -117.2190213);
		testEnd = new GeographicPoint(32.8697828, -117.2244506);
		System.out.println("Test 3 using utc: Dijkstra should be 37 and AStar should be 10");
		testroute = testMap.dijkstra(testStart,testEnd);
		testroute2 = testMap.aStarSearch(testStart,testEnd);
		testroute3 = testMap.roadTypeSearch(testStart, testEnd);
		
		
		/* Use this code in Week 3 End of Week Quiz */
		/*MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/maps/utc.map", theMap);
		System.out.println("DONE.");

		GeographicPoint start = new GeographicPoint(32.8648772, -117.2254046);
		GeographicPoint end = new GeographicPoint(32.8660691, -117.217393);
		
		
		List<GeographicPoint> route = theMap.dijkstra(start,end);
		List<GeographicPoint> route2 = theMap.aStarSearch(start,end);

		*/
		
	}
	
}
