import java.util.*;

class Graph {
    private final Map<String, Map<String, Integer>> adjacencyMap = new HashMap<>();

    public void addLocation(String location) {
        adjacencyMap.putIfAbsent(location, new HashMap<>());
    }

    public void addRoute(String from, String to, int distance) {
        adjacencyMap.get(from).put(to, distance);
        adjacencyMap.get(to).put(from, distance); // For undirected graph
    }

    public void displayGraph() {
        System.out.println("Graph Structure:");
        for (var entry : adjacencyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void findShortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Map<String, String> previousNodes = new HashMap<>();
        
        for (String node : adjacencyMap.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (var neighbor : adjacencyMap.get(current).entrySet()) {
                int newDist = distances.get(current) + neighbor.getValue();
                if (newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDist);
                    previousNodes.put(neighbor.getKey(), current);
                    queue.add(neighbor.getKey());
                }
            }
        }

        System.out.println("Shortest path from " + start + " to " + end + ":");
        String step = end;
        while (step != null) {
            System.out.print(step + " ");
            step = previousNodes.get(step);
        }
        System.out.println("\nDistance: " + distances.get(end));
    }
}

public class ShortestPathFinder {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addLocation("A");
        graph.addLocation("B");
        graph.addLocation("C");
        graph.addRoute("A", "B", 5);
        graph.addRoute("B", "C", 10);
        graph.addRoute("A", "C", 15);
        
        graph.displayGraph();
        graph.findShortestPath("A", "C");
    }
}
