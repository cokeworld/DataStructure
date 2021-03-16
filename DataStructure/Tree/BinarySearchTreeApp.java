package Tree;

public class BinarySearchTreeApp {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertBST(5);
        bst.insertBST(7);
        bst.insertBST(6);
        bst.insertBST(3);
        bst.insertBST(2);
        bst.insertBST(1);
        bst.insertBST(4);
        bst.insertBST(8);

        System.out.println("PrintBST >>> ");
        bst.printBST();

        System.out.println("SearchBst >>> ");
        Tree_node searchBST1 = bst.searchBST(4);
        if (searchBST1 != null) {
            System.out.println("Searching Success! Searched Key: " + searchBST1.data);
        } else {
            System.out.println("Searching Fail! There is no " + searchBST1.data);
        }
    }
}

class Tree_node {
    int data;
    Tree_node left;
    Tree_node right;

    public Tree_node() {
    }

    public Tree_node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private Tree_node root = new Tree_node();

    public Tree_node insertKey(Tree_node root, int key) {
        Tree_node p = root;
        Tree_node newNode = new Tree_node(key);

        if (p == null) {
            return newNode;
        } else if (p.data > newNode.data) {
            p.left = insertKey(p.left, key);
            return p;
        } else if (p.data < newNode.data) {
            p.right = insertKey(p.right, key);
            return p;
        } else return p;
    }

    public void insertBST(int key) {
        root = insertKey(root, key);
    }

    public Tree_node searchBST(int key) {
        Tree_node p = root;
        while (p != null) {
            if (p.data > key) {
                p = p.left;
            } else if (p.data < key) {
                p = p.right;
            } else if (p.data == key) {
                return p;
            }
        }
        return p;
    }

    public void inorder(Tree_node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(Integer.toString(root.data) + " ");
            inorder(root.right);
        }
    }

    public void printBST() {
        inorder(root);
        System.out.println();
    }
}
