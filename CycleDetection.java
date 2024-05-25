import java.util.*;

public class CycleDetection {
    private int vertices; // Number of vertices in the graph
    private List<List<Integer>> adjList; // Adjacency list to represent the graph

    public CycleDetection(int vertices) {
        this.vertices = vertices; // Initialize the number of vertices
        adjList = new ArrayList<>(vertices); // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Create an empty list for each vertex
        }
    }

    public void addEdge(int source, int dest) {
        adjList.get(source).add(dest); // Add an edge between source and destination
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices]; // Array to keep track of visited vertices
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, -1)) {
                return true; // If a cycle is detected, return true
            }
        }
        return false; // If no cycle is detected, return false
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true; // Mark the current vertex as visited
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) { // If the neighbor has not been visited
                if (hasCycleUtil(neighbor, visited, vertex)) {
                    return true; // If a cycle is detected in the neighbor's subtree, return true
                }
            } else if (neighbor != parent) {
                return true; // If the neighbor is visited and not the parent, there is a cycle
            }
        }
        return false; // If no cycle is detected in the subtree, return false
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt(); // Input number of vertices

        CycleDetection graph = new CycleDetection(vertices); // Create a graph object

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt(); // Input number of edges

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt(); // Input source vertex of edge
            int dest = scanner.nextInt(); // Input destination vertex of edge
            graph.addEdge(source, dest); // Add the edge to the graph
        }

        if (graph.hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }
}
