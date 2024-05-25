import java.util.*;

public class CycleDetection {
    private int vertices;
    private List<List<Integer>> adjList;

    public CycleDetection(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest) {
        adjList.get(source).add(dest);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        CycleDetection graph = new CycleDetection(vertices);

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(source, dest);
        }

        if (graph.hasCycle()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }
}
