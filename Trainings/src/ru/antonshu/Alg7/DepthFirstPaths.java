package ru.antonshu.Alg7;

import java.util.LinkedList;

public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph graph, int source) {
        this.source = source;
        edgeTo = new int[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int target : graph.getAdjacancyList(vertex)) {
            if (!marked[target]) {
                edgeTo[target] = vertex;
                dfs(graph, target);
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
}



