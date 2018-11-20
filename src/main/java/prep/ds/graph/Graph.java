package prep.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    private int V;
    private List<List<Integer>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    private void DFSUtil(int start, boolean[] visited) {
        System.out.println(start + "  ");
        visited[start] = true;
        for (int node : adjList.get(start)) {
            if (!visited[node]) {
                DFSUtil(node, visited);
            }
        }
    }

    private boolean hasCycleUtil(int start, int[] status) {
        if (status[start] == 1) {
            return true;
        }
        if (status[start] == 2) {
            return false;
        }
        status[start] = 1;
        for (int node : adjList.get(start)) {
            if (hasCycleUtil(node, status)) {
                return true;
            }
        }
        status[start] = 2;
        return false;
    }

    public boolean hasCycle(int start) {
        int[] status = new int[V];
        Arrays.fill(status, 0);

        return hasCycleUtil(start, status);

    }

    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println(g.hasCycle(0));


    }


}
