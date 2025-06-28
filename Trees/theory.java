import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Node root;

    // Insert a new node using level-order insertion
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Delete a node by replacing it with the deepest node
    public void delete(int key) {
        if (root == null) return;

        // Find the node to delete
        Node keyNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            keyNode = queue.poll();
            if (keyNode.data == key) break;
            if (keyNode.left != null) queue.add(keyNode.left);
            if (keyNode.right != null) queue.add(keyNode.right);
        }

        // Key not found
        if (keyNode == null || keyNode.data != key) return;

        // Find deepest node and its parent
        Node lastNode = null, parentOfLast = null;
        Queue<Node> queue2 = new LinkedList<>();
        queue2.add(root);
        while (!queue2.isEmpty()) {
            lastNode = queue2.poll();
            if (lastNode.left != null) {
                queue2.add(lastNode.left);
                parentOfLast = lastNode;
            }
            if (lastNode.right != null) {
                queue2.add(lastNode.right);
                parentOfLast = lastNode;
            }
        }

        // Replace key node's data with deepest node's data
        keyNode.data = lastNode.data;

        // Remove deepest node
        if (parentOfLast == null) {
            root = null; // Tree had only one node
        } else if (parentOfLast.right == lastNode) {
            parentOfLast.right = null;
        } else {
            parentOfLast.left = null;
        }
    }

    // Pre-order traversal (Root -> Left -> Right)
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-order traversal (Left -> Root -> Right)
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Post-order traversal (Left -> Right -> Root)
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Level-order traversal (Breadth-first)
    public void levelOrder() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);

        System.out.println("Original Tree:");
        System.out.print("Pre-order:  ");
        tree.preOrder(tree.root);
        System.out.print("\nIn-order:   ");
        tree.inOrder(tree.root);
        System.out.print("\nPost-order: ");
        tree.postOrder(tree.root);
        System.out.print("\nLevel-order:");
        tree.levelOrder();

        // Delete node 20
        tree.delete(20);
        System.out.println("\n\nAfter deleting 20:");
        System.out.print("Level-order:");
        tree.levelOrder();

        // Delete node 30
        tree.delete(30);
        System.out.println("\n\nAfter deleting 30:");
        System.out.print("Level-order:");
        tree.levelOrder();
    }
}
