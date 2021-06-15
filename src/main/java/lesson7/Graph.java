package lesson7;

import java.util.Deque;
import java.util.Queue;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    Deque<Vertex> findShortestWay(String startLabel, String endLabel);

}
