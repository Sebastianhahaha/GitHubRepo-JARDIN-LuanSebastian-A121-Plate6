//1.Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
//and find the number of connected components if it is not connected
import java.util.*;


public class GraphConnectivity {
    private int vertices; // Number of vertices in the graph
    private LinkedList<Integer>[] adjList; // Adjacency list to store the graph

    // Constructor to initialize the graph with a given number of vertices
    public GraphConnectivity(int vertices) {
        this.vertices = vertices; // Set the number of vertices
        adjList = new LinkedList[vertices]; // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>(); // Create a new linked list for each vertex
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int dest) {
        adjList[source].add(dest); // Add destination vertex to the source's list
        adjList[dest].add(source); // Add source vertex to the destination's list (because the graph is undirected)
    }

    // Depth-First Search (DFS) method to traverse the graph
    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex as visited
        for (int neighbor : adjList[vertex]) { // Iterate through all the adjacent vertices
            if (!visited[neighbor]) { // If the adjacent vertex has not been visited
                DFS(neighbor, visited); // Recursively perform DFS on the adjacent vertex
            }
        }
    }

    // Method to check if the graph is connected
    public boolean isConnected() {
        boolean[] visited = new boolean[vertices]; // Array to keep track of visited vertices
        DFS(0, visited); // Perform DFS starting from vertex 0

        for (boolean v : visited) { // Check if all vertices were visited
            if (!v) { // If any vertex is not visited
                return false; // The graph is not connected
            }
        }
        return true; // All vertices were visited, the graph is connected
    }

    // Method to count the number of connected components in the graph
    public int countConnectedComponents() {
        boolean[] visited = new boolean[vertices]; // Array to keep track of visited vertices
        int count = 0; // Counter for connected components
        for (int i = 0; i < vertices; i++) { // Iterate through all vertices
            if (!visited[i]) { // If the vertex has not been visited
                DFS(i, visited); // Perform DFS starting from this vertex
                count++; // Increment the connected components counter
            }
        }
        return count; // Return the total number of connected components
    }

    // Main method to take input and check connectivity
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object for input
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt(); // Input number of vertices

        GraphConnectivity graph = new GraphConnectivity(vertices); // Create a graph with the given number of vertices

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt(); // Input number of edges

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) { // Input edges
            int source = scanner.nextInt(); // Input source vertex
            int dest = scanner.nextInt(); // Input destination vertex
            graph.addEdge(source, dest); // Add the edge to the graph
        }

        if (graph.isConnected()) { // Check if the graph is connected
            System.out.println("The graph is connected.");
        } else { // If the graph is not connected
            int connectedComponents = graph.countConnectedComponents(); // Count the number of connected components
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close(); // Close the scanner
    }
}

