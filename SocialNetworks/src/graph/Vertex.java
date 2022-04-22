package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Vertex {
	private int val;
	private HashSet<Integer> neibhors;
	
	public Vertex(int v){
		val = v;
		neibhors = new HashSet<>();
	}
	
	public int getValue() {
		return val;
	}
	
	public void setValue(int v) {
		val = v;
	}
	
	public HashSet<Integer> getNeibhors() {
		return neibhors;
	}
	
	public void addEdge(int other) {
		neibhors.add(other);
	}
	
	public boolean equals(Vertex other) {
		return other.val == val; 
	}
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}
}
