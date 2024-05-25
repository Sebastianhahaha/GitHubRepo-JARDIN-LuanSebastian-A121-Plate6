import java.util.*;

public class AdjacencyMatrixGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjMatrix = new int[vertices][vertices];

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // Create a map to store the count of each edge
        Map<String, Integer> edgeCountMap = new HashMap<>();

        // Traverse the adjacency matrix to find and count edges
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) { // Start j from i to avoid counting twice
                if (adjMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCountMap.put(edge, adjMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge " + entry.getKey() + ": " + entry.getValue() + " time(s)");
        }

        scanner.close();
    }
}
