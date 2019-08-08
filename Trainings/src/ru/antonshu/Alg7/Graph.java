package ru.antonshu.Alg7;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int vertexCount;
    private int edgeCount = 0;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Количество вершин не может быть < 0");
        }
        this.vertexCount = vertexCount;
        adjacencyList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public LinkedList<Integer> getAdjacancyList(int vertex) {
        return (LinkedList<Integer>) adjacencyList[vertex].clone();
    }

    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex2 < 0 || vertex1 >= vertexCount || vertex2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
        edgeCount++;
    }

    public void addManyEdges(int sourceVertex, int... edges) {
        if (sourceVertex < 0 || sourceVertex >= vertexCount) {
            throw new IllegalArgumentException("Источник не принадлежит этому графу");
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] < 0 || edges[i] >= vertexCount) {
                throw new IllegalArgumentException("Связи выходят за пределы графа");
            }
        }
        for (int i = 0; i < edges.length; i++) {
            List currentVertexAdjList = getAdjacancyList(edges[i]);
            if (!currentVertexAdjList.contains(sourceVertex)) { //добавляем связь только если это новая связь
                                                                //оставлять повторение связей имеет смысл только, когда у связи есть вес
                if (edges[i] != sourceVertex) {                 //проверяем, что источник не связывает себя с собой: исключаем петли
                    adjacencyList[sourceVertex].add(edges[i]);
                    adjacencyList[edges[i]].add(sourceVertex);
                    edgeCount++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Graph{");
        for (int i = 0; i < this.vertexCount; i++) {
            builder.append(i + " - ");
            builder.append(getAdjacancyList(i));
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}
