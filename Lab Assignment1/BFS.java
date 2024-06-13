import java.util.*;

public class BFS {

    void doBFS(Graph graph){
        List<List<Integer>> graphCopy = graph.graph;
        Queue<Integer> open = new LinkedList<>();
        boolean[] visited = new boolean[graphCopy.size()];
        List<Integer> path = new ArrayList<>();
        open.add(0);
        visited[0]=true;
        while(!open.isEmpty()){
            int n = open.poll();
            path.add(n);
            for(int adj : graphCopy.get(n)){
                if(!visited[adj]){
                    open.add(adj);
                    visited[adj]=true;
                }
            }  
        }
        printBFS(path);
    }
    private void printBFS(List<Integer> path) {
        int n = 0;
        for(int v : path){
            n+=1;
            System.out.print(v);
            if(n!=path.size()){
                System.out.print("->");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        BFS bfs = new BFS();
        bfs.doBFS(graph);
    }
}
