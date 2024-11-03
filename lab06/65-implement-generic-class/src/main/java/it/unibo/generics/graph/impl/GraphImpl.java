package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    private final Map<N, Set<N>> edges = new HashMap<>();

    @Override
    public void addNode(N node) {
        Set<N> connenctions = new HashSet<>();
        edges.putIfAbsent(node, connenctions);
    }

    @Override
    public void addEdge(N source, N target) {
        if (!edges.containsKey(source) || !edges.containsKey(target)) {
            return;
        }
        edges.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return edges.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return edges.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        if (!edges.containsKey(source) || !edges.containsKey(target)) {
            return null;
        }

        return Search(source, target);
    }

    public List<N> Search(N source, N target) {
        List<N> path = new LinkedList<>();
        Queue<N> queue = new LinkedList<>();
        List<N> alreadyVisisted = new ArrayList<>();
        Map<N, N> mapPreviousNode = new HashMap<>();

        path.add(source);
        queue.add(source);
        alreadyVisisted.add(source);

        while (!queue.isEmpty()) {
            N node = queue.remove();
            if (node.equals(target)) {
                return CompletePath(source, node, mapPreviousNode);
            }
            for (N u : edges.get(node)) {
                if (!alreadyVisisted.contains(u)) {
                    mapPreviousNode.put(u, node);
                    queue.add(u);
                    alreadyVisisted.add(u);
                }
            }

        }
        path.clear();
        return path;
    }

    public List<N> CompletePath(N source, N target, Map<N, N> mapPreviousNode) {
        List<N> completedPath = new LinkedList<>();
        N temp = target;
        while (temp != null) {
            completedPath.add(temp);
            temp = mapPreviousNode.get(temp);
        }
        return completedPath.reversed();
    }

}
