package Comp.GSGR_PMW3;

import java.util.*;

public class LargestTree {
    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        // Step 1: Identify all nodes that are roots
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        // Collect all nodes and children from the input map
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            allNodes.add(entry.getKey());       // Add child
            allNodes.add(entry.getValue());    // Add parent
            children.add(entry.getKey());      // Mark child
        }

        // Roots are all nodes that are not children
        Set<Integer> roots = new HashSet<>(allNodes);
        roots.removeAll(children);

        // Step 2: Build an adjacency list representation of the forest
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (Integer node : allNodes) {
            adjacencyList.put(node, new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            int child = entry.getKey();
            int parent = entry.getValue();
            adjacencyList.get(parent).add(child); // Build parent-to-child mapping
        }

        // Step 3: Perform BFS/DFS from each root to calculate the size of its tree
        int largestSize = 0;
        int smallestRootId = Integer.MAX_VALUE;

        for (Integer root : roots) {
            int treeSize = calculateTreeSize(root, adjacencyList);

            // Update largest tree size and smallest root ID accordingly
            if (treeSize > largestSize) {
                largestSize = treeSize;
                smallestRootId = root;
            } else if (treeSize == largestSize) {
                smallestRootId = Math.min(smallestRootId, root);
            }
        }

        // Step 4: Return the smallest root ID of the largest tree
        return smallestRootId;

    }

    // Helper function: Perform DFS to calculate the size of a tree
    private static int calculateTreeSize(Integer root, Map<Integer, List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        visited.add(root);

        int size = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            size++;

            for (Integer neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return size;
    }

    // Main function to test the code
    public static void main(String[] args) {
        Map<Integer, Integer> immediateParent = new HashMap<>();
        immediateParent.put(1, 2);
        immediateParent.put(3, 4);

        System.out.println(largestTree(immediateParent)); // Expected output: 2
    }
}
