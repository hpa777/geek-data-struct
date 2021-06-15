package lesson7;

import java.util.Deque;
import java.util.Queue;

public class Test7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
//        testBfs();
        testFindShortestWay();
    }

    private static void testFindShortestWay() {
        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Москва", "Липецк");
        graph.addEdge("Липецк", "Тула", "Воронеж");
        graph.addEdge("Воронеж", "Липецк", "Саратов", "Курск");
        graph.addEdge("Рязань", "Москва", "Тамбов");
        graph.addEdge("Тамбов", "Рязань", "Саратов");
        graph.addEdge("Саратов", "Тамбов", "Воронеж");
        graph.addEdge("Калуга", "Москва", "Орел");
        graph.addEdge("Орел", "Калуга", "Курск");
        graph.addEdge("Курск", "Орел", "Воронеж");


        Deque<Vertex> path = graph.findShortestWay("Москва", "Воронеж");
        System.out.println("ShortestWay:");
        while (!path.isEmpty()) {
            System.out.println(path.pollLast().getLabel());
        }
        System.out.println("---------------");
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", "C");
        graph.addEdge("B", "A", "C", "D");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }
}
