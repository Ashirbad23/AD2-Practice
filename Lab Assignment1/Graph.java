import java.util.*;

public class Graph {

    List<List<Integer>> graph;
    int v;
    Graph(int v){
        this.v=v;
        graph = new LinkedList<>();
        for(int i=0 ; i<v ; i++){
            graph.add(i, new LinkedList<>());
        }
    }
    void addEdge(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    void print(){
        for(int i=0 ; i<v ; i++){
            System.out.println(i+":"+graph.get(i));
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.print();
    }
}