import java.util.*;

class WeightedGraph {
    private int V;
    private List<List<node>> adj;

    static class node {
        int dest, weight;

        node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    WeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdgeAndWeight(int u, int v, int w) {
        adj.get(u).add(new node(v, w));
        adj.get(v).add(new node(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<node> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.dest));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[V]; // To store the parent node of each vertex in the shortest path

        pq.add(new node(src, 0));
        dist[src] = 0;
        parent[src] = -1;

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;

            for (node v : adj.get(u)) {
                if (dist[v.dest] > dist[u] + v.weight) {
                    dist[v.dest] = dist[u] + v.weight;
                    pq.add(v);
                    parent[v.dest] = u; // Update parent of v
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": Distance = " + dist[i] + ", Path = " + getPath(parent, i));
        }
    }

    String getPath(int[] parent, int v) {
        List<String> path = new ArrayList<>();
        while (v != -1) {
            path.add(0, ""+v);
            v = parent[v];
        }
        return String.join(" -> ", path);
    }   
}

public class ShortestPath {
    public static void main(String[] args) {
        int V = 4;
        WeightedGraph graph = new WeightedGraph(V);

        graph.addEdgeAndWeight(0, 1, 10);
		graph.addEdgeAndWeight(0, 2, 20);
		graph.addEdgeAndWeight(0, 3, 100);
		graph.addEdgeAndWeight(1, 2, 10);
		graph.addEdgeAndWeight(1, 3, 30);
		graph.addEdgeAndWeight(2, 3, 50);

        graph.shortestPath(0);
    }
}
