//2.Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
//the number of times each edge appears.
import java.util.*;

public class AdjacencyMatrixGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading input

        // Read the number of vertices
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt(); // Input the number of vertices

        // Initialize the adjacency matrix
        int[][] adjMatrix = new int[vertices][vertices]; // Create a 2D array to store the adjacency matrix

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) { // Loop through each row
            for (int j = 0; j < vertices; j++) { // Loop through each column
                adjMatrix[i][j] = scanner.nextInt(); // Input the value of the matrix at position (i, j)
            }
        }

        // Create a map to store the count of each edge
        Map<String, Integer> edgeCountMap = new HashMap<>(); // Use a HashMap to store edges and their counts

        // Traverse the adjacency matrix to find and count edges
        for (int i = 0; i < vertices; i++) { // Loop through each row
            for (int j = i; j < vertices; j++) { // Loop through each column starting from i to avoid counting edges twice
                if (adjMatrix[i][j] > 0) { // If there is an edge (i, j)
                    String edge = i + "-" + j; // Create a string representation of the edge
                    edgeCountMap.put(edge, adjMatrix[i][j]); // Store the edge and its count in the map
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) { // Loop through each entry in the map
            System.out.println("Edge " + entry.getKey() + ": " + entry.getValue() + " time(s)"); // Print the edge and its count
        }

        scanner.close(); // Close the scanner to free up resources
    }
}
