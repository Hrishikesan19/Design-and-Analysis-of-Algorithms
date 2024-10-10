import java.util.*;

public class DFS {

    static class Edge {
        int source; 
        int destination; 


        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class GraphStructure {
        int vertices; 
        int[][] adjacencyMatrix;


        GraphStructure(int vertices) {
            this.vertices = vertices;
            adjacencyMatrix = new int[vertices][vertices];


            System.out.println("Enter the adjacency matrix (0 for no edge, 1 for an edge):");
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjacencyMatrix[i][j] = scanner.nextInt();
                }
            }
        }


        void dfs(int startVertex) {
            boolean[] visited = new boolean[vertices]; 
            Stack<Integer> stck = new Stack<>(); 

            visited[startVertex] = true; 
            stck.push(startVertex); 

            while (!stck.isEmpty()) {
                int vertex = stck.pop(); 
                System.out.print(vertex + " "); 


                for (int i = 0; i < vertices; i++) {

                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        stck.push(i); 
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt(); 
        
        GraphStructure graph = new GraphStructure(numberOfVertices);

        System.out.print("Enter the starting vertex for dfs: ");
        int startVertex = scanner.nextInt();
        System.out.println("dfs traversal starting from vertex " + startVertex + ":");
        graph.dfs(startVertex); 
    }
}
