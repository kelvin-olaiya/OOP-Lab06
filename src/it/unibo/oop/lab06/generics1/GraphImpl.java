package it.unibo.oop.lab06.generics1;
import java.util.*;

public class GraphImpl<N> implements Graph<N> {
	private final Set<N> nodes;
	private final Map<N, Set<N>> edges;
	
	public GraphImpl() {
		nodes = new HashSet<>();
		edges = new HashMap<>();
	}

	public void addNode(N node) {
		if (!Objects.isNull(node) && nodes.add(node)) {
			edges.put(node, new HashSet<>());
		}
	}

	public void addEdge(N source, N target) {
		nodes.add(source);
		nodes.add(target);
		edges.get(source).add(target);
	}

	public Set<N> nodeSet() {
		return Set.copyOf(this.nodes);
	}

	public Set<N> linkedNodes(N node) {
		return Set.copyOf(this.edges.get(node));
	}
	
	private List<N> pathBFS(N source, N target, List<N> path) {
		if (this.linkedNodes(source).contains(target)) {
			path.addAll(0, List.of(source, target));
			return path;
		}
		for(N node : this.linkedNodes(source)) {
			if (this.pathBFS(node, target, path).contains(target) && !path.contains(source)) {
				path.add(0, source);
				break;
			}
		}
		return path;
	}

	public List<N> getPath(N source, N target) {
		return this.pathBFS(source, target, new ArrayList<N>());
	}

	public Map<N, Set<N>> getMap() {
		return this.edges;
	}

}
