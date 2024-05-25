import java.util.*;

public class GraphIsomorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices for the first graph
        System.out.println("Enter the number of vertices for the first graph:");
        int vertices1 = scanner.nextInt();

        // Read the adjacency matrix for the first graph
        int[][] adjacencyMatrix1 = readAdjacencyMatrix(scanner, vertices1);

        // Read the number of vertices for the second graph
        System.out.println("Enter the number of vertices for the second graph:");
        int vertices2 = scanner.nextInt();

        // Read the adjacency matrix for the second graph
        int[][] adjacencyMatrix2 = readAdjacencyMatrix(scanner, vertices2);

        // Check if the two graphs are isomorphic
        boolean isIsomorphic = checkIsomorphism(adjacencyMatrix1, adjacencyMatrix2);

        // Print the result
        if (isIsomorphic) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }

    // Method to read the adjacency matrix from the input
    private static int[][] readAdjacencyMatrix(Scanner scanner, int vertices) {
        System.out.println("Enter the adjacency matrix for the graph:");
        int[][] adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        return adjacencyMatrix;
    }

    // Method to check if two graphs are isomorphic
    private static boolean checkIsomorphism(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2) {
        // Check if the number of vertices is the same
        if (adjacencyMatrix1.length != adjacencyMatrix2.length) {
            return false;
        }

        // Check if the adjacency matrices have the same structure
        // (This is a very simplified approach and may not be sufficient for all cases)
        // You may need to implement more sophisticated algorithms for larger graphs
        Set<String> graph1Structure = getGraphStructure(adjacencyMatrix1);
        Set<String> graph2Structure = getGraphStructure(adjacencyMatrix2);

        return graph1Structure.equals(graph2Structure);
    }

    // Method to get the structure of a graph represented by its adjacency matrix
    private static Set<String> getGraphStructure(int[][] adjacencyMatrix) {
        Set<String> structure = new HashSet<>();
        for (int[] row : adjacencyMatrix) {
            StringBuilder sb = new StringBuilder();
            for (int value : row) {
                sb.append(value);
            }
            structure.add(sb.toString());
        }
        return structure;
    }
}
