import java.util.*;

public class DFS {
    // Static inner class to represent an edge
    static class Edge {
        int source; // Source vertex
        int destination; // Destination vertex

        // Constructor
        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class GraphStructure {
        int vertices; // Number of vertices
        int[][] adjacencyMatrix; // Adjacency Matrix representation

        // Constructor
        GraphStructure(int vertices) {
            this.vertices = vertices;
            adjacencyMatrix = new int[vertices][vertices]; // Initialize the adjacency matrix

            // Taking user input for the adjacency matrix
            System.out.println("Enter the adjacency matrix (0 for no edge, 1 for an edge):");
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjacencyMatrix[i][j] = scanner.nextInt();
                }
            }
        }

        // dfs traversal method
        void dfs(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Track visited vertices
            Stack<Integer> stck = new Stack<>(); // Create a stck for dfs

            visited[startVertex] = true; // Mark the starting vertex as visited
            stck.push(startVertex); // Enstck the starting vertex

            while (!stck.isEmpty()) {
                int vertex = stck.pop(); // Destck a vertex
                System.out.print(vertex + " "); // Print the destckd vertex

                // Explore all adjacent vertices
                for (int i = 0; i < vertices; i++) {
                    // Check if there is an edge and if the vertex is not visited
                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        visited[i] = true; // Mark as visited
                        stck.push(i); // Enstck the neighbor
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt(); // Get the number of vertices from user

        // Create a graph with the given number of vertices
        GraphStructure graph = new GraphStructure(numberOfVertices);

        System.out.print("Enter the starting vertex for dfs: ");
        int startVertex = scanner.nextInt(); // Get the starting vertex for dfs

        System.out.println("dfs traversal starting from vertex " + startVertex + ":");
        graph.dfs(startVertex); // Perform dfs starting from the specified vertex
    }
}
