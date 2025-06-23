package Comp.GSGR_PMW3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixTreeProblem {
    static class BST {
        private Node root;

        public BST() {
            this.root = null;
        }

        public void put(int value) {
            root = put(root, value);
        }

        private Node put(Node node, int value) {
            if (node == null) {
                Node newNode = new Node();
                newNode.val = value;
                return newNode;
            }
            if (value < node.val) {
                node.left = put(node.left, value);
            } else if (value > node.val) {
                node.right = put(node.right, value);
            }
            // Do nothing if value already exists (to avoid duplicates)
            return node;
        }

        public boolean contains(int value) {
            return contains(root, value);
        }

        private boolean contains(Node node, int value) {
            if (node == null) {
                return false;
            }
            if (value == node.val) {
                return true;
            } else if (value < node.val) {
                return contains(node.left, value);
            } else {
                return contains(node.right, value);
            }
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) return;
            inOrderTraversal(node.left, acc);
            acc.add(node.val);  // Fix: This line must be in the middle
            inOrderTraversal(node.right, acc);
        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
        }
    }

    public static void testBST() {
        final BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));
        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
    }

    private static void assertFalse(boolean rez) {
        if (rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertTrue(boolean rez) {
        if (!rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertEquals(List<Integer> expected, List<Integer> result) {
        if (!expected.equals(result)) {
            System.out.println(String.format("Test failed \"%s\" not equals to \"%s\"", expected, result));
        } else {
            System.out.println("Test passed");
        }
    }

    public static void main(String[] args) {
        testBST();
    }
}
