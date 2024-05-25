import java.util.*;

public class BipartiteGraph {
    private int vertices; // Number of vertices in the graph
    private List<List<Integer>> adjList; // Adjacency list to represent the graph

    // Constructor to initialize the graph with a given number of vertices
    public BipartiteGraph(int vertices) {
        this.vertices = vertices; // Initialize the number of vertices
        adjList = new ArrayList<>(vertices); // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Create an empty list for each vertex
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int dest) {
        adjList.get(source).add(dest); // Add an edge from source to destination
        adjList.get(dest).add(source); // For an undirected graph, add an edge from destination to source
    }

    // Method to check if the graph is bipartite
    public boolean isBipartite() {
        int[] colors = new int[vertices]; // Array to store colors of vertices (-1: uncolored, 0: color 1, 1: color 2)
        Arrays.fill(colors, -1); // Initialize colors to uncolored (-1)

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1 && !isBipartiteUtil(i, colors, 0)) { // If the vertex is uncolored and not visited yet
                return false; // If it's not possible to color the graph bipartitely, return false
            }
        }
        return true; // If all vertices can be colored bipartitely, return true
    }

    // Utility method for DFS traversal to check bipartiteness
    private boolean isBipartiteUtil(int vertex, int[] colors, int color) {
        colors[vertex] = color; // Assign color to the current vertex

        // Traverse through all neighbors of the current vertex
        for (int neighbor : adjList.get(vertex)) {
            if (colors[neighbor] == -1) { // If the neighbor is uncolored
                if (!isBipartiteUtil(neighbor, colors, 1 - color)) { // Recursively color the neighbor with the opposite color
                    return false; // If coloring is not possible, return false
                }
            } else if (colors[neighbor] == color) { // If the neighbor is already colored with the same color
                return false; // Graph is not bipartite, return false
            }
        }
        return true; // If all neighbors can be colored properly, return true
    }

    // Main method to take input and check bipartiteness
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt(); // Input number of vertices

        BipartiteGraph graph = new BipartiteGraph(vertices); // Create a graph object

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt(); // Input number of edges

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt(); // Input source vertex of edge
            int dest = scanner.nextInt(); // Input destination vertex of edge
            graph.addEdge(source, dest); // Add the edge to the graph
        }

        if (graph.isBipartite()) { // Check if the graph is bipartite
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
}
