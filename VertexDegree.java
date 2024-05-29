//4.Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of
//vertex
import java.util.*;

public class VertexDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        // Create an array to store the degree of each vertex
        int[] degree = new int[vertices];

        // Read the edges and update the degree of each vertex
        System.out.println("Enter the edges (pairs of vertices):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt(); // First vertex of the edge
            int v = scanner.nextInt(); // Second vertex of the edge
            degree[u]++; // Increment the degree of vertex u
            degree[v]++; // Increment the degree of vertex v
        }

        // Print the degree of each vertex
        System.out.println("Degree of each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }

        scanner.close();
    }
}
