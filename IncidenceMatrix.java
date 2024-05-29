//7.Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
//each edge appears. The program should construct an incidence matrix for the graph.
import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of vertices
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        // Prompt the user to enter the number of edges
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        // Create the incidence matrix with dimensions [vertices][edges]
        int[][] incidenceMatrix = new int[vertices][edges];

        // Prompt the user to enter the edges (vertex pairs) and their counts
        System.out.println("Enter the edges (vertex pairs) and their counts:");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt(); // Read the first vertex of the edge
            int vertex2 = scanner.nextInt(); // Read the second vertex of the edge
            int count = scanner.nextInt();   // Read the count of this edge

            // Update the incidence matrix with edge counts
            incidenceMatrix[vertex1][i] = count;
            incidenceMatrix[vertex2][i] = count;
        }

        // Print the constructed incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
