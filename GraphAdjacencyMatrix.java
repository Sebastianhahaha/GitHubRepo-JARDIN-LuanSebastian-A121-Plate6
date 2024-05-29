//6.Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
//adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)
import java.util.*;

public class GraphAdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        // Create the adjacency matrix to represent the graph
        int[][] adjacencyMatrix = new int[vertices][vertices];

        // Prompt the user to enter the number of edges
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        // Prompt the user to enter the edges as vertex pairs
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt(); // Read the first vertex of the edge
            int vertex2 = scanner.nextInt(); // Read the second vertex of the edge

            // Add the edge to the adjacency matrix (for an undirected graph)
            adjacencyMatrix[vertex1][vertex2] = 1;
            adjacencyMatrix[vertex2][vertex1] = 1;

            // For directed graph (uncomment if directed graph)
            // adjacencyMatrix[vertex1][vertex2] = 1;
        }

        // Print the constructed adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close(); // Close the scanner
    }
}
