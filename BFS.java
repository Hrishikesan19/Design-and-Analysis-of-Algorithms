import java.util.*;

public class BFS {
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

        // BFS traversal method
        void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Track visited vertices
            Queue<Integer> queue = new LinkedList<>(); // Create a queue for BFS

            visited[startVertex] = true; // Mark the starting vertex as visited
            queue.add(startVertex); // Enqueue the starting vertex

            while (!queue.isEmpty()) {
                int vertex = queue.poll(); // Dequeue a vertex
                System.out.print(vertex + " "); // Print the dequeued vertex

                // Explore all adjacent vertices
                for (int i = 0; i < vertices; i++) {
                    // Check if there is an edge and if the vertex is not visited
                    if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                        visited[i] = true; // Mark as visited
                        queue.add(i); // Enqueue the neighbor
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

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt(); // Get the starting vertex for BFS

        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        graph.bfs(startVertex); // Perform BFS starting from the specified vertex
    }
}
