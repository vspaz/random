package trees;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public Node contains(int id) {
        Node current = root;
        while (current.id != id) {
            if (id < current.id)
                current = current.left;
            else
                current = current.right;
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double data) {
        Node node = new Node(id, data);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.id) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Node getMin() {
        Node current = root;
        Node leftMost = root;
        while (current != null) {
            leftMost = current;
            current = current.left;
        }
        return leftMost;
    }

    public Node getMax() {
        Node current = root;
        Node rightMost = root;
        while (current != null) {
            rightMost = current;
            current = current.right;
        }
        return rightMost;
    }

    public void preOrder(Node root) {
        // process current node -> visit left -> visit right;
        if (root != null) {
            System.out.println(root.id);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.id);
            inOrder(root.right);
        }
    }
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.id);
        }
    }

    public boolean remove(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeft = true;
        if (root == null)
            return false;
        while (current.id != id) {
            parent = current;
            if (id < current.id)
                current = current.left;
            else {
                isLeft = false;
                current = current.right;
            }
            if (current == null)
                return false;
        }
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeft)
                parent.left = null;
            else
                parent.right = null;
        } else if (current.left == null) {
            if (root == current)
                root = null;
            else if (isLeft)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.right == null) {
            if (current == root)
                root = null;
            else if (isLeft)
                parent.left = current.right;
            else
                parent.right = current.right;
        } else {
            Node successor = getSuccessor(root);
            if (root == current)
                root = successor;
            else if (isLeft)
                parent.left = successor;
            else
                parent.right = successor;
        }
        return true;
    }
    private Node getSuccessor(Node nodeToDel) {
        Node successor = nodeToDel;
        Node successorParent = nodeToDel;
        Node current = nodeToDel.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (current != nodeToDel.right) {
            successorParent.left = successor.right;
            successor.right = nodeToDel.right;
        }
        return successor;
    }
}