import java.util.*;

public class TopologicalSort {

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

        void topologicalSortUtil(Stack<Integer> stack, boolean[] visited, int vertex)
        {
            visited[vertex] = true;
            for(int i = 0;i<vertex;i++)
            {
                if(adjacencyMatrix[vertex][i]==1 && !visited[i])
                {
                    topologicalSortUtil(stack, visited, vertex);
                }
            }
            stack.push(vertex);

        }
        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[vertices];
            for(int i = 0;i<vertices;i++)
            {
                if(!visited[i])
                {
                    topologicalSortUtil(stack, visited, i);
                }
            }
            while(!stack.isEmpty())
            {
                System.out.print(stack.pop()+" ");
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt(); 

        GraphStructure graph = new GraphStructure(numberOfVertices);

        System.out.println("Topological sort of the given graph:");
        graph.topologicalSort(); // Perform topological sort
    }
}
