import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KruskalsMST {

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int[][] adjMatrix = new int[V][V];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = sc.nextInt();
                if (i == j) {
                    adjMatrix[i][j] = 0; // No self-loops
                }
            }
        }

        List<Edge> graphEdges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (adjMatrix[i][j] != 0 && adjMatrix[i][j] != Integer.MAX_VALUE) {
                    graphEdges.add(new Edge(i, j, adjMatrix[i][j]));
                }
            }
        }

        graphEdges.sort(Comparator.comparingInt(o -> o.weight));

        kruskals(V, graphEdges);
    }

    private static void kruskals(int V, List<Edge> edges) {
        int j = 0;
        int noOfEdges = 0;

        Subset[] subsets = new Subset[V];
        Edge[] results = new Edge[V];

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        while (noOfEdges < V - 1) {
            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;
        }

        System.out.println("Edges in the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println("Edge " + (i + 1) + ": (" +
                    results[i].src + " -- " + results[i].dest +
                    ") weight: " + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of the MST: " + minCost);
    }

    private static void union(Subset[] subsets, int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = findRoot(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
}
