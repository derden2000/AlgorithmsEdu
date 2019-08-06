package ru.antonshu.Alg7;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;
    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph graph, int source) {
        this.source = source;
        edgeTo = new int[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];
        distTo = new int[graph.getVertexCount()];
        Arrays.fill(distTo, INFINITY);
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int target : graph.getAdjacancyList(vertex)) {
                if (!marked[target]) {
                    marked[target] = true;
                    edgeTo[target] = vertex;
                    distTo[target] = distTo[vertex] + 1;
                    queue.addLast(target);
                }
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public LinkedList<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vert = vertex;
        while (vert != source) {
            stack.push(vert);
            vert = edgeTo[vert];
        }
        return stack;
    }

    public int distTo(int vertex) {
        return distTo[vertex];
    }

}
