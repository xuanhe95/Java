package roadgraph;

import java.util.ArrayList;
import java.util.List;

import geography.GeographicPoint;

public class Vertex implements Comparable<Vertex> {
	private GeographicPoint location;
	private double distance;
	private List<Edge> edges;
	private double priority;
	
	//constructor

	
	public Vertex(GeographicPoint loc) {
		location = loc;
		distance = 0.0;
		priority = 1/0.0;
		edges = new ArrayList<Edge>();
		
	}
	
	public GeographicPoint getLocation() {
		return location;
	}
	
	public void setDistance(double dis) {
		distance = dis;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public double getPriority() {
		return priority;
	}
	
	public void setPriority(double weight) {
		priority = weight;
	}
	//return distance with another geographic point
	public double getDistanceTo(GeographicPoint other) {
		return location.distance(other);
	}

	@Override
	public int compareTo(Vertex o) {
		double thisPriority = getPriority();
		double otherPriority = o.getPriority();
		if (thisPriority < otherPriority) {
			return -1;
		}
		else if (thisPriority > otherPriority) {
			return 1;
		}
		else {
			return 0;
		}
	}


	
	
}
