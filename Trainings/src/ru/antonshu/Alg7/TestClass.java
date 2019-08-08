package ru.antonshu.Alg7;

public class TestClass {

    public static void main(String[] args) {
        Graph simpleGraph = new Graph(10);
        simpleGraph.addEdge(1, 2);
        simpleGraph.addEdge(1, 4);
        simpleGraph.addEdge(1, 6);
        simpleGraph.addEdge(2, 3);
        simpleGraph.addEdge(2, 5);
        simpleGraph.addEdge(2, 7);
        simpleGraph.addEdge(2, 7); //здесь связь задваивается
//        simpleGraph.addManyEdges(1, 2, 4, 6);
//        simpleGraph.addManyEdges(2, 3, 5, 7);
        System.out.println(simpleGraph);
        System.out.println("Связей в графе: " + simpleGraph.getEdgeCount());
        System.out.println("Связи второго элемента: " + simpleGraph.getAdjacancyList(1));
        System.out.println();

        Graph customGraph = new Graph(13); //Граф с рисунка
        customGraph.addManyEdges(1, 2, 3, 10, 12);
        customGraph.addManyEdges(2, 1, 3, 4);
        customGraph.addManyEdges(3, 1, 2, 3, 4, 5, 6, 7, 9);
        customGraph.addManyEdges(4, 2, 3, 12);
        customGraph.addManyEdges(5, 3, 12);
        customGraph.addManyEdges(6, 3, 8, 9);
        customGraph.addManyEdges(7, 3);
        customGraph.addManyEdges(7, 3);
        customGraph.addManyEdges(8, 6, 12);
        customGraph.addManyEdges(9, 3, 6, 12);
        customGraph.addManyEdges(10, 1, 11, 12);
        customGraph.addManyEdges(12, 1, 4, 5, 3, 8, 9, 10, 11);

        BreadthFirstPaths bfp = new BreadthFirstPaths(customGraph, 1);
        DepthFirstPaths dfp = new DepthFirstPaths(customGraph, 1);

        System.out.println("Самый короткий/быстрый путь до 8: " + bfp.pathTo(8));
        System.out.println("Дистанция до 8: " + bfp.distTo(8));
        System.out.println("Путь до 8 при глубоком поиске: " + dfp.pathTo(8));
        System.out.println("Всего связей в графе: " + customGraph.getEdgeCount());
    }
}