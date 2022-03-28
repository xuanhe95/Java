package roadgraph;

import geography.GeographicPoint;

public class Edge {
	GeographicPoint from;
	GeographicPoint to;
	String name;
	String type;
	double length;
	
	public Edge(GeographicPoint location1, GeographicPoint location2, String roadName, String roadType, double roadLength){
		from = location1;
		to = location2;
		name = roadName;
		type = roadType;
		length = roadLength;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getDistance() {
		return from.distance(to);
	}
	
	public GeographicPoint getOtherPoint(GeographicPoint location) {
		if (location.equals(from)) {
			return to;
		}
		else if (location.equals(to)) {
			return from;
		}
		else {
			return null;
		}
	}
	
}
