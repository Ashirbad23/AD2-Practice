import java.util.*;

public class DFS {

    void doDFS(Graph graph){
        List<List<Integer>> graphCopy = graph.graph;
        Stack<Integer> open = new Stack<>();
        boolean[] visited = new boolean[graphCopy.size()];
        List<Integer> path = new ArrayList<>();
        open.add(0);
        visited[0]=true;
        while(!open.isEmpty()){
            int n = open.pop();
            path.add(n);
            for(int adj : graphCopy.get(n)){
                if(!visited[adj]){
                    open.add(adj);
                    visited[adj]=true;
                }
            }  
        }
        printDFS(path);
    }
    private void printDFS(List<Integer> path) {
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
        DFS dfs = new DFS();
        dfs.doDFS(graph);
    }
}
